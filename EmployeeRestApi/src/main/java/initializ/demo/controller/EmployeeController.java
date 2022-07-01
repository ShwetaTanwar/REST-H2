package initializ.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import initializ.demo.model.Employee;
import initializ.demo.service.EmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	//REading 2 values in Controller from application.properties
	@Value("${app.name}") 
	private String appName;
	@Value("${app.version}") 
	private String appVersion;
	@GetMapping("/version")
	public String getAppDetails()  {
		return appName + "-" +appVersion;}
	
	
	@GetMapping ("/employees")
	//public List<Employee> getEmployees () {
	//return eService.getEmployees();
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		return new ResponseEntity<List<Employee>>(eService.getEmployees(pageNumber,pageSize),HttpStatus.OK) ;
	}

	@GetMapping ("/employees/{id}")
	public ResponseEntity<Employee>getEmployee (@PathVariable Long id ) {
		return new ResponseEntity<Employee>(eService. getSingleEmployee (id),HttpStatus.OK) ;
	}
	

	@PostMapping("/employees")
	//public Employee saveEmployee(@Valid @RequestBody Employee employee)  {
	//return eService.saveEmployee(employee) ;
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee)  {
	return new ResponseEntity<>(eService.saveEmployee(employee), HttpStatus.CREATED) ;
	}
        
	@DeleteMapping("/employees")
	 public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {  //"""@RequestParam("id") Long id""" As it's same 
		  return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity < Employee > updateEmployee(@PathVariable Long id, @RequestBody Employee employee)  {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee), HttpStatus.OK);
	}
	
	@GetMapping("/employees/filterByName")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name) {
		return new ResponseEntity <List<Employee>>(eService.getEmployeeByName(name),HttpStatus.OK);
	}
	
	@GetMapping("/employees/findByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam String name, @RequestParam String location) {
	return new ResponseEntity<List<Employee>>(eService.getEmployeeByNameAndLocation(name, location),HttpStatus.OK);
}
	
	@GetMapping("/employees/findByKeyword")
	public ResponseEntity<List<Employee>> getEmployeeByKeyword(@RequestParam String name) {
	return new ResponseEntity<List<Employee>>(eService.getEmployeeByKeyword(name),HttpStatus.OK);
}
	
	@GetMapping("/employees/{name}/{location}")
	public ResponseEntity<List<Employee>> getEmployeeByNameOrLocation(@PathVariable String name,@PathVariable String location) {
	return new ResponseEntity<List<Employee>>(eService.getEmployeeByNameOrLocation(name,location),HttpStatus.OK);
}
	
	@DeleteMapping("employees/delete/{name}")
	public ResponseEntity<String>deleteEmployeeByName(@PathVariable String name) {
		return new ResponseEntity<String>(eService.deleteByEmployeeName(name)+"No. of records deleted",HttpStatus.OK);
	
	}
}