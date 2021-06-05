package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.utilities.helpers.imageHelpers.ImageUpload;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;
import kodlamaio.hrms.entities.concretes.CandidateImage;




@Service
public class CandidateImageManager implements CandidateImageService{

	private CandidateImageDao imagedao;
	private ImageUpload imageUpload;
	
	@Autowired
	public CandidateImageManager(CandidateImageDao imagedao,ImageUpload imageUpload) {
		super();
		this.imagedao = imagedao;
		this.imageUpload=imageUpload;
	}

	@Override
	public Result insert(CandidateImage image) {
		this.imagedao.save(image);
		return new SuccessResult("Image added");
	}

	@Override
	public DataResult<List<CandidateImage>> getAll() {
		return new SuccessDataResult<List<CandidateImage>>(this.imagedao.findAll());
	}

	@Override
	public Result insert(CandidateImage image, MultipartFile multipartFile) {
		Map<String, String> result= (Map<String, String>) imageUpload.upload(multipartFile).getData();
		String url=result.get("url");
		image.setImageUrl(url);
		image.setUploadedDate(LocalDateTime.now());
		return insert(image);
	}

	@Override
	public Result addAll(List<CandidateImage> candidateImage) {
		this.imagedao.saveAll(candidateImage);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateImage>>(this.imagedao.getAllByCandidateId(candidateId));
	}

}
