package tunel.tunel.business.abstarcts;

import java.util.List;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;

import tunel.tunel.entities.concretes.Video;

public interface VideoSerivce {
	

	DataResult<List<Video>> getAll();

	DataResult<Video> getAllById(int id);

	Result Add(Video video);

	Result Delete(int id);

	Result update(int id, Video video);

}
