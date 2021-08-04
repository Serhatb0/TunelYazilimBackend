package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.OnlineOrderService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.OnlineOrderDao;

import tunel.tunel.entities.concretes.OnlineOrder;

@Service
public class OnlineOrderManager implements OnlineOrderService {

	private OnlineOrderDao onlineOrderDao;

	@Autowired
	public OnlineOrderManager(OnlineOrderDao onlineOrderDao) {
		super();
		this.onlineOrderDao = onlineOrderDao;
	}

	@Override
	public DataResult<List<OnlineOrder>> getAll() {
		return new SuccessDataResult<List<OnlineOrder>>(this.onlineOrderDao.findAll());
	}

	@Override
	public DataResult<OnlineOrder> getAllById(int id) {
		return new SuccessDataResult<OnlineOrder>(this.onlineOrderDao.findAllById(id));
	}

	@Override
	public Result Add(OnlineOrder onlineOrder) {
		this.onlineOrderDao.save(onlineOrder);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.onlineOrderDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, OnlineOrder onlineOrder) {
		OnlineOrder onlineOrder2 = this.onlineOrderDao.findAllById(id);

		onlineOrder2.setAddress(onlineOrder.getAddress());
		onlineOrder2.setFirstName(onlineOrder.getFirstName());
		onlineOrder2.setNote(onlineOrder.getNote());
		onlineOrder2.setPhone(onlineOrder.getPhone());

		this.onlineOrderDao.save(onlineOrder2);
		return new SuccessResult("Güncellendi");
	}

}
