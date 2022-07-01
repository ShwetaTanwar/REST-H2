package initializ.demo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import initializ.demo.model.Employee;


@Repository

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long > {
//public interface EmployeeRepository extends JpaRepository<Employee, Long > {
	
	//JPA query Methods , handling one column
	List<Employee>findByName(String name);
	
	//JPA query Methods , handling 2 columns
	List<Employee> findByNameAndLocation(String name, String location);//select * from table WHERE name="Kirtiraj" AND location="Pune"
    
	List<Employee> findByNameContaining(String name, Sort sort); 
	//List<Employee> findByLike(String "%" +keyword+"%");  Both equal to Select * table FROM where name LIKE "%raj%"
	
	//JPQL QUERY
	//variable n method args should be same else use @param(name) n use field name not column name
	@Query("From Employee WHERE name= :name OR location= :location")
	List<Employee> getEmployeeByNameOrLocation(String name, String location);
	
	//Return type will be int or void ( if query executed then it will return how many record affected 1,2,0..)
	@Transactional  //Import it from particularly org.springframework.transaction... only
	@Modifying  //if using delete, updating,reading,creating then use Modifying 
	@Query("DELETE FROM Employee WHERE name= :name")
	Integer deleteEmployeeByName(String name);
	
}
