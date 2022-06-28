package root_package.springboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import root_package.springboot.entity.Customer;
import root_package.springboot.repository.InCoustomerRepo;


@Service
public class Int_Ser_Imple implements InterfaceService {
	 InCoustomerRepo inCoustomerRepo;

	 public  Int_Ser_Imple ( InCoustomerRepo inCoustomerRepo) {
		this. inCoustomerRepo = inCoustomerRepo; }

 @Override
public List<Customer>getCustomers() 
	 {
 List<Customer> customer = new ArrayList<>();	
inCoustomerRepo.findAll().forEach(customer::add); 
return customer; 
}
	 
 @Override
public Customer getCustomerById(Long id) 
{
return  inCoustomerRepo.findById(id).get();
}
	 
@Override
public Customer insert(Customer customer)
{
	return  inCoustomerRepo.save(customer);
}
	
@Override
public void updateCustomer(Long id, Customer customer)
{
	Customer var = inCoustomerRepo.findById(id).get(); //one line sysetm is remove to string method
	
	var.setName(customer.getName());
	var.setAge(customer.getAge());
	var.setLocation(customer.getLocation());
	var.setStatusSubcribtion(customer.getStatusSubcribtion());
	inCoustomerRepo.save(var);
}
@Override
public void deleteCustomer(Long customerId) 
{
	inCoustomerRepo.deleteById(customerId)	;}
}
	 
