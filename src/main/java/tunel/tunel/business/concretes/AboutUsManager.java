package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.AboutUsService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.AboutUsDao;

import tunel.tunel.entities.concretes.AboutUs;


@Service 
public class AboutUsManager implements AboutUsService{

	
	private AboutUsDao aboutUsDao;
	
	@Autowired
	public AboutUsManager(AboutUsDao aboutUsDao) {
		super();
		this.aboutUsDao = aboutUsDao;
	}

	

	@Override
	public DataResult<List<AboutUs>> getAll() {
		return new SuccessDataResult<List<AboutUs>>(this.aboutUsDao.findAll());
	}

	@Override
	public DataResult<AboutUs> getAllById(int id) {
		return new SuccessDataResult<AboutUs>(this.aboutUsDao.findAllById(id));
	}

	@Override
	public Result Add(AboutUs aboutUs) {
		this.aboutUsDao.save(aboutUs);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.aboutUsDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, AboutUs aboutUs) {
		AboutUs aboutUs2= this.aboutUsDao.findAllById(id);
		
		aboutUs2.setAboutDescription(aboutUs.getAboutDescription());
		
	
		
		
		this.aboutUsDao.save(aboutUs2);
		return new SuccessResult("Güncellendi");}


}
