package fr.macademia.macablog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.macademia.macablog.model.entities.Articles;
import fr.macademia.macablog.model.repositories.ArticlesRepository;
import fr.macademia.macablog.model.services.ArticlesService;





@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/articles")
public class ArticlesController {
	
	@Autowired
	private ArticlesService articlesService;
	
	@Autowired
	private ArticlesRepository articlesRepository;

	

//	public ArticlesController(ArticlesService articlesService) {
//		super();
//		this.articlesService = articlesService;
//	}

	public ArticlesController(ArticlesRepository articlesRepository) {
		super();
		this.articlesRepository = articlesRepository;
	}
//	@GetMapping(value = "")
//	public List<Articles> getAllArticles() {
//		return articlesService.getAllArticles();}
// requette pour trouver la liste des articles
	@GetMapping(value = "")
	public ResponseEntity<List<Articles>> getAllArticles() {
		List<Articles> listArticles = this.articlesService.getAllArticles();
		return new ResponseEntity<List<Articles>>(listArticles, HttpStatus.OK);
	}
	
	// afficher la liste des 10 derniers articles toute thématiques confondues (a afficher sur la première page du blog)
	
		@GetMapping(value = "/getLastTenArticles")
		public ResponseEntity<ArrayList<Articles>> getAllLastTenArticles() {
			ArrayList<Articles> listeLastTenArticles = this.articlesService.getLastTenArticles();
			return new ResponseEntity<ArrayList<Articles>>(listeLastTenArticles, HttpStatus.OK);
		}
	
		// Trouver un article par son id
		@GetMapping(value = "/{id}")
		public ResponseEntity<Articles> getArticlesById(@PathVariable(value = "id") Long id) {
			Articles article = this.articlesService.getArticlesById(id).orElseThrow(
					() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvée avec l'id : " + id));
			return new ResponseEntity<Articles>(article, HttpStatus.OK);
		}
	
	
	
// requette pour trouver un article par son titre : sous reserve car le titre est une chaine de caractere (phrase )	
	@GetMapping(value = "/title/{title}")
	public ResponseEntity<Articles> getArticlesByName(@PathVariable(value = "title") String title) {
		Articles articlesFromDb = this.articlesService.getArticlesByTitle(title)
				.orElseThrow(
					() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Aucune article trouvée avec le titre : " +title)
					);
		return new ResponseEntity<Articles>(articlesFromDb, HttpStatus.OK);
	}
	
//Trouver un article par l'id d'une thematique	
	 @GetMapping(value = "/thematique/{thematiqueId}")
	    public ResponseEntity<List<Articles>> getAllArticlesByThematiquesId(@PathVariable(value = "thematiqueId") Long thematiqueId) {
	        List<Articles>listArticleByThemId = this.articlesService.getArticlesByThematiquesId(thematiqueId)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id de la thematique : " +thematiqueId));
	        return new ResponseEntity<List<Articles>>(listArticleByThemId, HttpStatus.OK);
	    }
	
	//Trouver un article par l'id d'une subthematique	
		 @GetMapping(value = "/subthematique/{sub_thematiqueId}")
		    public ResponseEntity<List<Articles>> getAllArticlesBySubThematiquesId(@PathVariable(value = "sub_thematiqueId") Long sub_thematiqueId) {
		        List<Articles>listArticleBySubThemId = this.articlesService.getArticlesBySubThematiquesId(sub_thematiqueId)
		                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvé avec l'id de la subthematique : " +sub_thematiqueId));
		        return new ResponseEntity<List<Articles>>(listArticleBySubThemId, HttpStatus.OK);
		    }
			 
	 
// Trouver un artciles par nom de thematiques
	@GetMapping(value = "/thematiquesName/{thematiques}")
	public ResponseEntity<List<Articles>> getAllArticlesByThematiquesName(@PathVariable(value = "thematiques") String thematiques) {
		List<Articles> listArticleParThem = this.articlesService.getArticlesByThematiquesName(thematiques)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucun article trouvé avec le nom de la thematique : " + thematiques));
		return new ResponseEntity<>(listArticleParThem, HttpStatus.OK);
	}
// Trouver un artciles par nom de sous thematiques
		@GetMapping(value = "subThematiquesName/{subThematiquesName}")
		public ResponseEntity<List<Articles>> getAllArticlesByThematiquesSubName(@PathVariable(value = "subThematiques") String subThematiques) {
			List<Articles> listArticleParSubThem = this.articlesService.getArticlesBySubThematiquesSubName(subThematiques)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
							"Aucun article trouvé avec le nom de la sous thematique : " + subThematiques));
			return new ResponseEntity<>(listArticleParSubThem, HttpStatus.OK);
		}
		
// requette pour chercher un article par mot clé saisi par l'utilisateur
	@GetMapping(value = "/search/{keyword}", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<String>> search(@PathVariable("keyword") String keyword) {
		
			List<String> listArticles = this.articlesService.searchArticles(keyword)
					.orElseThrow(
						() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aucun matching avec le keyword : "+keyword)
					);
			return new ResponseEntity<List<String>>(listArticles, HttpStatus.OK);
	}


}
