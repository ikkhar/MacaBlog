package fr.macademia.macablog.model.services;

import java.util.*;

import fr.macademia.macablog.model.entities.Articles;


public interface ArticlesService {

	Optional<Articles> getArticlesById(long id);
	 ArrayList<Articles> getLastTenArticles();
	Optional<Articles> getArticlesByTitle(String title);
	
	Optional<List<Articles>> getArticlesByThematiquesId(Long id);

	Optional<List<Articles>> getArticlesBySubThematiquesId(Long id);

	Optional<List<Articles>>getArticlesByThematiquesName(String thematiques);
	Optional<List<Articles>> getArticlesBySubThematiquesSubName(String subThematiques);
	List <Articles> getAllArticles();
	
	Optional<List<String>> searchArticles(String keyword);
	
}
