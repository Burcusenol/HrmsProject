package kodlamaio.hrms.business.abstracts;



import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Favorite;

public interface FavoriteService {

	
	Result insert(Favorite favorite);
	Result delete(int id);
	DataResult<List<Favorite>> getByCandidate_Id(int id);
}
