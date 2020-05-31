package fr.macademia.macablog.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.macademia.macablog.model.entities.Auteur;
import fr.macademia.macablog.model.repositories.AuteurRepository;

@Service(value = "AuteurService")
public class AuteurServiceImpl implements AuteurService {
	
	@Autowired
	AuteurRepository auteurRepository;

	@Override
	public Optional<Auteur> getAuteurById(Long id) {
		
		return auteurRepository.findById(id);
	}


}
