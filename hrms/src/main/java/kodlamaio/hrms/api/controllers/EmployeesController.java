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

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.entities.concretes.Employee;

@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.employeeService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> insert(@Valid @RequestBody Employee employee){
		return ResponseEntity.ok(this.employeeService.insert(employee));
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		return ResponseEntity.ok(employeeService.getById(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Employee employee){
		return ResponseEntity.ok(this.employeeService.update(employee));
	}
}
