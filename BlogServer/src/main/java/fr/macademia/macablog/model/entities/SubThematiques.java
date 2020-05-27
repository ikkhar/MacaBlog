package fr.macademia.macablog.model.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name="subThematiques")
public class SubThematiques {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String  subName;
	@OneToMany(mappedBy = "subThematiques", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	private Set<Articles> articles = new HashSet<Articles>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	private Set<Keywords> keywords = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST})
    @NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnore
	private Thematiques thematiques;
	
	
	
	



	public SubThematiques() {
		super();
	}







	public SubThematiques(Long id, String subName, Set<Articles> articles, Set<Keywords> keywords,
			Thematiques thematiques) {
		super();
		this.id = id;
		this.subName = subName;
		this.articles = articles;
		this.keywords = keywords;
		this.thematiques = thematiques;
	}


	public SubThematiques(String subName, Set<Articles> articles, Set<Keywords> keywords, Thematiques thematiques) {
		super();
		this.subName = subName;
		this.articles = articles;
		this.keywords = keywords;
		this.thematiques = thematiques;
	}







	public SubThematiques(String subName, Set<Articles> articles, Set<Keywords> keywords) {
		super();
		this.subName = subName;
		this.articles = articles;
		this.keywords = keywords;
	}







	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public String getSubName() {
		return subName;
	}







	public void setSubName(String subName) {
		this.subName = subName;
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







	public Thematiques getThematiques() {
		return thematiques;
	}







	public void setThematiques(Thematiques thematiques) {
		this.thematiques = thematiques;
	}





	@Override
	public int hashCode() {
		return Objects.hash(id,subName);
	}

//	@Override
//	public String toString() {
//		return "SubThematiques [id=" + id + ", subName=" + subName + ", thematiques=" + thematiques + "]";
//	}

	
	

	
	
	
	
	
}
