package initializ.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import initializ.demo.model.Employee;
import initializ.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
  private EmployeeRepository eRepository;
  
@Override
public List<Employee> getEmployees(int pageNumber, int pageSize) { 
	Pageable pages= PageRequest.of(pageNumber, pageSize, Direction.DESC,"id");
	return eRepository.findAll(pages) . getContent() ;}

//public List<Employee> getEmployees(int pageNumber, int pageSize) { (changes to implement pagination with sorting)
	//Pageable pages= PageRequest.of(pageNumber, pageSize);
	//return eRepository.findAll(pages) . getContent() ;}
	
     // public List<Employee> getEmployees() { return eRepository.findAll();} (changes made for pagination)

@Override
	public Employee saveEmployee(Employee employee) {
		 return eRepository.save(employee);
	}

@Override
	public Employee getSingleEmployee (Long id) {
	Optional <Employee> employee=eRepository.findById(id);
	  if(employee.isPresent())
	  {  return employee.get(); }
	    throw new RuntimeException("Employee not found for input id  "+id);
	}

@Override
public void deleteEmployee(Long id) {
	eRepository.deleteById(id);
	
}

@Override
public Employee updateEmployee(Employee employee) {
	return eRepository.save(employee);
}

@Override
public List<Employee> getEmployeeByName(String name) {
	return eRepository.findByName(name);
}

@Override
public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
 return eRepository.findByNameAndLocation(name, location);
}

@Override
public List<Employee> getEmployeeByKeyword(String name) {
	Sort sort=Sort.by(Sort.Direction.DESC, "id"); //This  line added for sorting purpose
	return eRepository.findByNameContaining(name,sort);//return eRepository.findByNameContaining(name);
}

@Override
public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
	
	return eRepository.getEmployeeByNameOrLocation(name, location);
}

@Override
public Integer deleteByEmployeeName(String name) {
	
	return  eRepository.deleteEmployeeByName(name);
}

}
