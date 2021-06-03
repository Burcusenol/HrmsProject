package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;



@Service
public class ImageManager implements ImageService{

	private ImageDao imagedao;
	
	@Autowired
	public ImageManager(ImageDao imagedao) {
		super();
		this.imagedao = imagedao;
	}

	@Override
	public Result insert(Image image) {
		this.imagedao.save(image);
		return new SuccessResult("Image added");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imagedao.findAll());
	}

}
