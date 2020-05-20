package fr.macademia.macablog.model.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.swing.text.html.HTML;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="articles")
public class Articles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private LocalDateTime datePublication;
	//private String contenent;
	private boolean photo = false;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST},mappedBy ="articles")
	@JsonIgnore
	private Set<Auteur> auteurList = new HashSet<Auteur>();
	
	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	//@JsonBackReference
	private Set<Keywords> keywords = new HashSet<>();
	
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	//@JsonBackReference
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	private Thematiques thematiques;
	
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	//@JsonBackReference
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	private SubThematiques subThematiques;
  
	
	public Articles(Long id, String title, LocalDateTime datePublication, boolean photo, Set<Auteur> auteurList,
			 Set<Keywords> keywords, Thematiques thematiques,
			 SubThematiques subThematiques) {
		super();
		this.id = id;
		this.title = title;
		this.datePublication = datePublication;
		this.photo = photo;
		this.auteurList = auteurList;
		this.keywords = keywords;
		this.thematiques = thematiques;
		this.subThematiques = subThematiques;
	}



	public Articles(String title, LocalDateTime datePublication, boolean photo, Set<Auteur> auteurList,
			 Set<Keywords> keywords,  Thematiques thematiques,
			 SubThematiques subThematiques) {
		super();
		this.title = title;
		this.datePublication = datePublication;
		this.photo = photo;
		this.auteurList = auteurList;
		this.keywords = keywords;
		this.thematiques = thematiques;
		this.subThematiques = subThematiques;
	}




	public Articles(String title, LocalDateTime datePublication) {
		super();
		this.title = title;
		this.datePublication = datePublication;
	}




	public Articles(String title, Set<Auteur> auteurList,  Set<Keywords> keywords,
			 SubThematiques subThematiques) {
		super();
		this.title = title;
		this.auteurList = auteurList;
		this.keywords = keywords;
		this.subThematiques = subThematiques;
	}




	public Articles() {
		super();
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String gettitle() {
		return title;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(LocalDateTime datePublication) {
		this.datePublication = datePublication;
	}

	public boolean isPhoto() {
		return photo;
	}

	public void setPhoto(boolean photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




//	public String getContenent() {
//		return contenent;
//	}
//
//
//
//
//	public void setContenent(String contenent) {
//		this.contenent = contenent;
//	}




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




//	@Override
//	public String toString() {
//		return "Articles [id=" + id + ", title=" + title + ", datePublication=" + datePublication + ", photo=" + photo
//				+ ", auteurList=" + auteurList + ", keywords=" + keywords + ", Thematiques=" + thematiques
//				+ ", subThematiques=" + subThematiques + "]";
//	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id,title);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
