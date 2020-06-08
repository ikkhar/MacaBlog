package fr.macademia.macablog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.macademia.macablog.model.entities.Articles;
import fr.macademia.macablog.model.entities.SubThematiques;
import fr.macademia.macablog.model.entities.Thematiques;
import fr.macademia.macablog.model.repositories.ArticlesRepository;
import fr.macademia.macablog.model.repositories.SubThematiquesRepository;
import fr.macademia.macablog.model.services.ArticlesService;
import fr.macademia.macablog.model.services.SubThematiqueService;
import fr.macademia.macablog.model.services.ThematiquesService;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/articles")
@RequestMapping(value = "/articles", produces = { "application/json; charset=UTF-8", "*/*;charset=UTF-8" })
public class ThematiquesController {

	@Autowired
	private ThematiquesService thematiquesService;

	@Autowired
	private SubThematiqueService subThematiqueService;

	

	//////////////////////// THEMATIQUES
	//////////////////////// ROUTES////////////////////////////////////////////////////////
	// requette pour trouver la liste des thématiques

	
	// requette pour trouverthématiques par id
	@GetMapping(value = "/thematiques/{id}")
	public ResponseEntity<Thematiques> getThematiquesById(@PathVariable(value = "id") Long id) {
		Thematiques thematique = this.thematiquesService.getThematiquessById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucune thematique trouvée  avec l'id : " + id));
		return new ResponseEntity<Thematiques>(thematique, HttpStatus.OK);
	}

	// requette pour trouver thematique par nom /*Remarque : on a bad request quand le nom est composé expl base de données"
	@GetMapping(value = "/thematiques/name/{name}")
	public ResponseEntity<Thematiques> getThematiqueByName(@PathVariable(value = "name") String name) {
		Thematiques thematiqueByName = this.thematiquesService.getThematiquessByName(name)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucune thématique trouvée avec le titre : " + name));
		return new ResponseEntity<Thematiques>(thematiqueByName, HttpStatus.OK);
	}

	///////////////////////////////////////////// SUBTHEMATIQUES
	///////////////////////////////////////////// ROUTES////////////////////////////////////////////////
	@GetMapping(value = "/thematiques")
	public ResponseEntity<List<Thematiques>> getAllThematiques() {
		List<Thematiques> listThematiques = this.thematiquesService.getAllThematiques();
		return new ResponseEntity<List<Thematiques>>(listThematiques, HttpStatus.OK);
	}

	// requette pour trouver la liste des Subthématiques

	@GetMapping(value = "/sub_thematiques")
	public ResponseEntity<List<SubThematiques>> getAllSubThematiques() {
		List<SubThematiques> listSubThematiques = this.subThematiqueService.getAllSubThematiques();
		return new ResponseEntity<List<SubThematiques>>(listSubThematiques, HttpStatus.OK);
	}

	// requette pour trouverthématiques par id
	@GetMapping(value = "/sub_thematiques/{id}")
	public ResponseEntity<SubThematiques> getSubThematiqueById(@PathVariable(value = "id") Long id) {
		SubThematiques thematique = this.subThematiqueService.getSubThematiquesById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucune thematique trouvée  avec l'id : " + id));
		return new ResponseEntity<SubThematiques>(thematique, HttpStatus.OK);
	}

	// requette pour trouver thematique par nom
	@GetMapping(value = "/sub_thematiques/sub_name/{sub_name}")
	public ResponseEntity<SubThematiques> getSubThematiqueByName(@PathVariable(value = "sub_name") String sub_name) {
		SubThematiques subThematiqueByName = this.subThematiqueService.getSubThematiquesBySubName(sub_name)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucune Subthématique trouvée avec le titre : " + sub_name));
		return new ResponseEntity<SubThematiques>(subThematiqueByName, HttpStatus.OK);
	}
}
