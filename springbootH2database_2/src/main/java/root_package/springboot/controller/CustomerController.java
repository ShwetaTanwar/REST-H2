package root_package.springboot.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root_package.springboot.entity.Customer;
import root_package.springboot.services.InterfaceService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	InterfaceService interfaceService;
public CustomerController(InterfaceService interfaceService) {
		this.interfaceService = interfaceService;}
 @GetMapping
        public ResponseEntity <List<Customer>> getAllCustomer()
        {
	              List<Customer>customers=interfaceService.getCustomers();
			return new  ResponseEntity<>(customers,HttpStatus.OK);
         }
 
@GetMapping({"/{customerId}"})
public ResponseEntity <Customer> getCustomer(@PathVariable Long customerId)
{ 
return new  ResponseEntity<>(interfaceService.getCustomerById(customerId),HttpStatus.OK);
}
@PostMapping
public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
{ Customer var = interfaceService.insert(customer);
HttpHeaders http = new HttpHeaders();
http.add("customer", "/customers"+ var.getId().toString());
return new ResponseEntity<> (var,http,HttpStatus.CREATED);
}

@PutMapping
 ({"/{customerId}"})
public ResponseEntity<Customer> updateCustomer (@PathVariable("customerId") Long customerId , @RequestBody Customer customer)
{    interfaceService.updateCustomer(customerId, customer);
	
		return new ResponseEntity <>(interfaceService.getCustomerById(customerId), HttpStatus.OK);
} 

@DeleteMapping({"/{customerId}"})
public ResponseEntity <Customer> deleteCustomer (@PathVariable("customerId") Long customerId)
{ 
	interfaceService. deleteCustomer(customerId); 
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 
}}

