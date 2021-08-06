package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;

import tunel.tunel.entities.concretes.SiteFeatures;
import tunel.tunel.entities.dto.ProductDteailDto;
import tunel.tunel.entities.dto.SiteFeaturesAddDto;

public interface SiteFeaturesSerivce {

	DataResult<List<ProductDteailDto>> getAll();

	DataResult<ProductDteailDto> getAllById(int id);

	Result Add(SiteFeaturesAddDto siteFeaturesAddDto ,int productId);

	Result Delete(int id);

	Result update(int id, SiteFeatures siteFeatures);

	DataResult<List<ProductDteailDto>> getAllByProductId(int id);


}
