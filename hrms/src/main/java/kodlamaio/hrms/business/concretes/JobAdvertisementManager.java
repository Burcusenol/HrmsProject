package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailsDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	
	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private CityDao cityDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,EmployerDao employerDao,CityDao cityDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao=employerDao;
		this.cityDao=cityDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"Job advertisements listed.");
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueOrderByApplicationDeadlineDesc());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueAndEmployer_Id(employerId));
	}

	@Override
	public JobAdvertisement getById(int id) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(id);
	    return this.jobAdvertisementDao.save(jobAdvertisement);
		
	}

	@Override
	public DataResult<List<JobAdvertisementDetailsDto>> getAdvertisementWithEmployerDetails() {
		return new SuccessDataResult<List<JobAdvertisementDetailsDto>>(this.jobAdvertisementDao.getAdvertisementWithEmployerDetails());
	}
	
	@Override
	public Result insert(JobAdvertisement jobAdvertisement) {

	Result result=BusinessRules.run(checkIfNull(jobAdvertisement),minMaxControl(jobAdvertisement),
			checfIfEmployerExist(jobAdvertisement.getEmployer().getId()),checkIfCityExist(jobAdvertisement.getCity().getId()));
		
		if(result.isSuccess()) {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Job advertisement added.");
		}
		return result;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.DESC,"createdDate");
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(sort),"Success");
	}

	@Override
	public Result setPassive(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(jobAdvertisementId);
		jobAdvertisement.setActive(false);
		jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement passive");
	}
	
	
	
	private Result checkIfNull(JobAdvertisement jobAdvertisement) {
		if(!jobAdvertisement.getDescription().isEmpty()&&!jobAdvertisement.getApplicationDeadline().toString().isEmpty())
		{		
			return new SuccessResult();
			
		}
		return new ErrorResult("Description and application deadline cannot be blank ");
		
	}
	
	private Result minMaxControl(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getMinSalary()>jobAdvertisement.getMaxSalary()) {
			return new ErrorResult("The minimum salary cannot exceed the maximum salary.");
	}
		return new SuccessResult();
	}
	
	private Result checfIfEmployerExist(int id) {
		if(!employerDao.existsById(id)) {
			return new ErrorResult("Employer is not exist");
		}
		return new SuccessResult();
	}
	
	private Result checkIfCityExist(int id) {
		if(!cityDao.existsById(id)) {
			return new ErrorResult("City is not exist");
		}
		return new SuccessResult();
	}

	
	
	
	
}
