package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.ContactForm;

public interface ContactFormDao extends JpaRepository<ContactForm, Integer> {

	ContactForm findAllById(int id);

}
