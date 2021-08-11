package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.CustomerFeedback;

public interface CustomerFeedbackDao extends JpaRepository<CustomerFeedback, Integer> {

	CustomerFeedback findAllById(int id);

}
