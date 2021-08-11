package tunel.tunel.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.Photo;


public interface PhotoDao extends JpaRepository<Photo, Integer> {
	
	List<Photo> getAllByproduct_id(int id);

	List<Photo> getAllByreference_id(int id);

	List<Photo> getAllBynewsName_id(int id);
}
