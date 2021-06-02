package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_experiences")
public class JobExperience {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Company name cannot be empty!")
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "Job position cannot be empty!")
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "started_date")
	private LocalDate startedDate;
	
	@Column(name = "ended_date")
	private LocalDateTime endedDate;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
	



}