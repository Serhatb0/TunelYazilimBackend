package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

}
