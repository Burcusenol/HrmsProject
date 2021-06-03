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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity()
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "images")
public class Image {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "created_date")
	private LocalDateTime createdDateTime=LocalDateTime.now();
	
	@Column(name = "uploaded_date")
	private LocalDateTime uploadedDate;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
}
