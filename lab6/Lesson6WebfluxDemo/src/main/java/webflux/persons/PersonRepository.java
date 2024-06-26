package webflux.persons;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;


@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, String>{
	@Tailable
	Flux<Person> findByJob(String job);		 
}
