package fr.macademia.macablog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import fr.macademia.macablog.tool.page.PageTool;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/articles")
@RequestMapping(value = "/articles", produces = { "application/json; charset=UTF-8", "*/*;charset=UTF-8" })
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

// Get liste articles par auteur Id
	@GetMapping(value = "/auteur/{id}")
	public ResponseEntity<List<Articles>> getArticlesByAuteurId(@PathVariable(value = "id") Long id) {
		List<Articles> article = this.articlesService.getArticlesByAuteurId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucun article trouvée pour l'auteur avec l'id : " + id));
		return new ResponseEntity<List<Articles>>(article, HttpStatus.OK);
	}

	// requette pour trouver la liste des articles
	@GetMapping(value = "/chronological_order")
	public ResponseEntity<List<Articles>> getAllArticlesByChronologicalOrder() {
		List<Articles> listOrderedArticles = this.articlesService.getAllChronologicArticles();
		return new ResponseEntity<List<Articles>>(listOrderedArticles, HttpStatus.OK);
	}
	// requette pour trouver la liste des articles
		@GetMapping(value = "/size_List")
		public ResponseEntity<Long> getsizeAllArticles() {
			Long sizeListAllArticlesBackend = this.articlesService.getSizeAllArticlesList();
			return new ResponseEntity<Long>(sizeListAllArticlesBackend, HttpStatus.OK);
		}
// requette pour trouver la liste des articles dans l'ordre decroissant 

	@GetMapping(value = "")
	public ResponseEntity<List<Articles>> getAllArticles() {
		List<Articles> listArticles = this.articlesService.getAllArticles();
		return new ResponseEntity<List<Articles>>(listArticles, HttpStatus.OK);
	}

	// afficher la liste des 10 derniers articles toute thématiques confondues (a
	// afficher sur la première page du blog)

	@GetMapping(value = "/getLastTenArticles")
	public ResponseEntity<ArrayList<Articles>> getAllLastTenArticles() {
		ArrayList<Articles> listeLastTenArticles = this.articlesService.getLastTenArticles();
		return new ResponseEntity<ArrayList<Articles>>(listeLastTenArticles, HttpStatus.OK);
	}

	// Trouver un article par son id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Articles> getArticlesById(@PathVariable(value = "id") Long id) {
		Articles article = this.articlesService.getArticlesById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun article trouvée  avec l'id : " + id));
		return new ResponseEntity<Articles>(article, HttpStatus.OK);
	}

// requette pour trouver un article par son titre : sous reserve car le titre est une chaine de caractere (phrase )	
	@GetMapping(value = "/title/{title}")
	public ResponseEntity<Articles> getArticlesByName(@PathVariable(value = "title") String title) {
		Articles articlesFromDb = this.articlesService.getArticlesByTitle(title)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucune article trouvée avec le titre : " + title));
		return new ResponseEntity<Articles>(articlesFromDb, HttpStatus.OK);
	}

	// Afficher les articles par thematique id 10 par 10 a chaque cliques

	// afficher les articles par 10 à chaque click

	@GetMapping(value = "/removeTenArticlesByClick")
	public ResponseEntity<List<Articles>> removeTenArticlesByClick(@RequestParam("clickShowLess") int clickShowLess) {
		List<Articles> listArticlesByClick = this.articlesService.removeTenArticlesByClick(clickShowLess);
		return new ResponseEntity<List<Articles>>(listArticlesByClick, HttpStatus.OK);
	}

	

	// afficher les articles par 10 à chaque click

	@GetMapping(value = "/getTenArticlesByClick")
	public ResponseEntity<List<Articles>> getTenArticlesByClick(@RequestParam("clickShowMore") Long clickShowMore) {
		List<Articles> listArticlesByClick = this.articlesService.getAllArticlesByClick(clickShowMore);
		return new ResponseEntity<List<Articles>>(listArticlesByClick, HttpStatus.OK);
	}

//Trouver un article par l'id d'une thematique	
	@GetMapping(value = "/thematique/{thematiqueId}")
	public ResponseEntity<List<Articles>> getAllArticlesByThematiquesId(
			@PathVariable(value = "thematiqueId") Long thematiqueId) {
		List<Articles> listArticleByThemId = this.articlesService.getArticlesByThematiquesId(thematiqueId);

		if (listArticleByThemId.size() != 0) {
			return new ResponseEntity<List<Articles>>(listArticleByThemId, HttpStatus.OK);
		} else if (listArticleByThemId.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Il n'ya pas d'article pour cette thématique");
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aucune article trouvé");
		}
	}

	// Afficher les articles par thematique id 10 par 10 a chaque cliques

	@GetMapping(value = "/thematique/{thematiqueId}/getAllArticlesByClick")
	public ResponseEntity<List<Articles>> getAllArticlesByThematiquesIdByClick(
			@PathVariable(value = "thematiqueId") Long thematiqueId, @RequestParam("clickShowMore") Long clickShowMore) {
		
		List<Articles> listArticlesByThemIdByClick = this.articlesService.getAllArticlesByThematiquesIdByClick(thematiqueId, clickShowMore);
		
		if (listArticlesByThemIdByClick.size() != 0  ) {
		
		return new ResponseEntity<List<Articles>>(listArticlesByThemIdByClick, HttpStatus.OK);
	} else if (listArticlesByThemIdByClick.size() == 0) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Il n'ya pas d'article pour cette thématique");
	} else {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aucune article trouvé");
	}
	}

	// Trouver les 10 derniers articles par l'id d'une thematique
	@GetMapping(value = "/getLastTenArticlesByThematiqueId/{thematiqueId}")
	public ResponseEntity<List<Articles>> getAllLastTenArticlesByThematiquesId(
			@PathVariable(value = "thematiqueId") Long thematiqueId) {
		List<Articles> listLastTenArticlesByThematiqueId = this.articlesService
				.getLastTenArticlesByThematiquesId(thematiqueId);
		return new ResponseEntity<List<Articles>>(listLastTenArticlesByThematiqueId, HttpStatus.OK);
	}

	// Trouver un article par l'id d'une subthematique
	@GetMapping(value = "/subthematique/{sub_thematiqueId}")
	public ResponseEntity<List<Articles>> getAllArticlesBySubThematiquesId(
			@PathVariable(value = "sub_thematiqueId") Long sub_thematiqueId) {
		List<Articles> listArticleBySubThemId = this.articlesService.getArticlesBySubThematiquesId(sub_thematiqueId);
		return new ResponseEntity<List<Articles>>(listArticleBySubThemId, HttpStatus.OK);
	}

