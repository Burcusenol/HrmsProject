package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	Result insert(JobExperience jobExperience);
	Result addAll(List<JobExperience> jobExperience);
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> getByCandidateOrderByEndedDateAsc(int candidateId);
	DataResult<List<JobExperience>> getAllByCandidateId(int candidateId);
}
