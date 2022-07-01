package initializ.demo.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@Entity
@Table(name="tbl_employee")
public class Employee {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@NotBlank(message = "Name Should not ne null")//@NotEmpty will accept " " means blank space
	private String name;// @JsonProperty("full_name")  // gives alias name , now we can write full_name = "Shweta"
	
	private Long age=0L;// @JsonIgnore  // age won't show 
	private String location;
	
	@Email (message="Please Enetr the Vaild Email Address")
	private String email;
	
	@NotBlank (message = "Departmemt Should not ne null") //notNull will accept empty"" as values
	private String department;
	
	
	  @CreationTimestamp
	  @Column(name="created_at" , updatable=false)
	  private Date  createAt;
	  
	  @UpdateTimestamp
	  @Column(name="updated_at")
	  private Date updateAt;

	

}
