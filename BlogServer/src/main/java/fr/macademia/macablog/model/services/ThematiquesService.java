package fr.macademia.macablog.model.services;

import java.util.List;
import java.util.Optional;


import fr.macademia.macablog.model.entities.Thematiques;


public interface ThematiquesService {
	
	Optional<Thematiques> getThematiquessById(Long id);
	List<Thematiques> getAllThematiques();
	Optional<Thematiques> getThematiquessByName(String thematiqueName);
}
