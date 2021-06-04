package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {

	Result insert(School school);
	DataResult<List<School>> getAll();
	Result addAll(List<School> school);
	DataResult<List<School>> getByCandidateIdOrderByGraduationDateDesc(int candidateId);
}
