package kodlamaio.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.entities.concretes.JobExperience;

@CrossOrigin
@RestController
@RequestMapping("/api/jobExperience")
public class JobExperienceController {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> Insert(@Valid @RequestBody  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) JobExperience jobExperience) {
		return ResponseEntity.ok(jobExperienceService.insert(jobExperience));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobExperienceService.getAll());
	}
	
	@GetMapping("/getByResumeIdOrderByEndedDateAsc")
	public ResponseEntity<?> getByCandidateOrderByEndedDateAsc(@RequestParam int candidateId){
		return ResponseEntity.ok(this.jobExperienceService.getByCandidateOrderByEndedDateAsc(candidateId));
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(int candidateId){
		return ResponseEntity.ok(this.jobExperienceService.getAllByCandidateId(candidateId));	
	}
	
}
