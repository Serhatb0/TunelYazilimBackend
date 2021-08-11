package tunel.tunel.entities.dto;



import lombok.Data;

@Data
public class PhotoAddDto {
	

	private int productId;

	private int newsId;

	private int referencesId;

	private String name;

	private String photoUrl;

	private String deleteId;
}
