package fr.macademia.macablog.model.services;

import java.util.List;
import java.util.Optional;



import fr.macademia.macablog.model.entities.SubThematiques;



public interface SubThematiqueService {
	
	Optional<SubThematiques> getSubThematiquesById(Long id);
	List<SubThematiques> getAllSubThematiques();
	Optional<SubThematiques> getSubThematiquesBySubName(String subThematiqueName);

}
