package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.FavoriteService;
import kodlamaio.hrms.entities.concretes.Favorite;

@CrossOrigin
@RequestMapping("/api/favorite")
@RestController
public class FavoriteController {

	private FavoriteService favoriteService;

	@Autowired
	public FavoriteController(FavoriteService favoriteService) {
		super();
		this.favoriteService = favoriteService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> insert(@RequestBody Favorite favorite){
		return ResponseEntity.ok(this.favoriteService.insert(favorite));			
	}
	
	@DeleteMapping("/deleteById")
	public ResponseEntity<?> delete(@RequestParam  int id ){
		return ResponseEntity.ok(this.favoriteService.delete(id));			
	}
	
	 
	@GetMapping("getByCandidate_Id")
	public ResponseEntity<?> getByCandidate_Id(@RequestParam int id){
		return ResponseEntity.ok(this.favoriteService.getByCandidate_Id(id)) ;
	}
}
