package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.entities.concretes.SocialMedia;

@CrossOrigin
@RestController
@RequestMapping("/api/links")
public class SocialMediaController {

	private SocialMediaService linkService;

	@Autowired
	public SocialMediaController(SocialMediaService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> insert(@RequestBody SocialMedia link){
		return ResponseEntity.ok(this.linkService.insert(link));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.linkService.getAll());
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(int candidateId){
		return ResponseEntity.ok(this.linkService.getAllByCandidateId(candidateId));	
	}
}
