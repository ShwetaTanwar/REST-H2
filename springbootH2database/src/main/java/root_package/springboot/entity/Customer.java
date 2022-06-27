package root_package.springboot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="TBL_CUSTOMER")
@Data
public class Customer {
	@Id
	@GeneratedValue
	  private Long id;
	  private String name;
	  private Long age;
	  private String location;
	  
	  @CreationTimestamp
	  @Column(name="created_at")
	  private Date  createAt;
	  
	  @UpdateTimestamp
	  @Column(name="updated_at")
	  private Date updateAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	  
	
	

}
