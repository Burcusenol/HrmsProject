package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteDao;
import kodlamaio.hrms.entities.concretes.Favorite;


@Service
public class FavoriteManager implements FavoriteService {

	
	private FavoriteDao favoriteDao;
	@Autowired
	public FavoriteManager(FavoriteDao favoriteDao) {
		super();
		this.favoriteDao = favoriteDao;
	}

	@Override
	public Result insert(Favorite favorite) {
		this.favoriteDao.save(favorite);
		return new SuccessResult("Favorite added");
	}

	@Override
	public Result delete(int id) {
		this.favoriteDao.deleteById(id);
		return new SuccessResult("Favorite deleted");
	}

	@Override
	public DataResult<List<Favorite>> getByCandidate_Id(int id) {
		return new SuccessDataResult<List<Favorite>>(favoriteDao.getByCandidate_Id(id));
	}


}
