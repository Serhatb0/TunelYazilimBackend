package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.entities.concretes.AboutUs;


public interface AboutUsService {
	
	DataResult<List<AboutUs>> getAll();

	DataResult<AboutUs> getAllById(int id);

	Result Add(AboutUs aboutUs);

	Result Delete(int id);

	Result update(int id, AboutUs aboutUs);
}
