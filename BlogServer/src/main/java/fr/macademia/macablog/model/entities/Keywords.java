package fr.macademia.macablog.model.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;



import fr.macademia.macablog.model.entities.Articles;

import fr.macademia.macablog.model.entities.SubThematiques;
import fr.macademia.macablog.model.entities.Thematiques;



@Entity
@Table(name = "keywords")
public class Keywords {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long id;
	@NotFound(action=NotFoundAction.IGNORE)
	@NotNull
	private String name;
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST},mappedBy ="keywords")
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Thematiques> thematiques = new HashSet<Thematiques>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST},mappedBy ="keywords")
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<SubThematiques> subThematiques = new HashSet<SubThematiques>();
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST},mappedBy ="keywords")
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Articles> articles = new HashSet<Articles>();
	
	
	public Keywords() {
		super();
	}

	
	public Keywords(@NotNull Long id, @NotNull String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Keywords(@NotNull String name, Set<Thematiques> thematiques) {
		super();
		this.name = name;
		this.thematiques = thematiques;
	}


	public Keywords(@NotNull Long id, @NotNull String name, Set<Articles> articles) {
		super();
		this.id = id;
		this.name = name;
		this.articles = articles;
	}


	public Keywords(@NotNull String name, Set<Thematiques> thematiques, Set<SubThematiques> subThematiques,
			Set<Articles> articles) {
		super();
		this.name = name;
		this.thematiques = thematiques;
		this.subThematiques = subThematiques;
		this.articles = articles;
	}


	public Keywords(@NotNull Long id, @NotNull String name, Set<Thematiques> thematiques,
			Set<SubThematiques> subThematiques, Set<Articles> articles) {
		super();
		this.id = id;
		this.name = name;
		this.thematiques = thematiques;
		this.subThematiques = subThematiques;
		this.articles = articles;
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


	public Set<Thematiques> getThematiques() {
		return thematiques;
	}


	public void setThematiques(Set<Thematiques> thematiques) {
		this.thematiques = thematiques;
	}


	public Set<SubThematiques> getSubThematiques() {
		return subThematiques;
	}


	public void setSubThematiques(Set<SubThematiques> subThematiques) {
		this.subThematiques = subThematiques;
	}


	public Set<Articles> getArticles() {
		return articles;
	}


	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name);
	}
//	@Override
//	public String toString() {
//		return "Keywords [id=" + id + ", name=" + name +  "]";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}