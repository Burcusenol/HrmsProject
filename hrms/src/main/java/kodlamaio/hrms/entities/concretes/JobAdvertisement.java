package kodlamaio.hrms.entities.concretes;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private LocalDate applicationDeadline;
	

	@Column(name = "created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	@Column(name = "is_active",columnDefinition="boolean default true")
	private boolean isActive=true;
	
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "confirm_status",columnDefinition="boolean default false")
	private boolean confirmStatus=false;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="work_type_id")
	private WorkType workType;
	
	@ManyToOne()
	@JoinColumn(name ="work_time_id" )
	private WorkTimeType workTimeType;
	

	@OneToMany(mappedBy = "candidate")
	private List<Favorite> favorites;
}
