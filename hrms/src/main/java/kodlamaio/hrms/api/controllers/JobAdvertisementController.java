package kodlamaio.hrms.api.controllers;



import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementFilter;

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

	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(jobAdvertisementService.getById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> Insert(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(jobAdvertisementService.insert(jobAdvertisement));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> Delete(int jobAdvertisementId) {
		return ResponseEntity.ok(jobAdvertisementService.delete(jobAdvertisementId));
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
	
	@GetMapping("/getByisActiveTrueAndConfirmStatusTrue")
	public ResponseEntity<?> getByisActiveTrueAndConfirmStatusTrue(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueAndConfirmStatusTrue());
	}
	
	@GetMapping("/setPassive")
	 public ResponseEntity<?> setPassive(@RequestParam int jobAdvertisementId) {
		Result result=this.jobAdvertisementService.setPassive(jobAdvertisementId);
		if(!result.isSuccess()) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/updateisActive")
	@Transactional
	public Result updateisActive(@RequestParam int jobAdvertisementId, @RequestParam int employerId) {
		return this.jobAdvertisementService.updateisActive(jobAdvertisementId, employerId);
	}
	
	@PostMapping("/updateconfirmStatus")
	@Transactional
	public Result updateconfirmStatus(@RequestParam int jobAdvertisementId) {
		return this.jobAdvertisementService.updateconfirmStatus(jobAdvertisementId);
	}
	
	@GetMapping("/getByConfirmStatusFalse")
	public ResponseEntity<?> getByConfirmStatusFalse(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByConfirmStatusFalse());
	}

	@GetMapping("/getByEmployer_Id")
	public ResponseEntity<?> getByEmployer_Id(@RequestParam int employerid){
		return ResponseEntity.ok(this.jobAdvertisementService.getByEmployer_Id(employerid));
	}
	
	@GetMapping("/getByPage")
	public ResponseEntity<?> getByisActiveTrueAndConfirmStatusTrue( @RequestParam int pageNo,@RequestParam int pageSize){
		return   ResponseEntity.ok(this.jobAdvertisementService.getByisActiveTrueAndConfirmStatusTrue(pageNo, pageSize));
	}
	
	  @PostMapping("/getByisActiveTrueAndConfirmStatusTrueAndFilter")
	    public Result getByisActiveTrueAndConfirmStatusTrueAndFilter(@RequestParam int pageNo,@RequestParam int pageSize,@RequestBody JobAdvertisementFilter jobAdvertisementFilter){
	        return jobAdvertisementService.getByisActiveTrueAndConfirmStatusTrueAndFilter(pageNo,pageSize,jobAdvertisementFilter);
	    }
	
}
