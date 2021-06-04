package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;



@Service
public class CandidateLanguageManager implements CandidateLanguageService {

	private CandidateLanguageDao candidatelanguageDao;
	
	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidatelanguageDao) {
		super();
		this.candidatelanguageDao = candidatelanguageDao;
	}

	@Override
	public Result insert(CandidateLanguage candidateLanguage) {
		candidatelanguageDao.save(candidateLanguage);
		return new SuccessResult("Language added");
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateLanguage>>(candidatelanguageDao.findAll(),"Language listed");
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateLanguage>>(candidatelanguageDao.getAllByCandidateId(candidateId),"Language listed");
	}

	@Override
	public Result addAll(List<CandidateLanguage> candidateLanguage) {
		this.candidatelanguageDao.saveAll(candidateLanguage);
		return new SuccessResult();
	}

}
