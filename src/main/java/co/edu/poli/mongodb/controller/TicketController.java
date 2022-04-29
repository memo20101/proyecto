package co.edu.poli.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.mongodb.model.Ticket;
import co.edu.poli.mongodb.repository.TicketRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(tags = {"Class: TicketController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;
	
	@GetMapping("/Tickets")
	@ApiOperation(value = "*** Service Method Get All Customers ***", notes = "*** Get All Customers from MongoDB\\\\WebApp ***")
	@ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Get All Customers!!! ***")})
	public List<Ticket> getAllCustomers(){
		return ticketRepository.findAll();
	}
	
	@GetMapping("/Tickets/{id}")
	public Ticket getCustomerByID(@PathVariable String id) {
		return ticketRepository.findById(id).get();
	}
	
	@PostMapping("/Tickets")
	public Ticket saveCustomer(@RequestBody Ticket ticket){
		return ticketRepository.save(ticket);
	}
	
	@PostMapping("/TicketsList")
	public List<Ticket> saveListNutrient(@RequestBody List<Ticket> tickets) {
		return ticketRepository.saveAll(tickets);
	}
	
	@PutMapping("/Tickets/{id}")
	public Ticket updateTicket(@PathVariable String id, @RequestBody Ticket customer) {
		
		Ticket _ticket= ticketRepository.findById(id).get();
		
		_ticket.setFecha(customer.getFecha());
		_ticket.setId(customer.getId());
		_ticket.setTipDoc(customer.getTipDoc());
		_ticket.setNumDoc(customer.getNumDoc());
		_ticket.setNombre(customer.getNombre());
		_ticket.setDescTick(customer.getDescTick());
		
		ticketRepository.save(_ticket);
		
		return _ticket;
	}
	
	@DeleteMapping("/Ticket/{id}")
	public Ticket deleteCustomerById(@PathVariable String id) {
		Ticket _ticket= ticketRepository.findById(id).get();
		ticketRepository.deleteById(id);
		return _ticket;
	}
	
	@DeleteMapping("/TicketList")
	public void deleteAll() {
		ticketRepository.deleteAll();
	}
	
	//Query para encontrar el ticket por id
	@GetMapping("/find/")
	public List<Ticket> findTicket(int id){
		return ticketRepository.findTicket(id);
	}
	
	//Query para encontrar el ticket por fecha
		@GetMapping("/find2/")
		public List<Ticket> findTicket2(String fecha){
			return ticketRepository.findTicket2(fecha);
		}

	
}