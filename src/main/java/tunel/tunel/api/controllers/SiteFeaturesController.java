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

import tunel.tunel.business.abstarcts.SiteFeaturesSerivce;

import tunel.tunel.entities.concretes.SiteFeatures;
import tunel.tunel.entities.dto.SiteFeaturesAddDto;


@CrossOrigin
@RestController
@RequestMapping("/api/siteFeatures")
public class SiteFeaturesController {

	private SiteFeaturesSerivce siteFeaturesSerivce;

	@Autowired
	public SiteFeaturesController(SiteFeaturesSerivce siteFeaturesSerivce) {
		super();
		this.siteFeaturesSerivce = siteFeaturesSerivce;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.siteFeaturesSerivce.getAll());
	}
	
	@GetMapping("/getAllProductId")
	public ResponseEntity<?> getAllProductId(int id) {
		return ResponseEntity.ok(this.siteFeaturesSerivce.getAllByProductId(id));
	}

	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return ResponseEntity.ok(this.siteFeaturesSerivce.getAllById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody SiteFeaturesAddDto siteFeaturesAddDto,@RequestParam int productId) {
		return ResponseEntity.ok(this.siteFeaturesSerivce.Add(siteFeaturesAddDto,productId));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam int id) {
		return ResponseEntity.ok(this.siteFeaturesSerivce.Delete(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody SiteFeatures siteFeatures) {
		return ResponseEntity.ok(this.siteFeaturesSerivce.update(id, siteFeatures));
	}
}
