package s22.mySongCollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s22.mySongCollection.web.SongController;
import s22.mySongCollection.web.SongRestController;

@SpringBootTest
class MySongCollectionApplicationTests {

	@Autowired
	SongController songController;
	
	@Autowired
	SongRestController songRestController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(songController).isNotNull();
		assertThat(songRestController).isNotNull();
	}

}
