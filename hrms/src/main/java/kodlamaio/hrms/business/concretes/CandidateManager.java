package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.CandidateService;
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



@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserDao userDao;
	private MernisService mernisService;
	private EmailService emailService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisService mernisService,UserDao userDao,EmailService emailService) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService=mernisService;
		this.userDao=userDao;
		this.emailService=emailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(candidateDao.findAll(),"Candidates listed.");

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
