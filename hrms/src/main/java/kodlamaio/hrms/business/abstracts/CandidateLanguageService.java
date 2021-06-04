package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;


public interface CandidateLanguageService {

	Result insert(CandidateLanguage candidateLanguage);
	Result addAll(List<CandidateLanguage> candidateLanguage);
	DataResult<List<CandidateLanguage>> getAll();
	DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId);
}
