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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="technologies")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Technology {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Technology name cannot be empty!")
	@Column(name = "technology_name")
	private String technologyName;
	
	@Column(name = "created_date")
	private LocalDateTime createdDateTime=LocalDateTime.now();
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "candidate_id",referencedColumnName =  "id")
	private Candidate candidate;
	
}
