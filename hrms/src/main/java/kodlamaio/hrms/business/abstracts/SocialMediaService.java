package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {

	Result insert(SocialMedia link);
	Result update(SocialMedia link);
	DataResult<List<SocialMedia>> getAll();
	DataResult<List<SocialMedia>> getAllByCandidateId(int candidateId);
	Result addAll(List<SocialMedia> socialMedia);
}
