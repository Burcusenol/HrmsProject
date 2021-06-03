package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkTypeService;
import kodlamaio.hrms.entities.concretes.LinkType;

@RestController
@RequestMapping("/api/linkType")
public class LinkTypeController {
	
	private LinkTypeService linkTypeService;

	@Autowired
	public LinkTypeController(LinkTypeService linkTypeService) {
		super();
		this.linkTypeService = linkTypeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> Insert(@RequestBody LinkType linkType){
		return ResponseEntity.ok(this.linkTypeService.insert(linkType));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.linkTypeService.getAll());
	}
}
