package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobExperience;

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
	public ResponseEntity<?> Insert(@Valid @RequestBody JobExperience jobExperience) {
		return ResponseEntity.ok(jobExperienceService.insert(jobExperience));
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobExperience>> getAll(){
		return jobExperienceService.getAll();
	}
	
	@GetMapping("/getByResumeIdOrderByEndedDateAsc")
	DataResult<List<JobExperience>> getByCandidateOrderByEndedDateAsc(@RequestParam int candidateId){
		return jobExperienceService.getByCandidateOrderByEndedDateAsc(candidateId);
	}
	
}
