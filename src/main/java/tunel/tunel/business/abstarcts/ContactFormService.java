package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.entities.concretes.ContactForm;


public interface ContactFormService {
	DataResult<List<ContactForm>> getAll();

	DataResult<ContactForm> getAllById(int id);

	Result Add(ContactForm contactForm);

	Result Delete(int id);

	Result update(int id, ContactForm contactForm);

}
