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
@Table(name = "contact_information")
public class ContactInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "phone")
	private String phone;
	@Column(name = "gsm")
	private String gsm;
	@Column(name = "email")
	private String email;
	@Column(name = "support_line")
	private String supportLine;
	
	@Column(name = "address")
	private String address;


	@Column(name = "created_date")
	private Date createdDate;


}
