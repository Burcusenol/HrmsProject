package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	Result insert(Candidate candidate);
	Result update(Candidate candidate);
	DataResult<Candidate> getById(int id);
	DataResult<ResumeDto> getCandidateResumeByCandidateId(int candidateId);
	
}
