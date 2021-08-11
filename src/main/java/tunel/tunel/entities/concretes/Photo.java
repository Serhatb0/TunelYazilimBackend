package tunel.tunel.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="photos")
public class Photo {

	public Photo(String name, String photoUrl, String deleteId) {
		super();
		this.name = name;
		this.photoUrl = photoUrl;
		this.deleteId = deleteId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="photo_id")
	private int id;
	
//	@Column(name="product_id")
//	private int productId;
	
//	@Column(name="news_id")
//	private int newsId;
//	
//	@Column(name="references_id")
//	private int referencesId;

	@Column(name="name")
	private String name;
	
	@Column(name="photo_url")
	private String photoUrl;
	
	@Column(name="delete_id")
	private String deleteId;
	
	@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="product_id")
	private	Product product;
	
	@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="news_id")
	private NewsName newsName;
	
	@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="references_id")
	private References reference;
	
	
	
	
}
