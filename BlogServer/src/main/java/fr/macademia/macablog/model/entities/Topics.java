package fr.macademia.macablog.model.entities;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


//@Entity
//@Table(name="topics")
public class Topics {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotNull
//	private Long id;
//	@Column(name ="Thematiques", nullable=false)
	private Thematiques thematiques ;
	
	
	public Topics( Thematiques thematiques) {
		super();
		
		this.thematiques = thematiques;
	}
	
	@Override
	public String toString() {
		return "Topics [thematiques=" + thematiques + "]";
	}

	
	
	
}
