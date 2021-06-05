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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "images")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate"})
public class CandidateImage {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@JsonIgnore()
	@Column(name = "created_date")
	private LocalDateTime createdDateTime=LocalDateTime.now();
	
	@JsonIgnore()
	@Column(name = "uploaded_date")
	private LocalDateTime uploadedDate=LocalDateTime.now();
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
