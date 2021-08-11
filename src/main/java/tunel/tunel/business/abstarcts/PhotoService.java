package tunel.tunel.business.abstarcts;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import tunel.tunel.core.utilities.results.DataResult;
import tunel.tunel.core.utilities.results.Result;
import tunel.tunel.entities.concretes.Photo;
import tunel.tunel.entities.dto.PhotoAddDto;

public interface PhotoService {

	DataResult<List<Photo>> getAll();

	Result delete(int id);

	DataResult<Optional<Photo>> getById(int id);

	Result add(PhotoAddDto photoAddDto, MultipartFile file);

	Boolean isExists(int id);

	DataResult<List<Photo>> getAllProductId(int id);

	DataResult<List<Photo>> getAllNewsNameId(int id);

	DataResult<List<Photo>> getAllReferencesId(int id);
}
