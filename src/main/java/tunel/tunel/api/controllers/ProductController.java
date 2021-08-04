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

import tunel.tunel.business.abstarcts.ProductService;
import tunel.tunel.entities.concretes.Product;


@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private ProductService productService;
	
	

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}




	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return  ResponseEntity.ok(this.productService.getAll());
	}
	
	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return  ResponseEntity.ok(this.productService.getAllById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Product product) {
		return  ResponseEntity.ok(this.productService.Add(product));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam  int id) {
		return  ResponseEntity.ok(this.productService.Delete(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody Product product ) {
		return  ResponseEntity.ok(this.productService.update(id,product));
	}
		
}
