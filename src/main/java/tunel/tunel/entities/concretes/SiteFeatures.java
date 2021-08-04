package tunel.tunel.entities.concretes;



import java.util.Date;

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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "site_features")
public class SiteFeatures {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "technical_specifications")
	private String technicalSpecifications;
	@Column(name = "silver")
	private String silver;
	@Column(name = "gold")
	private String gold;
	@Column(name = "diamod")
	private String diamod;
	@Column(name = "explanation")
	private String  explanation;
	
//	@Column(name = "product_id")
//	private int productId;
		
	
	@JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="product_id")
	private	Product products;
	
	
	
	@Column(name = "created_date")
    private Date createdDate;
	

}
