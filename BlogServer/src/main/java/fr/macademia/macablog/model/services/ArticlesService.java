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
	
	Long getSizeAllArticlesList();
	
    List <Articles> removeTenArticlesByClick(int clickShowLess);
	
	Optional<List<String>> searchArticles(String keyword);
	

	List<Articles> getAllArticlesByThematiquesIdByClick(Long id, int indexFrom);


	List<Articles> getAllArticlesByClick( int indexFrom);



	List<Articles> removeAllArticlesByThematiquesIdByClick(Long id, Long nbreClick);



	



	
	
}
