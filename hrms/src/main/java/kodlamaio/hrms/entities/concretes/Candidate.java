package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "candidates")


public class Candidate extends User{

	@NotBlank(message = "First name is not empty")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Last name is not empty")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "İdentity number is not empty")
	@Size(min = 11,max=11,message = "Identity number does not greater than 11")
	@Column(name = "identity_number")
	private String identityNumber;
	
	@NotBlank(message = "BirthDate is not empty")
	@Column(name="birth_date")
	private Date birthDate; 
	
}
