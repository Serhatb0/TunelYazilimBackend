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

import tunel.tunel.business.abstarcts.AboutUsService;

import tunel.tunel.entities.concretes.AboutUs;

@CrossOrigin
@RestController
@RequestMapping("/api/aboutUs")
public class AboutUsController {
	private AboutUsService aboutUsService;

	@Autowired
	public AboutUsController(AboutUsService aboutUsService) {
		super();
		this.aboutUsService = aboutUsService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.aboutUsService.getAll());
	}

	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return ResponseEntity.ok(this.aboutUsService.getAllById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody AboutUs aboutUs) {
		return ResponseEntity.ok(this.aboutUsService.Add(aboutUs));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam int id) {
		return ResponseEntity.ok(this.aboutUsService.Delete(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody AboutUs aboutUs) {
		return ResponseEntity.ok(this.aboutUsService.update(id, aboutUs));
	}
	
	
}
