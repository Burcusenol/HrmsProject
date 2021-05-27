package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validates.EmployerValidateByEmployee;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserDao userDao;
	private EmailService emailService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao,EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.userDao=userDao;
		this.emailService=emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Employers listed");
	}

	@Override
	public Result insert(Employer employer) {

		Result result=BusinessRules.run(checkIfEmailExist(employer.getEmail()),checkIfEmployerByEmployee(employer),
				checkIfNull(employer),checkIfEmail(employer),isEmailDomainCheck(employer));
			
		if(result.isSuccess()) {
				this.employerDao.save(employer);
				return new SuccessResult("Employer added");
		}
		 return result;
	
	}
	
	private Result checkIfNull(Employer employer) {
		if(!employer.getEmail().isEmpty()&&!employer.getWebAddress().isEmpty()
				&&!employer.getCompanyName().isEmpty()
				&&!employer.getPhoneNumber().isEmpty()&&!employer.getPassword().isEmpty()) {
			return new SuccessResult();
		}
		return new ErrorResult("These fields cannot be blank ");
	}
	
	private Result checkIfEmailExist(String email) {
		if(userDao.findByEmail(email).isPresent()) {
			return new ErrorResult("Email already exist");
		}
		return new SuccessResult();
	}
	
	private Result checkIfEmail(Employer employer) {
		if(emailService.emailSend(employer)) {
			return new SuccessResult();
		}
		return new ErrorResult("Email is not match");
	}
	
	private Result checkIfEmployerByEmployee(Employer employer) {
		if(EmployerValidateByEmployee.employerValidate(employer)==false) {
			return new ErrorResult("Employer is not validated");
		}
		return new SuccessResult();
	}
	
	private Result isEmailDomainCheck(Employer employer) {
		
		 String regex = "^(.+)@(.+)$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(employer.getEmail());
		
		if(!employer.getEmail().contains(employer.getWebAddress())) {
			return new ErrorResult("Web address is not match");
		}
		else if(matcher.matches()) {
			return new ErrorResult("");
		}
		return new SuccessResult();
	}
	
}
