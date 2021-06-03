package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {

	Result insert(SocialMedia link);
	DataResult<List<SocialMedia>> getAll();
}
