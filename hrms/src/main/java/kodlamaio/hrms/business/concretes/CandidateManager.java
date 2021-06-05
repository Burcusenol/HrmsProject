package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.ResumeDto;



@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserDao userDao;
	private MernisService mernisService;
	private EmailService emailService;
	private SchoolService schoolService;
	private JobExperienceService jobExperienceService;
	private CandidateImageService imageService;
	private CandidateLanguageService candidateLanguageService;
	private SocialMediaService socialMediaService;
	private TechnologyService technologyService;
	private CoverLetterService coverLetterService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao, MernisService mernisService,
			EmailService emailService, SchoolService schoolService, JobExperienceService jobExperienceService,
			CandidateImageService imageService, CandidateLanguageService candidateLanguageService,
			SocialMediaService socialMediaService, TechnologyService technologyService,CoverLetterService coverLetterService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.mernisService = mernisService;
		this.emailService = emailService;
		this.schoolService = schoolService;
		this.jobExperienceService = jobExperienceService;
		this.imageService = imageService;
		this.candidateLanguageService = candidateLanguageService;
		this.socialMediaService = socialMediaService;
		this.technologyService = technologyService;
		this.coverLetterService=coverLetterService;
	}

	

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(candidateDao.findAll(),"Candidates listed.");

	}
	
	@Override
	public DataResult<ResumeDto> getCandidateResumeByCandidateId(int candidateId) {
		
		ResumeDto resumeDto=new ResumeDto();
		resumeDto.setCandidate(this.candidateDao.findById(candidateId).get());
		resumeDto.setCandidateImages(this.imageService.getAllByCandidateId(candidateId).getData());
		resumeDto.setCandidateLanguages(this.candidateLanguageService.getAllByCandidateId(candidateId).getData());
		resumeDto.setJobExperiences(this.jobExperienceService.getAllByCandidateId(candidateId).getData());
		resumeDto.setSchools(this.schoolService.getAllByCandidateId(candidateId).getData());
		resumeDto.setTechnologies(this.technologyService.getAllByCandidateId(candidateId).getData());
		resumeDto.setSocialMedias(this.socialMediaService.getAllByCandidateId(candidateId).getData());
		resumeDto.setCoverLetters(this.coverLetterService.getAllByCandidateId(candidateId).getData());
		return new SuccessDataResult<ResumeDto>(resumeDto,"Resume listed.");
	}

	
	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
	}

	@Override
	public Result insert(Candidate candidate) {

		Result result=BusinessRules.run(checkIfIdentityExist(candidate.getIdentityNumber()),
				checkIfEmail(candidate),checkIfEmailExist(candidate.getEmail()),checkIfMernis(candidate));
	
		if(result.isSuccess()) {
			this.candidateDao.save(candidate);
			return new SuccessResult("Candidates added");
		}
			return result;
		}


	private Result checkIfIdentityExist(String identityNumber)
	{
		if(candidateDao.findByIdentityNumber(identityNumber).isPresent()){
			return new ErrorResult("Identity number already exists.");		
		}
		return new SuccessResult();
	}
	
	
	private Result checkIfEmailExist(String email) {
		if(userDao.findByEmail(email).isPresent()) {
			return new ErrorResult("Email already exist");
		}
		return new SuccessResult();
	}
	
	private Result checkIfMernis(Candidate candidate) {
		if(mernisService.userValidate(candidate)==false) {
			return new ErrorResult("Mernis is failed");
		}
		return new SuccessResult();
	}
	
	private Result checkIfEmail(User user) {
		if(emailService.emailSend(user)) {
			return new SuccessResult("Email send");
		}
		return new ErrorResult();
	}

	
	
	
	
}
