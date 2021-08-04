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

import tunel.tunel.business.abstarcts.SocialMediaService;

import tunel.tunel.entities.concretes.SocialMedia;



@CrossOrigin
@RestController
@RequestMapping("/api/socialMedia")
public class SocialMediaController {
	
	
	private SocialMediaService socialMediaService;


	@Autowired
	public SocialMediaController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.socialMediaService.getAll());
	}

	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return ResponseEntity.ok(this.socialMediaService.getAllById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody SocialMedia socialMedia) {
		return ResponseEntity.ok(this.socialMediaService.Add(socialMedia));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam int id) {
		return ResponseEntity.ok(this.socialMediaService.Delete(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody SocialMedia socialMedia) {
		return ResponseEntity.ok(this.socialMediaService.update(id, socialMedia));
	}
}
