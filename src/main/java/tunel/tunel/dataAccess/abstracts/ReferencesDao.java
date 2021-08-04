package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.References;

public interface ReferencesDao extends JpaRepository<References, Integer> {

	References findAllById(int id);

}
