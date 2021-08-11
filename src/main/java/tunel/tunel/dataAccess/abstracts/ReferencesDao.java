package tunel.tunel.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.References;

public interface ReferencesDao extends JpaRepository<References, Integer> {

	References findAllById(int id);
	
	Page<References> findByactiveTrue(Pageable pageable);
	
	List<References> getAllByactiveTrue();

}
