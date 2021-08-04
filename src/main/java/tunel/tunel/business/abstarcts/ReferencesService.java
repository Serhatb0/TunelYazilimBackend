package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.entities.concretes.References;

public interface ReferencesService {
	
	
	DataResult<List<References>> getAll();

	DataResult<References> getAllById(int id);

	Result Add(References references);

	Result Delete(int id);

	Result update(int id, References references);
}
