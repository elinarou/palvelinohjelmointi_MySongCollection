package s22.mySongCollection.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s22.mySongCollection.domain.Song;
import s22.mySongCollection.domain.SongRepository;

@RestController
public class SongRestController {

	@Autowired
	SongRepository songRepository;

	// return list of songs
	@GetMapping("/songs")
	public Iterable<Song> getSongs() { // fetch and return songs
		return songRepository.findAll();
	}

	// add new song
	@PostMapping("songs")
	Song newSong(@RequestBody Song newSong) {
		return songRepository.save(newSong);
	}

	// edit song
	@PutMapping("/songs/{id}")
	Song editSong(@RequestBody Song editedSong, @PathVariable Long id) {
		editedSong.setId(id);
		return songRepository.save(editedSong);
	}

	// delete song
	@DeleteMapping("/songs/{id}")
	public Iterable<Song> deleteSong(@PathVariable Long id) {
		songRepository.deleteById(id);
		return songRepository.findAll();
	}

	// find one song
	@GetMapping("/songs/{id}")
	Optional<Song> getSong(@PathVariable Long id) {
		return songRepository.findById(id);
	}

}