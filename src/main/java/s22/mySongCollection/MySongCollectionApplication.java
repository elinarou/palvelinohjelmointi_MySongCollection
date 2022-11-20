package s22.mySongCollection;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import s22.mySongCollection.domain.ApplicationUser;
//import s22.mySongCollection.domain.ApplicationUserRepository;
//import s22.mySongCollection.domain.Song;
//import s22.mySongCollection.domain.SongRepository;
//import s22.mySongCollection.domain.Genre;
//import s22.mySongCollection.domain.GenreRepository;
//import s22.mySongCollection.domain.Instrument;
//import s22.mySongCollection.domain.InstrumentRepository;

@SpringBootApplication
public class MySongCollectionApplication {
//	private static final Logger log = LoggerFactory.getLogger(MySongCollectionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MySongCollectionApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner demo(SongRepository repository, GenreRepository grepository, InstrumentRepository irepository, ApplicationUserRepository applicationUserRepository) {
//		return (args) -> {
//			
//			// Login profiles: user and admin
//			log.info("Users");
//			applicationUserRepository.save(new ApplicationUser("Maija", "Meikäläinen", "USER", "user",
//					"$2a$10$57kg9OGuj44FPQyaps/fvOHmP845GQHIFdjphY4ILU/LoF1sVnQPS"));
//			applicationUserRepository.save(new ApplicationUser("Elina", "Rouvinen", "ADMIN", "admin",
//					"$2a$10$7DJe9e5TiHD5hHpm029KKeVXE/waBITs/9ykEd1qhEfZZbaRVkRiW"));
//
//			log.info("Genres");
//			grepository.save(new Genre("Soundtrack"));
//			
//			log.info("Instruments");
//			irepository.save(new Instrument("Ukulele"));
//			
//			log.info("Songs");
//			repository.save(new Song("Laulu10", "Muusikko10", "https://www.google.com/", grepository.findByName("Pop").get(0), irepository.findByName("Piano").get(0)));
//			
//			log.info("fetch all songs");
//			for (Song song : repository.findAll()) {
//				log.info(song.toString());
//			}
//  		};
//  	}

}
