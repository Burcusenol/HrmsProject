package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping("api/schools")
public class SchoolController {

	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> insert(@Valid @RequestBody School school){
		return ResponseEntity.ok(schoolService.insert(school));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.schoolService.getAll());
	}
	
	@GetMapping("/getByCandidateIdOrderByGraduationDateDesc")
	public ResponseEntity<?>  getByCandidateIdOrderByGraduationDateDesc(@RequestParam int candidateId){
		return ResponseEntity.ok(this.schoolService.getByCandidateIdOrderByGraduationDateDesc(candidateId));
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(int candidateId){
		return ResponseEntity.ok(this.schoolService.getAllByCandidateId(candidateId));	
	}
}
