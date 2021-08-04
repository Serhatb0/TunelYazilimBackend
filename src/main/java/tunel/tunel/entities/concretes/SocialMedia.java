package tunel.tunel.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "social_medias")
public class SocialMedia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "facebook_link")
	private String facebookLink;
	
	@Column(name = "twitter_link")
	private String twitterLink;
	
	@Column(name = "ınstagram_link")
	private String ınstagramLink;
	
	
	@Column(name = "created_date")
    private Date createdDate;
}
