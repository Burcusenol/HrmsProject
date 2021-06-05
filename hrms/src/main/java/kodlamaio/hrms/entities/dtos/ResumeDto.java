package kodlamaio.hrms.entities.dtos;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateImage;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.concretes.CoverLetter;
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
	
	private List<@Valid School> schools;
	private List<@Valid CandidateLanguage> candidateLanguages;
	private List<@Valid JobExperience> jobExperiences;
	private List<@Valid SocialMedia> socialMedias;
	private List<@Valid Technology> technologies;
	private List<@Valid CandidateImage> candidateImages;
	private List<CoverLetter> coverLetters;
}
