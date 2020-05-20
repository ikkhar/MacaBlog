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
import fr.macademia.macablog.model.entities.Auteur;
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
	private Set<SubThematiques> subthematiques = new HashSet<SubThematiques>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST},mappedBy ="keywords")
	@JsonIgnore
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Articles> articles = new HashSet<Articles>();
	
	
	public Keywords() {
		super();
	}

	public Keywords(Long id, String name, Set<Thematiques> thematiques, Set<Articles> articles) {
		super();
		this.id = id;
		this.name = name;
		this.thematiques = thematiques;
		this.articles = articles;
		
	}

	public Keywords(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Keywords(String name, Set<Thematiques> thematiques, Set<Articles> articles) {
		super();
		this.name = name;
		this.thematiques = thematiques;
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

	public Set<Articles> getArticles() {
		return articles;
	}

	public Set<SubThematiques> getSubthematiques() {
		return subthematiques;
	}

	public void setSubthematiques(Set<SubThematiques> subthematiques) {
		this.subthematiques = subthematiques;
	}

	public void setArticles(Set<Articles> articles) {
		this.articles = articles;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id,name);
	}
	

	@Override
	public String toString() {
		return "Keywords [id=" + id + ", name=" + name + ", thematiques=" + thematiques + ", articles=" + articles
				+  "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}