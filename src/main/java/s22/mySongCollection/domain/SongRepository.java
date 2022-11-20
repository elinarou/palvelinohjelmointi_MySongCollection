package s22.mySongCollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface SongRepository extends CrudRepository<Song, Long> {
	// find by name
	List<Song> findByName(String name);
	
	// find by artist
	List<Song> findByArtist(String artist);
	
	// find by genre
	List<Song> findByGenreName(String name);
	
	// find by instrument
	List<Song> findByInstrumentName(String name);
}
