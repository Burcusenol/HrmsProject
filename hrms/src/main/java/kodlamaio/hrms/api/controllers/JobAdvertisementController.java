package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDetailsDto;

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
	public DataResult<List<JobAdvertisement>> getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result Insert(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.insert(jobAdvertisement);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		return jobAdvertisementService.getAllSorted();
	}
	
	@GetMapping("/getJobAdvertisementWithEmployerDetails")
	public DataResult<List<JobAdvertisementDetailsDto>> getAdvertisementWithEmployerDetails() {
		return jobAdvertisementService.getAdvertisementWithEmployerDetails();
	}
	
	@GetMapping("/getAllByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveTrue(){
		return jobAdvertisementService.getAllByIsActiveTrue();
	}
	
	@GetMapping("/getByisActiveTrueOrderByApplicationDeadline")
	public DataResult<List<JobAdvertisement>> getByisActiveTrueOrderByApplicationDeadline(){
		return jobAdvertisementService.getByisActiveTrueOrderByApplicationDeadline();
	}
	
	@GetMapping("/ getByisActiveTrueAndEmployer_Id")
	public DataResult<List<JobAdvertisement>> getByisActiveTrueAndEmployer_Id(@RequestParam int employerId){
		return jobAdvertisementService.getByisActiveTrueAndEmployer_Id(employerId);
	}
	
	@GetMapping("/setPassive")
	 public Result setPassive(@RequestParam int jobAdvertisementId) {
		return jobAdvertisementService.setPassive(jobAdvertisementId);
	}
	

}
