package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateImage;

@RestController()
@RequestMapping("/api/image")
public class CandidateImageController {

	private CandidateImageService imageService;

	@Autowired
	public CandidateImageController(CandidateImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> insert(@RequestBody MultipartFile multipartFile,@RequestParam int candidateId){
		CandidateImage image=new CandidateImage();
		Candidate candidate=new Candidate();
		candidate.setId(candidateId);
		image.setCandidate(candidate);
		return ResponseEntity.ok(this.imageService.insert(image,multipartFile));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.imageService.getAll());
				
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(int candidateId){
		return ResponseEntity.ok(this.imageService.getAllByCandidateId(candidateId));	
	}
}
