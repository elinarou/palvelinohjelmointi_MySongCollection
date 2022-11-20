package s22.mySongCollection.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 1, max = 50)
	@Column(name = "song_name")
	private String name;
	
	@Size(min = 1, max = 50)
	private String artist;
	
	@Size(min = 5, max = 500)
	private String url;
	
	@ManyToOne
	@JoinColumn(name="genre_id")
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name="instru_id")
	private Instrument instrument;
	


	public Song() {
		super();
	}

	public Song(String name, String artist, String url, Genre genre, Instrument instrument) {
		super();
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.instrument = instrument;
		this.url = url;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", url=" + url + "]";
	}
	

}


