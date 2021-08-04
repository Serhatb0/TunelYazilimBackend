package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.AboutUs;

public interface AboutUsDao extends JpaRepository<AboutUs, Integer> {

	AboutUs findAllById(int id);

}
