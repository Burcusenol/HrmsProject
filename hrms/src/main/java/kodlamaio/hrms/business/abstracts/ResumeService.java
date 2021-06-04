package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface ResumeService {

	Result insert( ResumeDto resumeDto,int candidateId);
}
