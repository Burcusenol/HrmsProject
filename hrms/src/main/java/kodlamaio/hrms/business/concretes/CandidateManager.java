package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.utils.EmailValidate;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;



@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserDao userDao;
	private MernisService mernisService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao,MernisService mernisService,UserDao userDao) {
		super();
		this.candidateDao = candidateDao;
		this.mernisService=mernisService;
		this.userDao=userDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(candidateDao.findAll(),"Candidates listed.");

	}

	@Override
	public Result insert(Candidate candidate) {

		if (checkIfNull(candidate)) {
			return new ErrorResult("These fields cannot be blank ");	
		} else if(checkIdentityNumber(candidate)) {
			return new ErrorResult("Identity number does not greater than 11");	
		}else if(checkIfIdentityExist(candidate.getIdentityNumber())) {
			return new ErrorResult("Identity number already exists.");
		}else if(checkIfEmailExist(candidate.getEmail())) {
			return new ErrorResult("Email already exist");
		}else if(!mernisService.userValidate(candidate)) {
			return new ErrorResult();
		}else if(!EmailValidate.emailValidate(candidate.getEmail())) {
			return new ErrorResult("Email is not match");
		}else {
			
			this.candidateDao.save(candidate);
			return new SuccessResult("Candidates added");
		}


	}

	private boolean checkIfIdentityExist(String identityNumber)
	{
		if(candidateDao.findByIdentityNumber(identityNumber).isPresent()){
			return false;		
		}
		return true;
	}
	
	
	private boolean checkIfEmailExist(String email) {
		if(userDao.findByEmail(email).isPresent()) {
			return false;
		}
		return true;
	}
	
	private boolean checkIdentityNumber(Candidate candidate)
	{
		if(candidate.getIdentityNumber().length()!=11) {
			return false;		
		}
		return true;
	}
	
	private boolean checkIfNull(Candidate candidate) {
		if(!candidate.getFirstName().isEmpty()&&!candidate.getLastName().isEmpty()
				&&!candidate.getIdentityNumber().isEmpty()
				&&!candidate.getBirthDate().toString().isEmpty()&&!candidate.getEmail().isEmpty()
				&&!candidate.getPassword().isEmpty()) {
			return false;
		}
		return true;
		
	}
	
}
