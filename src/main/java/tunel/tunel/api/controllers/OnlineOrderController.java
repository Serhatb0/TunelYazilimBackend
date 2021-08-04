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

import tunel.tunel.business.abstarcts.OnlineOrderService;

import tunel.tunel.entities.concretes.OnlineOrder;


@CrossOrigin
@RestController
@RequestMapping("/api/onlineOrder")
public class OnlineOrderController {
private OnlineOrderService onlineOrderService;
	
	

	

	@Autowired
	public OnlineOrderController(OnlineOrderService onlineOrderService) {
	super();
	this.onlineOrderService = onlineOrderService;
}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return  ResponseEntity.ok(this.onlineOrderService.getAll());
	}
	
	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return  ResponseEntity.ok(this.onlineOrderService.getAllById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody OnlineOrder onlineOrder) {
		return  ResponseEntity.ok(this.onlineOrderService.Add(onlineOrder));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam  int id) {
		return  ResponseEntity.ok(this.onlineOrderService.Delete(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody OnlineOrder onlineOrder ) {
		return  ResponseEntity.ok(this.onlineOrderService.update(id,onlineOrder));
	}
}	
