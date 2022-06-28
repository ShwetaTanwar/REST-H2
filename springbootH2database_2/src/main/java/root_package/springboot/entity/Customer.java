package root_package.springboot.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Table(name="TBL_CUSTOMER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue
	  private Long id;
	  private String name;
	  private String  age;
	  private String location;
	  
	  @CreationTimestamp
	  @Column(name="created_at")
	  private Date  createAt;
	  
	  @Column
	  StatusSubscription statusSubcribtion;
	  
	  @UpdateTimestamp
	  @Column(name="updated_at")
	  private Date updateAt;

	

}
