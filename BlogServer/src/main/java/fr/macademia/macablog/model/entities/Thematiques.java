package fr.macademia.macablog.model.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "thematiques") // creation de la table thematique dans la base de donnée
public class Thematiques {
	// ------Les attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// relation persistance des données : une thematique a plusieurs articles
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	private Set<Articles> articles = new HashSet<>();
	// relation perstistance des données : plusieurs thématique peuvent avoir plusieurs mots clée , differentes thematiques peuvent avoir les meme mot clée
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	private Set<Keywords> keywords = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy ="thematiques")
	//@JsonBackReference
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	private Set<SubThematiques> subThematiques = new HashSet<>();
	
	
	// Les constructeur : vide, globale, avec nom, avec nom+ articles, avec nom+keywords/////////
	public Thematiques() {
		super();
	}
	
	
	
	public Thematiques(Long id, String name,  Set<Articles> articles,  Set<Keywords> keywords,
			 Set<SubThematiques> subThematiques) {
		super();
		this.id = id;
		this.name = name;
		this.articles = articles;
		this.keywords = keywords;
		this.subThematiques = subThematiques;
	}



	public Thematiques(String name,  Set<Articles> articles,  Set<Keywords> keywords) {
		super();
		this.name = name;
		this.articles = articles;
		this.keywords = keywords;
	}



	public Thematiques(String name,  Set<Articles> articles,  Set<Keywords> keywords,
			 Set<SubThematiques> subThematiques) {
		super();
		this.name = name;
		this.articles = articles;
		this.keywords = keywords;
		this.subThematiques = subThematiques;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<Articles> getArticles() {
		return articles;
	}



	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}



	public Set<Keywords> getKeywords() {
		return keywords;
	}



	public void setKeywords(Set<Keywords> keywords) {
		this.keywords = keywords;
	}



	public Set<SubThematiques> getSubThematiques() {
		return subThematiques;
	}



	public void setSubThematiques(Set<SubThematiques> subThematiques) {
		this.subThematiques = subThematiques;
	}



	//// 
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}



	@Override
	public String toString() {
		return "Thematiques [id=" + id + ", name=" + name + ", articles=" + articles + ", keywords=" + keywords
				+ ", subThematiques=" + subThematiques + "]";
	}



	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
