package vn.itsol.apiviettel.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;
import vn.itsol.apiviettel.dao.CustomerDao;
import vn.itsol.apiviettel.entity.Customer;
import vn.itsol.apiviettel.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/apiviettel")
public class CustomerController
{
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	//get: findAll, findById
	@GetMapping(path = "/customers",consumes={"application/json"})
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		List<Customer> list = (List<Customer>) customerService.findAll();
		log.info("getAll().List: " + list);
		if(list.isEmpty())
		{
			return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/customer/{cus_id}",consumes={"application/json"})
	public ResponseEntity<Customer> getByIdCustomer(@PathVariable("cus_id") int cus_id)
	{
		Customer customer = customerService.findById(cus_id);
		log.info("getById().customer: " + customer);
		if(customer == null || customer.equals("") )
		{
			return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	//post: addnew
	@PostMapping(path = "/addcustomer",consumes={"application/json"})
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer)
	{
		customerService.save(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	//put: updatecustomer
	@PutMapping(path = "/updatecustomer",consumes={"application/json"})
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
	{
		customerService.save(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	//Delete
	@DeleteMapping(path = "/deletecustomer/{cus_id}", consumes = {"application/json"})
	public String removeCustomer(@PathVariable("cus_id") int cus_id)
	{
		customerService.delete(cus_id);
		return "Delete Success: " + cus_id;
	}

}
