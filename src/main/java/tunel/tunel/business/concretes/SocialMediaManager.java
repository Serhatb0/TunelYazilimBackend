package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.SocialMediaService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.SocialMediaDao;

import tunel.tunel.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService{
	
	
	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		return new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.findAll());
	}

	@Override
	public DataResult<SocialMedia> getAllById(int id) {
		return new SuccessDataResult<SocialMedia>(this.socialMediaDao.findAllById(id));
	}

	@Override
	public Result Add(SocialMedia socialMedia) {
		this.socialMediaDao.save(socialMedia);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.socialMediaDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, SocialMedia socialMedia) {
		SocialMedia socialMedia2 = this.socialMediaDao.findAllById(id);
		
		socialMedia2.setFacebookLink(socialMedia.getFacebookLink());
		socialMedia2.setInstagramLink(socialMedia.getInstagramLink());
		socialMedia2.setTwitterLink(socialMedia.getTwitterLink());
		
		this.socialMediaDao.save(socialMedia2);
		return new SuccessResult("Güncellendi");
	}

}
