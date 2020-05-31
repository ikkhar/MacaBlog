package fr.macademia.macablog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import fr.macademia.macablog.model.entities.Auteur;
import fr.macademia.macablog.model.repositories.AuteurRepository;
import fr.macademia.macablog.model.services.AuteurService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auteur")
public class AuteurControlleur {
	
	@Autowired
	private AuteurService auteurService;
	
	@Autowired
	private AuteurRepository auteurRepository;

//	public AuteurControlleur(AuteurService auteurService) {
//		super();
//		this.auteurService = auteurService;
//	}

	public AuteurControlleur(AuteurRepository auteurRepository) {
		super();
		this.auteurRepository = auteurRepository;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Auteur> getAuteurById(@PathVariable(value = "id") Long id) {
		Auteur auteur = this.auteurService.getAuteurById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvée avec l'id : " + id));
		return new ResponseEntity<Auteur>(auteur, HttpStatus.OK);
	}


}
