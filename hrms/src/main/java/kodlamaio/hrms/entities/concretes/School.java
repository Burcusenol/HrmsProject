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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
public class School {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "school_name")
	@NotBlank(message = "School name cannot be empty!")
	private String schoolName;
	
	@Column(name = "department_name")
	@NotBlank(message = "Department name cannot be empty!")
	private String departmentName;
	
	@Column(name = "graduation_year")
	private LocalDate graduationDate;
	
	@Column(name = "started_date")
	private LocalDate startedDate;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
