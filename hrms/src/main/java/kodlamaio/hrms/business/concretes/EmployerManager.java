package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.utils.EmailValidate;
import kodlamaio.hrms.core.utilities.utils.EmployerValidateByEmployee;
import kodlamaio.hrms.core.utilities.utils.WebDomainValidate;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao) {
		super();
		this.employerDao = employerDao;
		this.userDao=userDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Employers listed");
	}

	@Override
	public Result insert(Employer employer) {
		
		if(validateRules(employer)) {
			this.employerDao.save(employer);
		return new SuccessResult("Employer added");
		}
		return new ErrorResult();
	}

	
	private boolean checkIfNull(Employer employer) {
		if(!employer.getEmail().isEmpty()&&!employer.getWebAddress().isEmpty()
				&&!employer.getCompanyName().isEmpty()
				&&!employer.getPhoneNumber().isEmpty()&&!employer.getPassword().isEmpty()) {
			return true;		
		}
		System.out.println("These fields cannot be blank ");
		return false;
	}
	
	private boolean checkIfEmailExist(String email) {
		if(userDao.findByEmail(email).isPresent()) {
			System.out.println("Email already exist");
			return false;
		}
		return true;
	}
	
	private boolean validateRules(Employer employer) {
		if(!checkIfEmailExist(employer.getEmail())&&!checkIfNull(employer)
				&&!EmailValidate.emailValidate(employer.getEmail())&&
				!WebDomainValidate.isEmailDomainCheck(employer)
				&&!EmployerValidateByEmployee.employerValidate(employer)){
			return true;
			
		}
		return false;
	}
	
}
