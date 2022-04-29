package co.edu.poli.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.poli.mongodb.model.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String>{

	@Query("{ 'id' : {regex:?0} }")
	List<Ticket> findTicket(int id);
	
	
	@Query(value="{ 'rda' : {$gt: ?0, $lt: ?1} }")
	List<Ticket> findTicket2(String fecha);
	
}
