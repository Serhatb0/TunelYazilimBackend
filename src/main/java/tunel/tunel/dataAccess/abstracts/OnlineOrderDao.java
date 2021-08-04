package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.OnlineOrder;

public interface OnlineOrderDao extends JpaRepository<OnlineOrder, Integer> {

	OnlineOrder findAllById(int id);

}