// Trouver un artciles par nom de thematiques
	@GetMapping(value = "/thematiquesName/{thematiques}")
	public ResponseEntity<List<Articles>> getAllArticlesByThematiquesName(
			@PathVariable(value = "thematiques") String thematiques) {
		List<Articles> listArticleParThem = this.articlesService.getArticlesByThematiquesName(thematiques)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucun article trouvé avec le nom de la thematique : " + thematiques));
		return new ResponseEntity<>(listArticleParThem, HttpStatus.OK);
	}

// Trouver un artciles par nom de sous thematiques
	@GetMapping(value = "/subThematiquesName/{subThematiquesName}")
	public ResponseEntity<List<Articles>> getAllArticlesBySubThematiquesSubName(
			@PathVariable(value = "subThematiques") String subThematiques) {
		List<Articles> listArticleParSubThem = this.articlesService.getArticlesBySubThematiquesSubName(subThematiques)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Aucun article trouvé avec le nom de la sous thematique : " + subThematiques));
		return new ResponseEntity<>(listArticleParSubThem, HttpStatus.OK);
	}

// requette pour chercher un article par mot clé saisi par l'utilisateur
	@GetMapping(value = "/search/{keyword}", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<String>> search(@PathVariable("keyword") String keyword) {

		List<String> listArticles = this.articlesService.searchArticles(keyword)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"Aucun matching avec le keyword : " + keyword));
		return new ResponseEntity<List<String>>(listArticles, HttpStatus.OK);
	}

//****************************************************************************************************************************
////////////////////////////////////// Affichage par 10 par page dans l'ordre decroissants de Id////////////////////////////////////////////////////////////
//Route générique : Get Articles 10 By 10 with PageTool dans l'ordre chronologique par id decendant
	@GetMapping(value = "/page/chronological_order")
	public ResponseEntity<Page<Articles>> getArticlesPerPage(@Valid PageTool pageTool) {
		if (pageTool != null) {
			Page<Articles> listArticlesByPage = articlesService.getPageOfEntities(pageTool);
			return new ResponseEntity<Page<Articles>>(listArticlesByPage, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Données en paramètre non valides");
		}
	}

	// Route générique : Get Articles by thematique Id affichage de 10 By 10 with
	// PageTool ordre decroissant
	@GetMapping(value = "/page/thematique_desc/{thematiqueId}")
	public ResponseEntity<Page<Articles>> getArticlesByThematiquesPerPageDesc(
			@PathVariable(value = "thematiqueId") Long thematiqueId, @Valid PageTool pageTool) {
		if (pageTool != null) {
			Page<Articles> listArticlesByThematiquesByPage = articlesService
					.getPageOfEntitiesByThematiquesOrderDesc(pageTool, thematiqueId);
			return new ResponseEntity<Page<Articles>>(listArticlesByThematiquesByPage, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Données en paramètre non valides");
		}
	}

	// Route générique : Get Articles by thematique Id affichage de 10 By 10 with
	// PageTool ordre decroissant
	@GetMapping(value = "/page/sub_thematique_desc/{sub_thematiqueId}")
	public ResponseEntity<Page<Articles>> getArticlesBySubThematiquesPerPageDesc(
			@PathVariable(value = "thematiqueId") Long sub_thematiqueId, @Valid PageTool pageTool) {
		if (pageTool != null) {
			Page<Articles> listArticlesBySubThematiquesByPage = articlesService
					.getPageOfEntitiesBySubThematiquesOrderDesc(pageTool, sub_thematiqueId);
			return new ResponseEntity<Page<Articles>>(listArticlesBySubThematiquesByPage, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Données en paramètre non valides");
		}
	}

// Route générique : Get Articles 10 By 10 with PageTool dans l'ordre croissant de id
	@GetMapping(value = "/page/thematique/{thematiqueId}")
	public ResponseEntity<Page<Articles>> getArticlesByThematiquesPerPage(
			@PathVariable(value = "thematiqueId") Long thematiqueId, @Valid PageTool pageTool) {
		if (pageTool != null) {
			Page<Articles> listArticlesByThematiquesByPage = articlesService.getPageOfEntitiesByThematiques(pageTool,
					thematiqueId);
			return new ResponseEntity<Page<Articles>>(listArticlesByThematiquesByPage, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Données en paramètre non valides");
		}
	}

}
