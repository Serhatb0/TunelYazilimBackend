package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.entities.concretes.NewsName;


public interface NewsNameService {

	
	DataResult<List<NewsName>> getAll();

	DataResult<NewsName> getAllById(int id);

	Result Add(NewsName newsName);

	Result Delete(int id);

	Result update(int id, NewsName newsName);

	Result newsRejectActive(int id);

	DataResult<List<NewsName>> findByactiveTrue(int pageNo, int pageSize);

}
