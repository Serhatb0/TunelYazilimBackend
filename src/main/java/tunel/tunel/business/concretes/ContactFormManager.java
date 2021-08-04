package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.ContactFormService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.ContactFormDao;
import tunel.tunel.entities.concretes.ContactForm;


@Service
public class ContactFormManager implements ContactFormService {

	private ContactFormDao contactFormDao;
	
	
	@Autowired
	public ContactFormManager(ContactFormDao contactFormDao) {
		super();
		this.contactFormDao = contactFormDao;
	}

	@Override
	public DataResult<List<ContactForm>> getAll() {
		return new SuccessDataResult<List<ContactForm>>(this.contactFormDao.findAll());
	}

	@Override
	public DataResult<ContactForm> getAllById(int id) {
		return new SuccessDataResult<ContactForm>(this.contactFormDao.findAllById(id));
	}

	@Override
	public Result Add(ContactForm contactForm) {
		this.contactFormDao.save(contactForm);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.contactFormDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, ContactForm contactForm) {
		ContactForm contactForm2= this.contactFormDao.findAllById(id);
		
		contactForm2.setEmail(contactForm.getEmail());
		contactForm2.setFirstName(contactForm.getFirstName());
		contactForm2.setGsm(contactForm.getGsm());
		contactForm2.setMessage(contactForm.getMessage());
		contactForm2.setPhone(contactForm.getPhone());
	
		
		
		this.contactFormDao.save(contactForm2);
		return new SuccessResult("Güncellendi");}
	

}
