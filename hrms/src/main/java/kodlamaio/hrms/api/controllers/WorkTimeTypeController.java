package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeTypeService;

@RestController
@RequestMapping("api/worktimetype")
public class WorkTimeTypeController {

	private WorkTimeTypeService workTimeTypeService;

	@Autowired
	public WorkTimeTypeController(WorkTimeTypeService workTimeTypeService) {
		super();
		this.workTimeTypeService = workTimeTypeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.workTimeTypeService.getAll());
	}
}
