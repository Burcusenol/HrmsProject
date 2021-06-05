package kodlamaio.hrms.business.abstracts;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateImage;

public interface CandidateImageService {
   Result insert(CandidateImage image);
   Result insert(CandidateImage image,MultipartFile multipartFile);
   Result addAll(List<CandidateImage> candidateImage);
   DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId);
   DataResult<List<CandidateImage>> getAll();

 
}
