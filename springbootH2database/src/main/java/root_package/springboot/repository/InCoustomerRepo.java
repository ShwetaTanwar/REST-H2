package root_package.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import root_package.springboot.entity.Customer;


@Repository
public interface InCoustomerRepo extends JpaRepository<Customer, Long> {

}
