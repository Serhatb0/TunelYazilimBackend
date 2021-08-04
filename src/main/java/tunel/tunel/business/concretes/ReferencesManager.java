package tunel.tunel.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tunel.tunel.business.abstarcts.ReferencesService;
import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.core.utilities.results.SuccessDataResult;
import tunel.tunel.core.utilities.results.SuccessResult;
import tunel.tunel.dataAccess.abstracts.ReferencesDao;

import tunel.tunel.entities.concretes.References;

@Service
public class ReferencesManager implements ReferencesService{
	
	private ReferencesDao referencesDao;
	
	
	@Autowired
	public ReferencesManager(ReferencesDao referencesDao) {
		super();
		this.referencesDao = referencesDao;
	}

	@Override
	public DataResult<List<References>> getAll() {
		return new SuccessDataResult<List<References>>(this.referencesDao.findAll());
	}

	@Override
	public DataResult<References> getAllById(int id) {
		return new SuccessDataResult<References>(this.referencesDao.findAllById(id));
	}

	@Override
	public Result Add(References references) {
		this.referencesDao.save(references);
		return new SuccessResult("Data Kaydedildi");
	}

	@Override
	public Result Delete(int id) {
		this.referencesDao.deleteById(id);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public Result update(int id, References references) {
		References references2 = this.referencesDao.findAllById(id);
		
		references2.setReferencesDescription(references.getReferencesDescription());
		references2.setReferencesLink(references.getReferencesLink());
		references2.setReferencesName(references.getReferencesName());
		
		this.referencesDao.save(references2);
		return new SuccessResult("Güncellendi");
	}

}
