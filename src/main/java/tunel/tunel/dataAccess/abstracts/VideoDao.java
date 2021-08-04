package tunel.tunel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.Video;

public interface VideoDao extends JpaRepository<Video, Integer> {

	Video findAllById(int id);

}
