package tunel.tunel.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.This;
import tunel.tunel.business.abstarcts.ProductService;
import tunel.tunel.business.abstarcts.SiteFeaturesSerivce;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.SiteFeaturesDao;

import tunel.tunel.entities.concretes.SiteFeatures;
import tunel.tunel.entities.dto.ProductDteailDto;
import tunel.tunel.entities.dto.SiteFeaturesAddDto;

@Service
public class SiteFeaturesManager implements SiteFeaturesSerivce {

	SiteFeaturesDao siteFeaturesDao;
	ProductService productService;
	
	
	
	
	@Autowired
	public SiteFeaturesManager(SiteFeaturesDao siteFeaturesDao, ProductService productService) {
		super();
		this.siteFeaturesDao = siteFeaturesDao;
		this.productService = productService;
	}

	@Override
	public DataResult<List<ProductDteailDto>> getAll() {
		return new SuccessDataResult<List<ProductDteailDto>>(this.siteFeaturesDao.findAll()
				.stream().map(ProductDteailDto::of).collect(Collectors.toList())
				);
	}

	@Override
	public DataResult<ProductDteailDto> getAllById(int id) {
		final SiteFeatures siteFeatures = this.siteFeaturesDao.findAllById(id);
		return new SuccessDataResult<ProductDteailDto>(ProductDteailDto.of(siteFeatures));
		
	}

	@Override
	public Result Add(SiteFeaturesAddDto siteFeaturesAddDto ,int produtcId) {
		SiteFeatures siteFeatures = new SiteFeatures(siteFeaturesAddDto.getTechnicalSpecifications(),
				siteFeaturesAddDto.getSilver(),siteFeaturesAddDto.getGold(),siteFeaturesAddDto.getDiamod(),siteFeaturesAddDto.getExplanation());
		
		siteFeatures.setProducts(this.productService.getAllById(produtcId).getData());
		
	
		
		this.siteFeaturesDao.save(siteFeatures);
		return new SuccessResult("Kaydedildi");
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
	public DataResult<List<ProductDteailDto>> getAllByProductId(int id) {
		return new SuccessDataResult<List<ProductDteailDto>>(this.siteFeaturesDao.getAllByproducts_id(id)
				.stream().map(ProductDteailDto::of).collect(Collectors.toList()));
	}

}
