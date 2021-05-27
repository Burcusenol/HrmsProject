package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employers")
public class Employer extends User{


	@NotBlank(message = "Company name is not empty")
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank(message = "Web address is not empty")
	@Column(name = "web_address")
	private String webAddress;
	
	@NotBlank(message = "Phone number is not empty")
	@Column(name = "phone_number")
	private String phoneNumber;
}
