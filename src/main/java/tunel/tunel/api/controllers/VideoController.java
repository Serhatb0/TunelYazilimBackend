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

import tunel.tunel.business.abstarcts.VideoSerivce;

import tunel.tunel.entities.concretes.Video;

@CrossOrigin
@RestController
@RequestMapping("/api/video")
public class VideoController {
	private VideoSerivce videoService;

	@Autowired
	public VideoController(VideoSerivce videoService) {
		super();
		this.videoService = videoService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.videoService.getAll());
	}

	@GetMapping("/getAllById")
	public ResponseEntity<?> getAllById(int id) {
		return ResponseEntity.ok(this.videoService.getAllById(id));
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Video video) {
		return ResponseEntity.ok(this.videoService.Add(video));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> Delete(@RequestParam int id) {
		return ResponseEntity.ok(this.videoService.Delete(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam int id, @RequestBody Video video) {
		return ResponseEntity.ok(this.videoService.update(id, video));
	}
}
