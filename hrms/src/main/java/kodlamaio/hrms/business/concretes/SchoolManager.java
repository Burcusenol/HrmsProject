package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;



@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public Result insert(School school) {
		
		Result result=BusinessRules.run(GradutionDate(school));
		if(result.isSuccess()) {
			this.schoolDao.save(school);
		return new SuccessResult("School added");
		}
		return new ErrorResult();
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

	@Override
	public DataResult<List<School>> getByCandidateIdOrderByGraduationDateDesc(int candidateId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByCandidateIdOrderByGraduationDateDesc(candidateId));
	}

	@Override
	public Result addAll(List<School> school) {
		this.schoolDao.saveAll(school);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<School>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<School>>(schoolDao.getAllByCandidateId(candidateId));
	}
	
	

	private Result GradutionDate(School school) {
		if(school.getGraduationDate()=="") {
			 school.setGraduationDate("Devam ediyor.");
		}
		else {
			school.getGraduationDate();
		}
	    return new SuccessResult(); 
	}
	
}
