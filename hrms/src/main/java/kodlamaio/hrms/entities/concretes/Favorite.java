package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "favorites")
public class Favorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "candidate_id")
	private int candidateId;
	
	@Column(name = "job_advertisement_id")
	private int jobAdvertisementId;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id",insertable = false, updatable = false)
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "job_advertisement_id",insertable = false, updatable = false)
	private JobAdvertisement jobAdvertisement;
}
