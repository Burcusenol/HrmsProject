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

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> Insert(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(jobAdvertisementService.insert(jobAdvertisement));
	}
	
	@GetMapping("/getAllSorted")
	public ResponseEntity<?> getAllSorted() {
		return ResponseEntity.ok(this.jobAdvertisementService.getAllSorted());
	}
	
	@GetMapping("/getJobAdvertisementWithEmployerDetails")
	public ResponseEntity<?> getAdvertisementWithEmployerDetails() {
		return ResponseEntity.ok(this.jobAdvertisementService.getAdvertisementWithEmployerDetails());
	}
	
	@GetMapping("/getAllByIsActiveTrue")
	public ResponseEntity<?> getAllByIsActiveTrue(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllByIsActiveTrue());
	}
	
	@GetMapping("/getByisActiveTrueOrderByApplicationDeadline")
	public ResponseEntity<?> getByisActiveTrueOrderByApplicationDeadline(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueOrderByApplicationDeadline());
	}
	
	@GetMapping("/ getByisActiveTrueAndEmployer_Id")
	public ResponseEntity<?> getByisActiveTrueAndEmployer_Id(@RequestParam int employerId){
		return ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueAndEmployer_Id(employerId));
	}
	
	@GetMapping("/setPassive")
	 public ResponseEntity<?> setPassive(@RequestParam int jobAdvertisementId) {
		return ResponseEntity.ok(this.setPassive(jobAdvertisementId));
	}
	
	@GetMapping("/setActive")
	 public ResponseEntity<?> setActive (@RequestParam int jobAdvertisementId) {
		return ResponseEntity.ok(this.setActive(jobAdvertisementId));
	}
	
	@GetMapping("/getByConfirmStatus")
	public ResponseEntity<?> getByConfirmStatus(boolean status){
		return ResponseEntity.ok(this.jobAdvertisementService.getByConfirmStatus(status));
	}

	@GetMapping("/getByEmployer_Id")
	public ResponseEntity<?> getByEmployer_Id(@RequestParam int employerid){
		return ResponseEntity.ok(this.jobAdvertisementService.getByEmployer_Id(employerid));
	}
	
	@PutMapping("/updateisActive")
	public ResponseEntity<?> updateisActive(int jobAdvertisementId){
		return ResponseEntity.ok(this.jobAdvertisementService.updateisActive(jobAdvertisementId));
	}
}
