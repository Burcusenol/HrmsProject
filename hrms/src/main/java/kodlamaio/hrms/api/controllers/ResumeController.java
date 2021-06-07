package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.entities.dtos.ResumeDto;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	//@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid ResumeDto resumeDto,int candidateId){
		return ResponseEntity.ok(resumeService.insert(resumeDto, candidateId));
	}
	
}
