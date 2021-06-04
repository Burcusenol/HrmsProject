package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.SocialMedia;



@Service
public class SocialMediaManager implements SocialMediaService{

	private SocialMediaDao linkDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result insert(SocialMedia link) {
		this.linkDao.save(link);
		return new SuccessResult("Link added");
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(this.linkDao.findAll());
	}

	@Override
	public Result addAll(List<SocialMedia> socialMedia) {
		this.linkDao.saveAll(socialMedia);
		return new SuccessResult();
	}

}
