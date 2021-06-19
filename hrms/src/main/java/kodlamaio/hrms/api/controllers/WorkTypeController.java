package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;

@RestController
@RequestMapping("/api/worktype")
public class WorkTypeController {

	private WorkTypeService workTypeService;

	@Autowired
	public WorkTypeController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getall(){
		return ResponseEntity.ok(this.workTypeService.getAll());
	}
}
