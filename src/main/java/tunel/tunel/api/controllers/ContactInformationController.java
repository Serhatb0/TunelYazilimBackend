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

import tunel.tunel.business.abstarcts.ContactInformationSerivce;
import tunel.tunel.entities.concretes.ContactInformation;


@CrossOrigin
@RestController
@RequestMapping("/api/contactInformation")
public class ContactInformationController {
	
	
	private ContactInformationSerivce  contactInformationSerivce;
	
	
	@Autowired
	public ContactInformationController(ContactInformationSerivce contactInformationSerivce) {
		super();
		this.contactInformationSerivce = contactInformationSerivce;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return  ResponseEntity.ok(this.contactInformationSerivce.getAll());
	}
	
	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return  ResponseEntity.ok(this.contactInformationSerivce.getAllById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody ContactInformation contactInformation) {
		return  ResponseEntity.ok(this.contactInformationSerivce.Add(contactInformation));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam  int id) {
		return  ResponseEntity.ok(this.contactInformationSerivce.Delete(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody ContactInformation contactInformation ) {
		return  ResponseEntity.ok(this.contactInformationSerivce.update(id,contactInformation));
	}
}
