package kodlamaio.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.entities.concretes.Employer;


@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getall(){
		return ResponseEntity.ok(this.employerService.getAll());
	}
	
	@PostMapping("/add")
	public  ResponseEntity<?> insert(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.insert(employer));
	}
}
