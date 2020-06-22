package fr.macademia.macablog.model.services;

import java.util.*;

import org.springframework.data.domain.Page;

import fr.macademia.macablog.model.entities.Articles;
import fr.macademia.macablog.model.entities.Auteur;
import fr.macademia.macablog.tool.page.PageTool;



public interface ArticlesService {

	List <Articles> getAllChronologicArticles();
	
	
	
	Optional<List<Articles>>getArticlesByAuteurId(Long id);
	Optional<Articles> getArticlesById(long id);
	 ArrayList<Articles> getLastTenArticles();
	Optional<Articles> getArticlesByTitle(String title);
	
	List<Articles> getArticlesByThematiquesId(Long id);

	List<Articles> getArticlesBySubThematiquesId(Long id);
	List<Articles> getLastTenArticlesByThematiquesId(Long id);
	Optional<List<Articles>>getArticlesByThematiquesName(String thematiques);
	
	Optional<List<Articles>> getArticlesBySubThematiquesSubName(String subThematiques);
	List <Articles> getAllArticles();
	List <Articles> getAllArticlesByClick(Long nbreClick);
	Long getSizeAllArticlesList();
	List <Articles> getAllArticlesByThematiquesIdByClick(Long id,Long nbreClick);
List <Articles> removeTenArticlesByClick(int clickShowLess);
	
	List <Articles> removeAllArticlesByThematiquesIdByClick(Long id,Long nbreClick);
	
	Optional<List<String>> searchArticles(String keyword);
	
	
	Page<Articles> getPageOfEntities(PageTool pageTool);
	// afiche dans l'ordre croissant
	Page<Articles> getPageOfEntitiesByThematiques(PageTool pageTool, Long id);
	



// affiche dans l'ordre decroissant
	Page<Articles> getPageOfEntitiesByThematiquesOrderDesc(PageTool pageTool, Long id);
	Page<Articles> getPageOfEntitiesBySubThematiquesOrderDesc(PageTool pageTool, Long id);



	
	
}
