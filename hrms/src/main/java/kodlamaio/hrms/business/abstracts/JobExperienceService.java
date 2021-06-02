package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	Result insert(JobExperience jobExperience);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> getByResumeIdOrderByEndedDateAsc(int resumeId);
	
}
