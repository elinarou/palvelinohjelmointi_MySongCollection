package s22.mySongCollection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.mySongCollection.domain.ApplicationUser;
import s22.mySongCollection.domain.ApplicationUserRepository;
import s22.mySongCollection.domain.Song;
import s22.mySongCollection.domain.SongRepository;
import s22.mySongCollection.domain.Genre;
import s22.mySongCollection.domain.GenreRepository;
import s22.mySongCollection.domain.Instrument;
import s22.mySongCollection.domain.InstrumentRepository;

@SpringBootApplication
public class MySongCollectionApplication {
	private static final Logger log = LoggerFactory.getLogger(MySongCollectionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MySongCollectionApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(SongRepository repository, GenreRepository grepository, InstrumentRepository irepository, ApplicationUserRepository applicationUserRepository) {
		return (args) -> {
			
			// Login profiles: user and admin
			log.info("Users");
			applicationUserRepository.save(new ApplicationUser("Maija", "Meikäläinen", "USER", "user",
					"$2a$10$57kg9OGuj44FPQyaps/fvOHmP845GQHIFdjphY4ILU/LoF1sVnQPS"));
			applicationUserRepository.save(new ApplicationUser("Elina", "Rouvinen", "ADMIN", "admin",
					"$2a$10$7DJe9e5TiHD5hHpm029KKeVXE/waBITs/9ykEd1qhEfZZbaRVkRiW"));

			log.info("Genres");
			grepository.save(new Genre("Pop"));
			grepository.save(new Genre("Rock"));
			grepository.save(new Genre("Heavy Metal"));
			grepository.save(new Genre("Soundtrack"));
			
			log.info("Instruments");
			irepository.save(new Instrument("Piano"));
			irepository.save(new Instrument("Guitar"));
			irepository.save(new Instrument("Ukulele"));
			
			log.info("Songs");
			repository.save(new Song("Laulu1", "Muusikko1", grepository.findByName("Pop").get(0), irepository.findByName("Ukulele").get(0), "https://1drv.ms/t/s!At_Ns8Y7Yy3piNxnsVPN53NmTH3S2A?e=pqPD06"));
			repository.save(new Song("Laulu2", "Muusikko2", grepository.findByName("Rock").get(0), irepository.findByName("Ukulele").get(0), "https://www.google.com/"));
			repository.save(new Song("Laulu3", "Muusikko3", grepository.findByName("Pop").get(0), irepository.findByName("Ukulele").get(0), "https://www.google.com/"));
			repository.save(new Song("Laulu4", "Muusikko4", grepository.findByName("Soundtrack").get(0), irepository.findByName("Piano").get(0), "https://www.google.com/"));
			repository.save(new Song("Laulu5", "Muusikko5", grepository.findByName("Pop").get(0), irepository.findByName("Piano").get(0), "https://www.google.com/"));
			
			log.info("fetch all songs");
			for (Song song : repository.findAll()) {
				log.info(song.toString());
			}
		};
	}

}
