package tunel.tunel.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tunel.tunel.business.abstarcts.CloudinaryService;
import tunel.tunel.business.abstarcts.PhotoService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.ErrorResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.PhotoDao;
import tunel.tunel.entities.concretes.Photo;

@Service
public class PhotManager implements PhotoService{

	@Autowired
	private CloudinaryService cloudinaryService;
	private PhotoDao photoDao;
	
	@Autowired
	public PhotManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}

	

	
	
	@Override
	public Result delete(int id) {
		this.photoDao.deleteById(id);
		return new SuccessResult("Resim silindi");
	}


	@Override
	public Result add(Photo photo, MultipartFile file) {
		
		if(cloudinaryService.uploadFile(file) == null) {
			return new ErrorResult("Resim Göderilemedi");
		}else {
			String url = cloudinaryService.uploadFile(file);
			photo.setPhotoUrl(url);
			photo.setName(file.getContentType());
			photo.setDeleteId(url.substring(61, 81));
			this.photoDao.save(photo);
			return new SuccessResult("Resim Eklendi");
		}
		
	}
	
	@Override
	public Boolean isExists(int id) {
		
		return this.photoDao.existsById(id);
	}



	@Override
	public DataResult<Optional<Photo>> getById(int id) {
		return new SuccessDataResult<Optional<Photo>>(this.photoDao.findById(id),"ürün başarıyla getirildi."); 
	}



	@Override
	public DataResult<List<Photo>> getAll() {
		return new SuccessDataResult<List<Photo>>(this.photoDao.findAll(),"Data Listelendi");
	}
}
