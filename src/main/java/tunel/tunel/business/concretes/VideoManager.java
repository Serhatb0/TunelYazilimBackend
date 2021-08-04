package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.VideoSerivce;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.VideoDao;

import tunel.tunel.entities.concretes.Video;

@Service
public class VideoManager implements VideoSerivce {

	private VideoDao videoDao;
	
	
	@Autowired
	public VideoManager(VideoDao videoDao) {
		super();
		this.videoDao = videoDao;
	}

	@Override
	public DataResult<List<Video>> getAll() {
		return new SuccessDataResult<List<Video>>(this.videoDao.findAll());
	}

	@Override
	public DataResult<Video> getAllById(int id) {
		return new SuccessDataResult<Video>(this.videoDao.findAllById(id));
	}

	@Override
	public Result Add(Video video) {
		this.videoDao.save(video);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.videoDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, Video video) {
		Video video2= this.videoDao.findAllById(id);
		
		video2.setVideoName(video.getVideoName());
		video2.setVideoUrl(video.getVideoUrl());

		
		this.videoDao.save(video2);
		return new SuccessResult("Güncellendi");
	}

}
