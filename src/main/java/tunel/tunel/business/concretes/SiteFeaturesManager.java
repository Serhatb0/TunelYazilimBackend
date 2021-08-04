package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.This;
import tunel.tunel.business.abstarcts.SiteFeaturesSerivce;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.SiteFeaturesDao;

import tunel.tunel.entities.concretes.SiteFeatures;

@Service
public class SiteFeaturesManager implements SiteFeaturesSerivce {

	SiteFeaturesDao siteFeaturesDao;
	
	
	
	public SiteFeaturesManager(SiteFeaturesDao siteFeaturesDao) {
		super();
		this.siteFeaturesDao = siteFeaturesDao;
	}

	
	
	@Override
	public DataResult<List<SiteFeatures>> getAll() {
		return new SuccessDataResult<List<SiteFeatures>>(this.siteFeaturesDao.findAll());
	}

	@Override
	public DataResult<SiteFeatures> getAllById(int id) {
		return new SuccessDataResult<SiteFeatures>(this.siteFeaturesDao.findAllById(id));
	}

	@Override
	public Result Add(SiteFeatures siteFeatures) {
		this.siteFeaturesDao.save(siteFeatures);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.siteFeaturesDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, SiteFeatures siteFeatures) {
		SiteFeatures siteFeatures2= this.siteFeaturesDao.findAllById(id);
		
		siteFeatures2.setDiamod(siteFeatures.getDiamod());
		siteFeatures2.setExplanation(siteFeatures.getExplanation());
		siteFeatures2.setGold(siteFeatures.getGold());
		siteFeatures2.setSilver(siteFeatures.getSilver());
		siteFeatures2.setTechnicalSpecifications(siteFeatures.getTechnicalSpecifications());

		
		this.siteFeaturesDao.save(siteFeatures2);
		return new SuccessResult("Güncellendi");
	}



	@Override
	public DataResult<List<SiteFeatures>> getAllByProductId(int id) {
		return new SuccessDataResult<List<SiteFeatures>>(this.siteFeaturesDao.getAllByproducts_id(id));
	}

}
