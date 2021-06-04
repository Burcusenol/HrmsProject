package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private CandidateService candidateService;
	private SchoolService schoolService;
	private JobExperienceService jobExperienceService;
	private CandidateImageService imageService;
	private CandidateLanguageService candidateLanguageService;
	private SocialMediaService socialMediaService;
	private TechnologyService technologyService;
	
	public ResumeManager(CandidateService candidateService, SchoolService schoolService,
			JobExperienceService jobExperienceService, CandidateImageService imageService,
			CandidateLanguageService candidateLanguageService, SocialMediaService socialMediaService,
			TechnologyService technologyService) {
		super();
		this.candidateService = candidateService;
		this.schoolService = schoolService;
		this.jobExperienceService = jobExperienceService;
		this.imageService = imageService;
		this.candidateLanguageService = candidateLanguageService;
		this.socialMediaService = socialMediaService;
		this.technologyService = technologyService;
	}

	@Override
	public Result insert(ResumeDto resumeDto, int candidateId) {
		Candidate candidate=candidateService.getById(candidateId).getData();
		resumeDto.setCandidate(candidate);
		
		resumeDto.getTechnologies().forEach(technology->technology.setCandidate(candidate));
		technologyService.addAll(resumeDto.getTechnologies());
		
		resumeDto.getCandidateLanguages().forEach(candidateLanguage->candidateLanguage.setCandidate(candidate));
		candidateLanguageService.addAll(resumeDto.getCandidateLanguages());
		
		resumeDto.getJobExperiences().forEach(jobExperience->jobExperience.setCandidate(candidate));
		jobExperienceService.addAll(resumeDto.getJobExperiences());
		
		resumeDto.getSchools().forEach(school->school.setCandidate(candidate));
		schoolService.addAll(resumeDto.getSchools());
		
		resumeDto.getSocialMedias().forEach(socialMedia->socialMedia.setCandidate(candidate));
		socialMediaService.addAll(resumeDto.getSocialMedias());
		
		resumeDto.getCandidateImages().forEach(candidateImage -> candidateImage.setCandidate(candidate));
        imageService.addAll(resumeDto.getCandidateImages());
		
		
		return new SuccessResult("Resume added");
	}

}
