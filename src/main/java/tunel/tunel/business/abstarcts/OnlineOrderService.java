package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;

import tunel.tunel.entities.concretes.OnlineOrder;

public interface OnlineOrderService {
	
	
	DataResult<List<OnlineOrder>> getAll();

	DataResult<OnlineOrder> getAllById(int id);

	Result Add(OnlineOrder onlineOrder);

	Result Delete(int id);

	Result update(int id, OnlineOrder onlineOrder);
}
