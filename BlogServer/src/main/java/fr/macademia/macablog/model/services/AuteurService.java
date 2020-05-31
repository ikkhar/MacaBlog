package fr.macademia.macablog.model.services;

import java.util.Optional;

import fr.macademia.macablog.model.entities.Auteur;

public interface AuteurService {
	Optional<Auteur> getAuteurById(Long id);
}
