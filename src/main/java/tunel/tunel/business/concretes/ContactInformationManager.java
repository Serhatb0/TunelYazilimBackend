package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.ContactInformationSerivce;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.ContactInformationDao;
import tunel.tunel.entities.concretes.ContactInformation;

@Service
public class ContactInformationManager implements ContactInformationSerivce {
	private ContactInformationDao contactInformationDao;
	
	@Autowired
	public ContactInformationManager(ContactInformationDao contactInformationDao) {
		super();
		this.contactInformationDao = contactInformationDao;
	}

	@Override
	public DataResult<List<ContactInformation>> getAll() {
		return new SuccessDataResult<List<ContactInformation>>(this.contactInformationDao.findAll());
	}

	@Override
	public DataResult<ContactInformation> getAllById(int id) {
		return new SuccessDataResult<ContactInformation>(this.contactInformationDao.findAllById(id));
	}

	@Override
	public Result Add(ContactInformation contactInformation) {
		this.contactInformationDao.save(contactInformation);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.contactInformationDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, ContactInformation contactInformation) {
		ContactInformation contactInformation2= this.contactInformationDao.findAllById(id);
		
		contactInformation2.setAddress(contactInformation.getAddress());
		contactInformation2.setEmail(contactInformation.getEmail());
		contactInformation2.setGsm(contactInformation.getGsm());
		contactInformation2.setPhone(contactInformation.getPhone());
		contactInformation2.setSupportLine(contactInformation.getSupportLine());
		
		this.contactInformationDao.save(contactInformation2);
		return new SuccessResult("Güncellendi");
	}


}
