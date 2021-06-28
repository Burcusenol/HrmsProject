package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;


@Service
public class TechnologyManager implements TechnologyService {

	
	private TechnologyDao technologyDao;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}

	@Override
	public Result insert(Technology technology) {
		this.technologyDao.save(technology);
		return new SuccessResult("Technology added");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(technologyDao.findAll(),"Technology listed");
	}

	@Override
	public Result addAll(List<Technology> technology) {
		this.technologyDao.saveAll(technology);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Technology>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Technology>>(technologyDao.getAllByCandidateId(candidateId),"Technology listed");
	}

	@Override
	public Result update(Technology technology) {
	this.technologyDao.save(technology);
	return new SuccessResult("Technology updated");
	}

}
