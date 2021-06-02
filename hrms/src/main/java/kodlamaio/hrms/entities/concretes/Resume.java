package kodlamaio.hrms.entities.concretes;


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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumes")
public class Resume {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "github_address")
	private String githubAddress;
	
	@Column(name = "linkledin_address")
	private String linkledinAddress;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	

    @JsonIgnore
	@Column(name = "created_date")
	private LocalDateTime createdDate=LocalDateTime.now();
	
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	
	@OneToMany(mappedBy = "resume")
	@JsonIgnore
	private List<Language> languages;
	
	
	@OneToMany(mappedBy = "resume")
	@JsonIgnore
	private List<Technology> technologies;
	
	@OneToMany(mappedBy = "resume")
	@JsonIgnore
	private List<School> schools;
	
	@OneToMany(mappedBy = "resume")
	@JsonIgnore
	private List<JobExperience> jobExperiences;
}
