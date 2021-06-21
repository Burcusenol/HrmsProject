package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailsDto;



public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllSorted();
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();

	DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadline();
	
	DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployer_Id(int employerId);
	
	DataResult<List<JobAdvertisementDetailsDto>>getAdvertisementWithEmployerDetails();
	
	JobAdvertisement getById(int id);
	
	JobAdvertisement getByIdAndEmployer_Id(int id,int employerId);
	
	Result setPassive(int jobAdvertisementId);
	
	Result updateconfirmStatus(int jobAdvertisementId);
	
	Result updateisActive(int jobAdvertisementId, int employerId);
	
	Result insert(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getByConfirmStatus(boolean status);
	
	DataResult<List<JobAdvertisement>> getByEmployer_Id(int employerid);
	
}
