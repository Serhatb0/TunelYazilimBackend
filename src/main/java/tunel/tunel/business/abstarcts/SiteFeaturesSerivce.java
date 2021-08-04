package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;

import tunel.tunel.entities.concretes.SiteFeatures;

public interface SiteFeaturesSerivce {

	DataResult<List<SiteFeatures>> getAll();

	DataResult<SiteFeatures> getAllById(int id);

	Result Add(SiteFeatures siteFeatures);

	Result Delete(int id);

	Result update(int id, SiteFeatures siteFeatures);

	DataResult<List<SiteFeatures>> getAllByProductId(int id);


}
