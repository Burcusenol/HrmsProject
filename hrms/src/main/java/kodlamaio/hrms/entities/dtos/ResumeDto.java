package kodlamaio.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateImage;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {

	@JsonIgnore()
	private Candidate candidate;
	private List<School> schools;
	private List<CandidateLanguage> candidateLanguages;
	private List<JobExperience> jobExperiences;
	private List<SocialMedia> socialMedias;
	private List<Technology> technologies;
	private List<CandidateImage> candidateImages;
}
