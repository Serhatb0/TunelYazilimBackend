package tunel.tunel.entities.concretes;

import java.util.Date;
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
@Table(name = "news_name")
public class NewsName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "news_name")
	private String newsName;
	
	@Column(name = "news_description")
	private String newsDescription;
	
	@Column(name = "created_date")
	 private Date createdDate;
	
	@Column(name="active")
	private Boolean active;
	
	@OneToMany(mappedBy = "newsName")
	private List<Photo> photos;

}
