package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndConfirmStatusTrue(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1,pageSize);
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent());
	}

	@Override
	public JobAdvertisement getByIdAndEmployer_Id(int id, int employerId) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getByIdAndEmployer_Id(id,employerId);
	    return this.jobAdvertisementDao.save(jobAdvertisement);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByConfirmStatusFalse() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByConfirmStatusFalse());
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
	public DataResult<List<JobAdvertisement>> getByEmployer_Id(int employerid) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByEmployer_Id(employerid));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndConfirmStatusTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueAndConfirmStatusTrue(),"Data listed");
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByisActiveTrueAndEmployer_Id(employerId));
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id),"Data listed");
		
	}

	@Override
	public DataResult<List<JobAdvertisementDetailsDto>> getAdvertisementWithEmployerDetails() {
		return new SuccessDataResult<List<JobAdvertisementDetailsDto>>(this.jobAdvertisementDao.getAdvertisementWithEmployerDetails());
	}
	
	@Override
	public Result updateisActive(int jobAdvertisementId, int employerId) {
		this.jobAdvertisementDao.updateisActive(jobAdvertisementId,employerId);
		return new SuccessResult("Job Advertisement closed");
	}
	
	@Override
	public Result delete(int jobAdvertisementId) {
		this.jobAdvertisementDao.deleteById(jobAdvertisementId);
		return new SuccessResult("Job advertisement deleted");
	}


	@Override
	public Result updateconfirmStatus(int jobAdvertisementId) {
		this.jobAdvertisementDao.updateconfirmStatus(jobAdvertisementId);
		return new SuccessResult("Job advertisement confirmed.");
	}

	
	@Override
	public Result setPassive(int jobAdvertisementId) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(jobAdvertisementId);
		Result	result=BusinessRules.run(checkJobPostIsExists(jobAdvertisement));
		if(!result.isSuccess()) {
			return result;
		}
		JobAdvertisement updateJobAdvertisement=jobAdvertisement;
		updateJobAdvertisement.setActive(!updateJobAdvertisement.isActive());;
		this.jobAdvertisementDao.save(updateJobAdvertisement);	
		return new SuccessResult("Job Advertisement closed");
	}
	
	

	
	@Override
	public Result insert(JobAdvertisement jobAdvertisement) {

	Result result=BusinessRules.run(minMaxControl(jobAdvertisement),
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

	
	 private Result checkJobPostIsExists(JobAdvertisement jobAdvertisement) {
	        if (jobAdvertisement == null) {
	            return new ErrorResult("İş ilanı mevcut değil");
	        }
	        return new SuccessResult();
	    }




	
	
	

	
	

	
	
	
	
}
