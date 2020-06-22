package fr.macademia.macablog.model.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "articlesList")
public class Articles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@PastOrPresent
	private Date datePublication;
	
	@Column(columnDefinition = "TEXT")
	private String resume;

	@Column(columnDefinition = "TEXT")
	private String contenent;

	private boolean photo = false;

	@ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
	
	private Set<Auteur> auteurList = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Set<Keywords> keywords = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST})
    @NotFound(action=NotFoundAction.IGNORE)
	
	private Thematiques thematiques;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST})
    @NotFound(action=NotFoundAction.IGNORE)
	
	private SubThematiques subThematiques;

	public Articles() {
		super();
	}

	
	public Articles(Long id, String title, @PastOrPresent Date datePublication, String resume, String contenent,
			boolean photo, Set<Auteur> auteurList, Set<Keywords> keywords, Thematiques thematiques,
			SubThematiques subThematiques) {
		super();
		this.id = id;
		this.title = title;
		this.datePublication = datePublication;
		this.resume = resume;
		this.contenent = contenent;
		this.photo = photo;
		this.auteurList = auteurList;
		this.keywords = keywords;
		this.thematiques = thematiques;
		this.subThematiques = subThematiques;
	}


	public Articles(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}


	public Articles(Long id, String title, String resume) {
		super();
		this.id = id;
		this.title = title;
		this.resume = resume;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getDatePublication() {
		return datePublication;
	}


	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}


	public String getResume() {
		return resume;
	}


	public void setResume(String resume) {
		this.resume = resume;
	}


	public String getContenent() {
		return contenent;
	}


	public void setContenent(String contenent) {
		this.contenent = contenent;
	}


	public boolean isPhoto() {
		return photo;
	}


	public void setPhoto(boolean photo) {
		this.photo = photo;
	}


	public Set<Auteur> getAuteurList() {
		return auteurList;
	}


	public void setAuteurList(Set<Auteur> auteurList) {
		this.auteurList = auteurList;
	}


	public Set<Keywords> getKeywords() {
		return keywords;
	}


	public void setKeywords(Set<Keywords> keywords) {
		this.keywords = keywords;
	}


	public Thematiques getThematiques() {
		return thematiques;
	}


	public void setThematiques(Thematiques thematiques) {
		this.thematiques = thematiques;
	}


	public SubThematiques getSubThematiques() {
		return subThematiques;
	}


	public void setSubThematiques(SubThematiques subThematiques) {
		this.subThematiques = subThematiques;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, title);
	}

	@Override
	public String toString() {
		return "Articles [id=" + id + ", title=" + title + ", datePublication=" + datePublication + ", contenent="
				+ contenent + "]";
	}

}
