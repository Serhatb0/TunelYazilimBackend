package tunel.tunel.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "product_name")
	private String productName;
	
	
	@Column(name = "product_description")
	private String productDescription;
	
	
	@Column(name = "created_date")
	 private Date createdDate;
	
	@OneToMany(mappedBy = "product")
	private List<Photo> photos;
	

	@OneToMany(mappedBy = "products")
	private List<SiteFeatures> siteFeatures;
}
