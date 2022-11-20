package s22.mySongCollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface InstrumentRepository extends CrudRepository<Instrument, Long> {
	List<Instrument> findByName(String name);
}
