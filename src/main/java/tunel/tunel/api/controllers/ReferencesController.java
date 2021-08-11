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

import tunel.tunel.business.abstarcts.ReferencesService;

import tunel.tunel.entities.concretes.References;


@CrossOrigin
@RestController
@RequestMapping("/api/references")
public class ReferencesController {
	private ReferencesService referencesService;

	
	@Autowired
	public ReferencesController(ReferencesService referencesService) {
		super();
		this.referencesService = referencesService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.referencesService.getAll());
	}

	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return ResponseEntity.ok(this.referencesService.getAllById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody References references) {
		return ResponseEntity.ok(this.referencesService.Add(references));
	}

	@PostMapping("/rejectreferences")
	public ResponseEntity<?> rejectReferences(@RequestParam int id) {
		return  ResponseEntity.ok(this.referencesService.referencesRejectActive(id));
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam int id) {
		return ResponseEntity.ok(this.referencesService.Delete(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody References references) {
		return ResponseEntity.ok(this.referencesService.update(id, references));
	}
	
	@GetMapping("/findByactiveTrue")
	ResponseEntity<?> findByactiveTrue(@RequestParam int pageNo, @RequestParam int pageSize) {
		return  ResponseEntity.ok(this.referencesService.findByactiveTrue(pageNo, pageSize));
	}
}
