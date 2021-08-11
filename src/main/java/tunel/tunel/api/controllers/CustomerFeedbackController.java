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

import tunel.tunel.business.abstarcts.CustomerFeedbackService;

import tunel.tunel.entities.concretes.CustomerFeedback;

@CrossOrigin
@RestController
@RequestMapping("/api/customerfeedback")
public class CustomerFeedbackController {
	
	private CustomerFeedbackService customerFeedbackService;
	
	@Autowired
	public CustomerFeedbackController(CustomerFeedbackService customerFeedbackService) {
		super();
		this.customerFeedbackService = customerFeedbackService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.customerFeedbackService.getAll());
	}

	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return ResponseEntity.ok(this.customerFeedbackService.getAllById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody CustomerFeedback customerFeedback) {
		return ResponseEntity.ok(this.customerFeedbackService.Add(customerFeedback));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam int id) {
		return ResponseEntity.ok(this.customerFeedbackService.Delete(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody CustomerFeedback customerFeedback) {
		return ResponseEntity.ok(this.customerFeedbackService.update(id, customerFeedback));
	}
	
}
