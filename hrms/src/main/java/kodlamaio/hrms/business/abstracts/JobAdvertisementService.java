package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;



public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllSorted();
	
	DataResult<List<JobAdvertisement>> getAllByIsActiveTrue();

	DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadline();
	
	DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployer_Id(int employerId);
	
	JobAdvertisement getById(int id);
	
	Result setPassive(int jobAdvertisementId);
	
	Result insert(JobAdvertisement jobAdvertisement);
	
	
}
