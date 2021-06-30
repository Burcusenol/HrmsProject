package kodlamaio.hrms.entities.concretes;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonType;

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
@PrimaryKeyJoinColumn(name = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@Table(name = "employers")
@TypeDef(name = "json",typeClass = JsonType.class)

public class Employer extends User{


	@NotBlank(message = "Company name field cannot be empty!")
	@Column(name = "company_name")
	private String companyName;
	

	@NotBlank(message = "Web address field cannot be empty!")
	@Column(name = "web_address")
	private String webAddress;

	
	@NotBlank(message = "Phone number field cannot be empty!")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "confirm_status",columnDefinition = "boolean default false")
	private boolean confirmStatus;
	
	@Column(name = "employer_update",columnDefinition = "jsonb")
	@Type(type = "json")
	private Map<String, Object> employerUpdate;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
}
