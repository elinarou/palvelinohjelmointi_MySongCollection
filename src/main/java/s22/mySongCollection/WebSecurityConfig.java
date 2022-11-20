package s22.mySongCollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import s22.mySongCollection.service.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		return http.authorizeRequests(auth -> {
			// permit all to: css and h2-console
			auth.antMatchers("/css/**").permitAll();
			auth.antMatchers("/h2-console/**").permitAll();
			auth.antMatchers("/h2-console").permitAll();
			// only admin: addsong and editsong
			auth.antMatchers("/addsong/**").hasAuthority("ADMIN");
			auth.antMatchers("/editsong/**").hasAuthority("ADMIN");
			// all http request will be authenticated
			auth.anyRequest().authenticated();
		})
			// h2-console configurations
			.headers().frameOptions().disable().and()
			.csrf().ignoringAntMatchers("/h2-console/**").and()
			// successful login leads to index.html
			.formLogin().defaultSuccessUrl("/index", true).and()
			// Logout is permitted for all users
			.logout().permitAll().and()
			// building
			.httpBasic(Customizer.withDefaults()).build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}