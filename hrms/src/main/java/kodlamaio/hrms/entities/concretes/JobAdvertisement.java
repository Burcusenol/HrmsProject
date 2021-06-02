package kodlamaio.hrms.entities.concretes;


import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@Column(name = "employer_id")
	//private int employer_id;
	
	//@Column(name = "job_title_id")
	//private int job_title_id;
	
	//@Column(name = "city_id")
	//private int city_id;
	
	@NotBlank(message = "Description cannot be blank")
	@Column(name ="description",length = 500 )
	private String description;
	
	@Column(name = "quata")
	private int quata;
	

	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;
	

	@Column(name = "created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	@Column(name = "is_active")
	private boolean isActive;
	
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
}