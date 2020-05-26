package fr.macademia.macablog.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.macademia.macablog.model.entities.Articles;
import fr.macademia.macablog.model.repositories.ArticlesRepository;
import fr.macademia.macablog.model.repositories.KeywordsRepository;
import fr.macademia.macablog.model.repositories.SubThematiquesRepository;
import fr.macademia.macablog.model.repositories.ThematiquesRepository;
import org.springframework.stereotype.Service;

@Service(value = "articlesService")
public class ArticlesServiceImpl implements ArticlesService {
	
	@Autowired
	private ArticlesRepository articlesRepository;
	@Autowired
	private ArticlesService articlesService;
	
	@Autowired
	private ThematiquesRepository thematiqueRepository;
	
	@Autowired
	private SubThematiquesRepository subThematiqueRepository;
	
	@Autowired
	private KeywordsRepository keywordRepository;

	@Override
	public Optional<Articles> getArticlesById(long id) {
		
		return articlesRepository.findById(id);
	}

	@Override
	public List<Articles> getAllArticles() {
		
		return articlesRepository.findAll();
	}

	@Override
	public Optional<List<String>> searchArticles(String keyword) {
		// TODO Auto-generated method stub
		return this.articlesRepository.search(keyword);
	}

	@Override
	public Optional<Articles> getArticlesByTitle(String title) {
		
		return articlesRepository.findByTitle(title);
	}

	@Override
	public Optional<List<Articles>> getArticlesByThematiquesName(String thematiques) {
		
		return articlesRepository.findByThematiquesName(thematiques);
	}

	@Override
	public Optional<List<Articles>> getArticlesBySubThematiquesSubName(String subThematiques) {
		
		return articlesRepository.findBySubThematiquesSubName(subThematiques);
	}

	@Override
	public  ArrayList<Articles> getLastTenArticles() {
		 ArrayList<Articles> listeAllArticles=new ArrayList<Articles>();
		 listeAllArticles.addAll(this.articlesRepository.findAll());
		 ArrayList<Articles> listeLastTenArticles=new ArrayList<Articles>();
		 for (int i = listeAllArticles.size()-10; i < listeAllArticles.size(); i++) {
			 listeLastTenArticles.add(listeAllArticles.get(i)) ;
		 }
		return listeLastTenArticles;
		
	}

	@Override
	public Optional<List<Articles>> getArticlesByThematiquesId(Long id) {
		
		return articlesRepository.findByThematiquesId(id);
	}

	@Override
	public Optional<List<Articles>> getArticlesBySubThematiquesId(Long id) {
		
		return articlesRepository.findBySubThematiquesId(id);
	}
	

	
	
	
}


