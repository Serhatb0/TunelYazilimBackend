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

import tunel.tunel.business.abstarcts.ContactFormService;

import tunel.tunel.entities.concretes.ContactForm;


@CrossOrigin
@RestController
@RequestMapping("/api/contactForm")
public class ContactFormController {
	private ContactFormService contactFormService;

	@Autowired
	public ContactFormController(ContactFormService contactFormService) {
		super();
		this.contactFormService = contactFormService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.contactFormService.getAll());
	}

	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return ResponseEntity.ok(this.contactFormService.getAllById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ContactForm contactForm) {
		return ResponseEntity.ok(this.contactFormService.Add(contactForm));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam int id) {
		return ResponseEntity.ok(this.contactFormService.Delete(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody ContactForm contactForm) {
		return ResponseEntity.ok(this.contactFormService.update(id, contactForm));
	}
}
