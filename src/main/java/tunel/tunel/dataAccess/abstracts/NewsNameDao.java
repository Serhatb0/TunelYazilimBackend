package tunel.tunel.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.NewsName;

public interface NewsNameDao extends JpaRepository<NewsName, Integer> {

	NewsName findAllById(int id);
	Page<NewsName> findByactiveTrue(Pageable pageable);
	
	List<NewsName> getAllByactiveTrue();

}
