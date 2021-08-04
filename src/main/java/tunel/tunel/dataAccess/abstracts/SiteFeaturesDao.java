package tunel.tunel.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tunel.tunel.entities.concretes.SiteFeatures;

public interface SiteFeaturesDao extends JpaRepository<SiteFeatures, Integer> {

	SiteFeatures findAllById(int id);
	
	List<SiteFeatures> getAllByproducts_id(int id);

}
