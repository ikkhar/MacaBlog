package fr.macademia.macablog.model.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


/// Classe Auteur par article (qui peut servir à recherche par mot clée (a voir))

@Entity
@Table(name="auteur")
public class Auteur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 20, message = "firstName must be between 2 and 20 characters")
	private String firstName;
	
	@Size(min = 2, max = 20, message = "lastName must be between 2 and 20 characters")
    private String lastName;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Email should be valid")
	private String email;
	private String mobileNumber;
	private String adresse;
	private String qualification;
	private String organisation;
	private boolean photo = false;
	// plusieurs auteurs ont plusieur articles
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Articles> articlesList = new HashSet<>();
	
	///////////////////////////:
	public Auteur() {
		super();
	}

	public Auteur(Long id,
			@Size(min = 2, max = 20, message = "firstName must be between 2 and 20 characters") String firstName,
			@Size(min = 2, max = 20, message = "lastName must be between 2 and 20 characters") String lastName,
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,
			String mobileNumber, String adresse, String qualification, String organisation, boolean photo,
			Set<Articles> articlesList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.adresse = adresse;
		this.qualification = qualification;
		this.organisation = organisation;
		this.photo = photo;
		this.articlesList = articlesList;
	}

	public Auteur(Long id,
			@Size(min = 2, max = 20, message = "firstName must be between 2 and 20 characters") String firstName,
			@Size(min = 2, max = 20, message = "lastName must be between 2 and 20 characters") String lastName,
			Set<Articles> articlesList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.articlesList = articlesList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public boolean isPhoto() {
		return photo;
	}

	public void setPhoto(boolean photo) {
		this.photo = photo;
	}

	public Set<Articles> getArticlesList() {
		return articlesList;
	}

	public void setArticlesList(Set<Articles> articlesList) {
		this.articlesList = articlesList;
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", adresse=" + adresse + ", qualification=" + qualification
				+ ", organisation=" + organisation + ", photo=" + photo + ", articlesList=" + articlesList + "]";
	}

	
	
	

	
	
	
	
	
	
	
	

}
