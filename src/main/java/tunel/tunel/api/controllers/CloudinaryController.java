package tunel.tunel.api.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tunel.tunel.business.abstarcts.CloudinaryService;
import tunel.tunel.business.abstarcts.PhotoService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.ErrorResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.entities.concretes.Photo;
import tunel.tunel.entities.dto.PhotoAddDto;

@RestController
@RequestMapping("/api/cloudinarys")
@CrossOrigin
public class CloudinaryController {

	private CloudinaryService cloudinaryService;
	private PhotoService PhotoService;

	@Autowired
	public CloudinaryController(CloudinaryService cloudinaryService, PhotoService photoService) {
		super();
		this.cloudinaryService = cloudinaryService;
		PhotoService = photoService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Photo>> getAll() {
		return this.PhotoService.getAll();
	}
	
	@GetMapping("/getAllProductId")
	public DataResult<List<Photo>> getAllProductId(int id) {
		return this.PhotoService.getAllProductId(id);
	}
	@GetMapping("/getAllNewsNameId")
	public DataResult<List<Photo>> getAllNewsNameId(int id) {
		return this.PhotoService.getAllNewsNameId(id);
	}
	@GetMapping("/getAllReferencesId")
	public DataResult<List<Photo>> getAllReferencesId(int id) {
		return this.PhotoService.getAllReferencesId(id);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/file/upload")
	public Result uploadFile(@RequestParam("file") MultipartFile file, PhotoAddDto photoAddDto) {
		return this.PhotoService.add(photoAddDto, file);

	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable("id") int id) throws IOException {
		if (!this.PhotoService.isExists(id)) {
			return new ErrorResult("Böyle bir resim Yok");
		}

		Photo image = this.PhotoService.getById(id).getData().get();
		Map result = cloudinaryService.delete(image.getDeleteId());
		this.PhotoService.delete(id);
		return new SuccessResult("Resim silindi.");
	}

}
