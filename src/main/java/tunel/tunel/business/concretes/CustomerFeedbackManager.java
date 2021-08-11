package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.CustomerFeedbackService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.CustomerFeedbackDao;

import tunel.tunel.entities.concretes.CustomerFeedback;
@Service
public class CustomerFeedbackManager implements CustomerFeedbackService {
	
	private CustomerFeedbackDao customerFeedbackDao;
	
	
	@Autowired
	public CustomerFeedbackManager(CustomerFeedbackDao customerFeedbackDao) {
		super();
		this.customerFeedbackDao = customerFeedbackDao;
	}

	@Override
	public DataResult<List<CustomerFeedback>> getAll() {
		return new SuccessDataResult<List<CustomerFeedback>>(this.customerFeedbackDao.findAll());
	}

	@Override
	public DataResult<CustomerFeedback> getAllById(int id) {
		return new SuccessDataResult<CustomerFeedback>(this.customerFeedbackDao.findAllById(id));
	}

	@Override
	public Result Add(CustomerFeedback customerFeedback) {
		this.customerFeedbackDao.save(customerFeedback);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.customerFeedbackDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, CustomerFeedback customerFeedback) {
		CustomerFeedback customerFeedback2= this.customerFeedbackDao.findAllById(id);
		
		customerFeedback2.setCutomerName(customerFeedback.getCutomerName());
		
		customerFeedback2.setCustomerComment(customerFeedback.getCustomerComment());
		
		
	
		
		
		this.customerFeedbackDao.save(customerFeedback2);
		return new SuccessResult("Güncellendi");


	}
}
