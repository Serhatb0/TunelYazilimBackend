package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.api.controllers.ProductController;
import tunel.tunel.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	Product findAllById(int id);

}
