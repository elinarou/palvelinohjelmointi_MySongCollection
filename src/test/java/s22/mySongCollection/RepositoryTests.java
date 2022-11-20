package s22.mySongCollection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import s22.mySongCollection.domain.Song;
import s22.mySongCollection.domain.SongRepository;
import s22.mySongCollection.domain.Genre;
import s22.mySongCollection.domain.GenreRepository;
import s22.mySongCollection.domain.Instrument;
import s22.mySongCollection.domain.InstrumentRepository;

@DataJpaTest
class RepositoryTests {

	@Autowired
	SongRepository repository;
	
	@Autowired
	GenreRepository grepository;
	
	@Autowired
	InstrumentRepository irepository;

	@Test
	public void findSongByName() {
		List<Song> songs = repository.findByName("Laulu1");
		assertEquals(songs.size(), 1);
		assertEquals(songs.get(0).getArtist(), "Muusikko1");
	}
	
	@Test
	public void findGenreByName() {
		List<Genre> genres = grepository.findByName("Pop");
		assertEquals(genres.size(), 1); 
	}
	
	@Test
	public void findSongsByGenre() {
		List<Song> songs = repository.findByGenreName("Pop");
		assertEquals(songs.size(), 3); 
	}
	
	@Test
	public void findInstrumentByName() {
		List<Instrument> instruments = irepository.findByName("Piano");
		assertEquals(instruments.size(), 1); 
	}
	
	@Test
	public void findSongsByInstruments() {
		List<Song> songs = repository.findByInstrumentName("Piano");
		assertEquals(songs.size(), 2); 
	}

	@Test
	public void insertNewSong() {
		Song song = new Song("Laulu6", "Muusikko6", grepository.findByName("Pop").get(0), irepository.findByName("Piano").get(0), "https://www.google.com/");
		repository.save(song);
		assertNotNull(song.getId());
	}
	
	@Test
	public void deleteNewSong() {
		Song newSong = new Song("Laulu7", "Muusikko7", grepository.findByName("Pop").get(0), irepository.findByName("Piano").get(0), "https://www.google.com/");
		repository.save(newSong);
		List<Song> songs = repository.findByName("Laulu7");
		Song song = songs.get(0);
		repository.delete(song);
		List<Song> newSongs = repository.findByName("Laulu7");
		assertEquals(newSongs.size(), 0);
	}

}