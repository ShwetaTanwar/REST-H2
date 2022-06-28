package root_package.springboot.services;

import java.util.List;

import root_package.springboot.entity.Customer;

public interface InterfaceService {

	List<Customer> getCustomers();
	Customer getCustomerById(Long id);
	Customer insert(Customer customer);
	void updateCustomer(Long id, Customer customer);
	void deleteCustomer(Long customerId);
}






