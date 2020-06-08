package fr.macademia.macablog.model.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.macademia.macablog.model.entities.Thematiques;
import fr.macademia.macablog.model.repositories.ThematiquesRepository;
@Service(value = "thematiquesService")
public class ThematiquesServiceImpl implements ThematiquesService {

	@Autowired
	 private ThematiquesRepository thematiquesRepository;

	@Override
	public Optional<Thematiques> getThematiquessById(Long id) {
		
		return thematiquesRepository.findById(id);
	}


	@Override
	public List<Thematiques> getAllThematiques() {
		// TODO Auto-generated method stub
		return thematiquesRepository.findAll();
	}


	@Override
	public Optional<Thematiques> getThematiquessByName(String thematiqueName) {
		// TODO Auto-generated method stub
		return thematiquesRepository.findByName(thematiqueName);
	}
	
	

	
	
}
