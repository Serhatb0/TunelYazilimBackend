package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.NewsNameService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.NewsNameDao;
import tunel.tunel.entities.concretes.NewsName;


@Service
public class NewsNameManager implements NewsNameService {

	private NewsNameDao newsNameDao;
	
	
	@Autowired
	public NewsNameManager(NewsNameDao newsNameDao) {
		super();
		this.newsNameDao = newsNameDao;
	}

	@Override
	public DataResult<List<NewsName>> getAll() {
		return new SuccessDataResult<List<NewsName>>(this.newsNameDao.findAll());
	}

	@Override
	public DataResult<NewsName> getAllById(int id) {
		return new SuccessDataResult<NewsName>(this.newsNameDao.findAllById(id));
	}

	@Override
	public Result Add(NewsName newsName) {
		this.newsNameDao.save(newsName);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.newsNameDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, NewsName newsName) {
		NewsName newsName2= this.newsNameDao.findAllById(id);
		
		newsName2.setNewsDescription(newsName.getNewsDescription());
		newsName2.setNewsName(newsName.getNewsName());
		
		this.newsNameDao.save(newsName2);
		return new SuccessResult("Güncellendi");
	}

}
