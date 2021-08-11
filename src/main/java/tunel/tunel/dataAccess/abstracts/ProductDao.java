package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.api.controllers.ProductController;
import tunel.tunel.entities.concretes.Product;
import tunel.tunel.entities.concretes.References;

public interface ProductDao extends JpaRepository<Product, Integer> {

	Product findAllById(int id);
	
	Page<Product> findByactiveTrue(Pageable pageable);
}
