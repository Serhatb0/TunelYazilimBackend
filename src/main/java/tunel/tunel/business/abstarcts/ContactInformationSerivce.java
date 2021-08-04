package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.entities.concretes.ContactInformation;


public interface ContactInformationSerivce {
	DataResult<List<ContactInformation>> getAll();

	DataResult<ContactInformation> getAllById(int id);

	Result Add(ContactInformation contactInformation);

	Result Delete(int id);

	Result update(int id, ContactInformation contactInformation);

}
