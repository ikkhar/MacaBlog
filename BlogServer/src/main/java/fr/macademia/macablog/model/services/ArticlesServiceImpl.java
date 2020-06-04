package fr.macademia.macablog.model.services;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import fr.macademia.macablog.model.entities.Articles;
import fr.macademia.macablog.model.repositories.ArticlesRepository;
import fr.macademia.macablog.model.repositories.KeywordsRepository;
import fr.macademia.macablog.model.repositories.SubThematiquesRepository;
import fr.macademia.macablog.model.repositories.ThematiquesRepository;
import fr.macademia.macablog.tool.page.PageTool;
import org.springframework.data.domain.Sort;

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
		
		return articlesRepository.findAllByOrderByIdDesc();
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
		 Collections.reverse(listeLastTenArticles);
		return listeLastTenArticles;
		
	}

	@Override
	public List<Articles> getArticlesByThematiquesId(Long id) {
		 ArrayList<Articles> listeAllArticlesByThem=new ArrayList<Articles>();
		 listeAllArticlesByThem.addAll(this.articlesRepository.findByThematiquesId(id));
		 
	Collections.reverse(listeAllArticlesByThem);
		return listeAllArticlesByThem;
	}

//	@Override
//	public Optional<ArrayList<Articles>> getArticlesByThematiquesId(Long id) {
//		 Optional<ArrayList<Articles>> listeAllArticlesByThem=new Optional<ArrayList<Articles>>;
//		 listeAllArticlesByThem.addAll(this.articlesRepository.findByThematiquesId(id));
//		 
//	Collections.reverse(listeAllArticlesByThem);
//		return listeAllArticlesByThem;
//	}
	@Override
	public List<Articles> getArticlesBySubThematiquesId(Long id) {
		 ArrayList<Articles> listeAllArticlesBySubThem=new ArrayList<Articles>();
		 listeAllArticlesBySubThem.addAll(this.articlesRepository.findBySubThematiquesId(id));
		 
	Collections.reverse(listeAllArticlesBySubThem);
		return listeAllArticlesBySubThem;
	}
//	@Override
//	public <List<Articles>> ArrayList<Articles> getArticlesByThematiquesId(Long id) {
//		 ArrayList<Articles> listeAllArticlesByThem=new ArrayList<Articles>();
//		 listeAllArticlesByThem.addAll(this.articlesRepository.findByThematiquesId(id));
//		 
//		Collections.reverse(listeAllArticlesByThem);
//		return listeAllArticlesByThem;
//	}

//	@Override
//	public Optional<List<Articles>> getArticlesBySubThematiquesId(Long id) {
//		
//		return articlesRepository.findBySubThematiquesId(id);
//	}




	@Override
	public List<Articles> getAllChronologicArticles() {
		 ArrayList<Articles> listeAllArticles=new ArrayList<Articles>();
		 listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());
		 
		//Collections.reverse(listeAllArticles);
//		 for (int i = listChronologicalArticles.size()-1; i >= 0; i--) {
//			 listChronologicalArticles.add(listeAllArticles.get(i)) ;
//		 }
		return listeAllArticles;}



//	@Override
//	public <List<Articles>> ArrayList<Articles> getArticlesByThematiquesId(Long id) {
//		 ArrayList<Articles> listeAllArticlesByThem=new ArrayList<Articles>();
//		 listeAllArticlesByThem.addAll(this.articlesRepository.findByThematiquesId(id));
//		 
//		Collections.reverse(listeAllArticlesByThem);
//		return listeAllArticlesByThem;
//	}

//	@Override
//	public Optional<List<Articles>> getArticlesBySubThematiquesId(Long id) {
//		
//		return articlesRepository.findBySubThematiquesId(id);
//	}





//	@SuppressWarnings("unchecked")
//	@Override
//	public Page<Articles> getPageOfEntities(PageTool pageTool) {
//		 ArrayList<Articles> listeAllArticles=new ArrayList<Articles>();
//		 listeAllArticles.addAll(this.articlesRepository.findAll(pageTool.requestPage()));
//		 
//		Collections.reverse(listeAllArticles);
////		 for (int i = listChronologicalArticles.size()-1; i >= 0; i--) {
////			 listChronologicalArticles.add(listeAllArticles.get(i)) ;
////		 }
//		return (Page<Articles>) listeAllArticles;
//
//	}

	@Override
    public Page<Articles> getPageOfEntities(PageTool pageTool) {
		// TODO Auto-generated method stub
		return articlesRepository.findAllByOrderByIdDesc(pageTool.requestPage()) ;

//		 for (int i = listChronologicalArticles.size()-1; i >= 0; i--) {
//			 listChronologicalArticles.add(listeAllArticles.get(i)) ;
//		 }
	

	}





	@Override
	public Page<Articles> getPageOfEntitiesByThematiques(PageTool pageTool, Long id) {
		// TODO Auto-generated method stub
		return articlesRepository.findByThematiquesId(pageTool.requestPage(),id);
	}
	//repository.findAll(Sort.by(Sort.Direction.DESC, id));

//	private Sort orderByIdAsc() {
//	    return new Sort(Sort.Direction.ASC, "id")
//	                ;
//	


//	@Override
//	public Page<Articles> getPageOfEntitiesByThematiques(PageTool pageTool) {
//		// TODO Auto-generated method stub
//		return articlesRepository.findBySubThematiquesId(pageTool.requestPage()) ;
//	}




	






	
	
	
}


