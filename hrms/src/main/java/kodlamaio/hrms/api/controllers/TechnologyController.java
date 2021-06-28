package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.entities.concretes.Technology;

@CrossOrigin
@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> insert(@RequestBody Technology technology){
		return ResponseEntity.ok(this.technologyService.insert(technology));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Technology technology){
		return ResponseEntity.ok(this.technologyService.update(technology));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return  ResponseEntity.ok(this.technologyService.getAll());
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(int candidateId){
		return ResponseEntity.ok(this.technologyService.getAllByCandidateId(candidateId));	
	}
}
