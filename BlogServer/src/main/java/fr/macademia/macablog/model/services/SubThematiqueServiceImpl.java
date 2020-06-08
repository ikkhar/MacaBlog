package fr.macademia.macablog.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.macademia.macablog.model.entities.SubThematiques;
import fr.macademia.macablog.model.repositories.SubThematiquesRepository;
@Service(value = "sub_thematiquesService")
public class SubThematiqueServiceImpl implements SubThematiqueService {
	@Autowired
	private SubThematiquesRepository subThematiqueRepository;

	@Override
	public Optional<SubThematiques> getSubThematiquesById(Long id) {
		// TODO Auto-generated method stub
		return subThematiqueRepository.findById(id);
	}

	@Override
	public List<SubThematiques> getAllSubThematiques() {
		// TODO Auto-generated method stub
		return subThematiqueRepository.findAll();
	}

	@Override
	public Optional<SubThematiques> getSubThematiquesBySubName(String subThematiqueName) {
		// TODO Auto-generated method stub
		return subThematiqueRepository.findBySubName(subThematiqueName);
	}
	

}
