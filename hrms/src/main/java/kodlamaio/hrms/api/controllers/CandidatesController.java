package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.entities.concretes.Candidate;


@CrossOrigin
@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?>  insert (@Valid @RequestBody Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.insert(candidate));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?>  update (@RequestBody Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.update(candidate));
	}
	
	@GetMapping("/getCandidateResumeByCandidateId")
	public ResponseEntity<?> getCandidateResumeByCandidateId(@RequestParam int candidateId){
		return ResponseEntity.ok(this.candidateService.getCandidateResumeByCandidateId(candidateId));
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(candidateService.getById(id));
	}
	
}
