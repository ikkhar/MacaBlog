package fr.macademia.macablog.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.macademia.macablog.model.repositories.AuteurRepository;

@Service(value = "AuteurService")
public class AuteurServiceImpl implements AuteurService {
	
	@Autowired
	AuteurRepository auteurRepository;


}
