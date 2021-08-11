package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;

import tunel.tunel.entities.concretes.CustomerFeedback;

public interface CustomerFeedbackService {

	DataResult<List<CustomerFeedback>> getAll();

	DataResult<CustomerFeedback> getAllById(int id);

	Result Add(CustomerFeedback customerFeedback);

	Result Delete(int id);

	Result update(int id, CustomerFeedback customerFeedback);

}
