package kodlamaio.hrms.entities.abstracts;


import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotBlank(message = "Password field cannot be empty!")
	@Column(name = "password")
	private String password;
	

	@Email(message = "Email is not in the requested format!")
	@NotBlank(message = "Email field cannot be empty!")
	@Column(name = "email")
	private String email;
	
	
	@Column(name = "created_date")
	private  LocalDateTime createdDate=LocalDateTime.now();
	
	
	@Column(name = "is_active")
	private boolean isActive;
}
