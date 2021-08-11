package tunel.tunel.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tunel.tunel.business.abstarcts.NewsNameService;

import tunel.tunel.entities.concretes.NewsName;


@RestController
@RequestMapping("/api/newsname")
@CrossOrigin
public class NewsNameController {

	
	private NewsNameService  newsNameService;
	
	

	@Autowired
	public NewsNameController(NewsNameService newsNameService) {
		super();
		this.newsNameService = newsNameService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return  ResponseEntity.ok(this.newsNameService.getAll());
	}
	
	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return  ResponseEntity.ok(this.newsNameService.getAllById(id));
	}
	
	@PostMapping("/rejectNews")
	public ResponseEntity<?> rejectNews(@RequestParam int id) {
		return  ResponseEntity.ok(this.newsNameService.newsRejectActive(id));
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody NewsName newsName) {
		return  ResponseEntity.ok(this.newsNameService.Add(newsName));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam  int id) {
		return  ResponseEntity.ok(this.newsNameService.Delete(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody NewsName newsName ) {
		return  ResponseEntity.ok(this.newsNameService.update(id,newsName));
	}
	
	@GetMapping("/findByactiveTrue")
	ResponseEntity<?> findByactiveTrue(@RequestParam int pageNo, @RequestParam int pageSize) {
		return  ResponseEntity.ok(this.newsNameService.findByactiveTrue(pageNo, pageSize));
	}
}
