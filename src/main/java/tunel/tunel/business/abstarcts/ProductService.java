package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.entities.concretes.Product;

public interface ProductService {

	DataResult<List<Product>> getAll();

	DataResult<Product> getAllById(int id);

	Result Add(Product product);

	Result Delete(int id);

	Result update(int id, Product product);



	
		
}
