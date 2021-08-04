package tunel.tunel.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reference")
public class References {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "references_name")
	private String referencesName;
	
	@Column(name = "references_description")
	private String referencesDescription;
	
	@Column(name = "references_link")
	private String referencesLink;
	


	@OneToMany(mappedBy = "reference")
	private List<Photo> photos;


}
