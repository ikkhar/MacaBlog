package fr.macademia.macablog.model.services;

import java.util.*;

import org.springframework.data.domain.Page;

import fr.macademia.macablog.model.entities.Articles;
import fr.macademia.macablog.tool.page.PageTool;



public interface ArticlesService {

	List <Articles> getAllChronologicArticles();
	
	
	
	
	Optional<Articles> getArticlesById(long id);
	 ArrayList<Articles> getLastTenArticles();
	Optional<Articles> getArticlesByTitle(String title);
	
	List<Articles> getArticlesByThematiquesId(Long id);

	List<Articles> getArticlesBySubThematiquesId(Long id);

	Optional<List<Articles>>getArticlesByThematiquesName(String thematiques);
	Optional<List<Articles>> getArticlesBySubThematiquesSubName(String subThematiques);
	List <Articles> getAllArticles();
	
	Optional<List<String>> searchArticles(String keyword);
	
	
	Page<Articles> getPageOfEntities(PageTool pageTool);
	Page<Articles> getPageOfEntitiesByThematiques(PageTool pageTool, Long id);
}
