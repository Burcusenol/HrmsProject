package kodlamaio.hrms.entities.concretes;



import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "candidates")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
public class Candidate extends User{

	@NotBlank(message = "First name field cannot be empty!")
	@Column(name = "first_name")
	private String firstName;
	

	@NotBlank(message = "Last name field cannot be empty!")
	@Column(name = "last_name")
	private String lastName;
	

	@NotBlank(message = "Identity number field cannot be empty!")
	@Size(min =11,max = 11,message = "Identity number must be equal to 11!")
	@Column(name = "identity_number")
	private String identityNumber;

	@NotNull(message = "Birth date field cannot be empty!")
	@Column(name="birth_date")
	private LocalDate birthDate; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;
	
	@OneToMany(mappedBy = "candidate")
	private List<Image> images;
	
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "candidate")
	private List<CandidateLanguage> candidateLanguages;
	
	@OneToMany(mappedBy = "candidate")
	private List<Link> links;
	
	@OneToMany(mappedBy = "candidate")
	private List<Technology> technologies;
}
