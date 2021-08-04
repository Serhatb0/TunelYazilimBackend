package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;

import tunel.tunel.entities.concretes.SocialMedia;

public interface SocialMediaService {
	

	DataResult<List<SocialMedia>> getAll();

	DataResult<SocialMedia> getAllById(int id);

	Result Add(SocialMedia socialMedia);

	Result Delete(int id);

	Result update(int id, SocialMedia socialMedia);

}
