package fr.macademia.macablog.model.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.macademia.macablog.model.repositories.ThematiquesRepository;
@Service(value = "thematiquesService")
public class ThematiquesServiceImpl implements ThematiquesService {

	@Autowired
	 private ThematiquesRepository thematiquesRepository;
	
	

	
	
}
