package fr.macademia.macablog.model.entities;



public class Blog {
	
private  String nom;// MacaBlog
private Auteur auteur;
private String organisme; // Macademia
private Topics topics;
public Blog(String nom, Auteur auteur, String organisme, Topics topics) {
	super();
	this.nom = nom;
	this.auteur = auteur;
	this.organisme = organisme;
	this.topics = topics;
}
public Blog() {
	super();
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Auteur getAuteur() {
	return auteur;
}
public void setAuteur(Auteur auteur) {
	this.auteur = auteur;
}
public String getOrganisme() {
	return organisme;
}
public void setOrganisme(String organisme) {
	this.organisme = organisme;
}
public Topics getTopics() {
	return topics;
}
public void setTopics(Topics topics) {
	this.topics = topics;
}




}
