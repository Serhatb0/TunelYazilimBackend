package tunel.tunel.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tunel.tunel.business.abstarcts.CloudinaryService;
import tunel.tunel.business.abstarcts.NewsNameService;
import tunel.tunel.business.abstarcts.PhotoService;
import tunel.tunel.business.abstarcts.ProductService;
import tunel.tunel.business.abstarcts.ReferencesService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.ErrorResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.PhotoDao;
import tunel.tunel.entities.concretes.Photo;
import tunel.tunel.entities.dto.PhotoAddDto;

@Service
public class PhotManager implements PhotoService{

	@Autowired
	private CloudinaryService cloudinaryService;
	private PhotoDao photoDao;
	private ReferencesService referencesService;
	private ProductService productService;
	private NewsNameService newsNameService;
	


	


	@Autowired
	public PhotManager(CloudinaryService cloudinaryService, PhotoDao photoDao, ReferencesService referencesService,
			ProductService productService, NewsNameService newsNameService) {
		super();
		this.cloudinaryService = cloudinaryService;
		this.photoDao = photoDao;
		this.referencesService = referencesService;
		this.productService = productService;
		this.newsNameService = newsNameService;
	}


	@Override
	public Result delete(int id) {
		this.photoDao.deleteById(id);
		return new SuccessResult("Resim silindi");
	}


	@Override
	public Result add(PhotoAddDto photoAddDto, MultipartFile file) {
		
		if(cloudinaryService.uploadFile(file) == null) {
			return new ErrorResult("Resim Göderilemedi");
		}else {
			Photo photo = new Photo(photoAddDto.getName(),photoAddDto.getPhotoUrl(),photoAddDto.getDeleteId());
			String url = cloudinaryService.uploadFile(file);
			photo.setPhotoUrl(url);
			photo.setName(file.getContentType());
			photo.setDeleteId(url.substring(61, 81));
			photo.setReference(this.referencesService.getAllById(photoAddDto.getReferencesId()).getData());
			photo.setProduct(this.productService.getAllById(photoAddDto.getProductId()).getData());
			photo.setNewsName(this.newsNameService.getAllById(photoAddDto.getNewsId()).getData());
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


	@Override
	public DataResult<List<Photo>> getAllProductId(int id) {
		return new SuccessDataResult<List<Photo>>(this.photoDao.getAllByproduct_id(id),"Data Listelendi");
	}


	@Override
	public DataResult<List<Photo>> getAllNewsNameId(int id) {
		return new SuccessDataResult<List<Photo>>(this.photoDao.getAllBynewsName_id(id),"Data Listelendi");
	}


	@Override
	public DataResult<List<Photo>> getAllReferencesId(int id) {
		return new SuccessDataResult<List<Photo>>(this.photoDao.getAllByreference_id(id),"Data Listelendi");
	}
}
