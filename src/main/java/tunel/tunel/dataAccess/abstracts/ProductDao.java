package tunel.tunel.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import tunel.tunel.entities.concretes.Product;


public interface ProductDao extends JpaRepository<Product, Integer> {

	Product findAllById(int id);
	
	Page<Product> findByactiveTrue(Pageable pageable);
	
	List<Product> getAllByactiveTrue();
}
