package kodlamaio.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;

@CrossOrigin
@RestController
@RequestMapping("/api/languages")
public class CandidateLanguageController {

	private CandidateLanguageService candidatelanguageService;

	@Autowired
	public CandidateLanguageController(CandidateLanguageService candidatelanguageService) {
		super();
		this.candidatelanguageService = candidatelanguageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> Insert( @Valid @RequestBody CandidateLanguage candidatelanguage){
		return ResponseEntity.ok(this.candidatelanguageService.insert(candidatelanguage));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidatelanguageService.getAll());				
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(int candidateId){
		return ResponseEntity.ok(this.candidatelanguageService.getAllByCandidateId(candidateId));
	}
}
