package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.ContactInformation;

public interface ContactInformationDao extends JpaRepository<ContactInformation, Integer> {

	ContactInformation findAllById(int id);

}
