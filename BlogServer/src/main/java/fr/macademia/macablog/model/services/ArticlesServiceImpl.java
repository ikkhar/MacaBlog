package fr.macademia.macablog.model.services;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import fr.macademia.macablog.model.entities.Articles;
import fr.macademia.macablog.model.entities.Auteur;
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
	public ArrayList<Articles> getLastTenArticles() {
		ArrayList<Articles> listeAllArticles = new ArrayList<Articles>();
		listeAllArticles.addAll(this.articlesRepository.findAll());
		ArrayList<Articles> listeLastTenArticles = new ArrayList<Articles>();
		for (int i = listeAllArticles.size() - 10; i < listeAllArticles.size(); i++) {
			listeLastTenArticles.add(listeAllArticles.get(i));

		}
		Collections.reverse(listeLastTenArticles);
		return listeLastTenArticles;

	}

	@Override
	public List<Articles> getArticlesByThematiquesId(Long id) {
		ArrayList<Articles> listeAllArticlesByThem = new ArrayList<Articles>();
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
		ArrayList<Articles> listeAllArticlesBySubThem = new ArrayList<Articles>();
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
		ArrayList<Articles> listeAllArticles = new ArrayList<Articles>();
		listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());

		// Collections.reverse(listeAllArticles);
//		 for (int i = listChronologicalArticles.size()-1; i >= 0; i--) {
//			 listChronologicalArticles.add(listeAllArticles.get(i)) ;
//		 }
		return listeAllArticles;
	}

	// Affiche la liste de tout les articles dans l'ordre decroissant par id
	// d'articles

	@Override
	public Optional<List<Articles>> getArticlesByAuteurId(Long id) {
		// TODO Auto-generated method stub
		return articlesRepository.findByAuteurListId(id);
	}

	@Override
	public List<Articles> getLastTenArticlesByThematiquesId(Long id) {
		// TODO Auto-generated method stub
		return articlesRepository.findFirst10ByThematiquesIdOrderByIdDesc(id);
	}

// Methode pour affciher 10 articles à chaque cliques ShowMore :
//	@Override
//	public List<Articles> getAllArticlesByClick(Long ClickShowMore) {
//		ArrayList<Articles> listeAllArticles = new ArrayList<Articles>();
//		listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());
//		ArrayList<Articles> listTenArticlesByClick = new ArrayList<Articles>();
//		// int nbreClick=0;
//		for (int i = 0; i < 10 + 10 * ClickShowMore; i++) {
//			listTenArticlesByClick.add(listeAllArticles.get(i));
//		}
//		return listTenArticlesByClick;
//	}
	// affichage de la liste de tout articles Id par chargement de sublist de 10 articles 
	// --> coté front dans promise
		@Override
		public List<Articles> getAllArticlesByClick( int indexFrom) {
			ArrayList<Articles> listeAllArticles = new ArrayList<Articles>();
			listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());
			if (listeAllArticles.size()- indexFrom <= 0) {
				return new ArrayList<Articles>();
			} else if (listeAllArticles.size() - indexFrom >= 10) {
				int indexTo = indexFrom + 10;
				return listeAllArticles.subList(indexFrom, indexTo);
			} else {
				int indexTo = indexFrom + (listeAllArticles.size() % 10);
				return listeAllArticles.subList(indexFrom, indexTo);
			}


			
		}

	// affichage de la liste des articlespar thematique Id par chargement de sublist de 10 articles
	@Override
	public List<Articles> getAllArticlesByThematiquesIdByClick(Long id, int indexFrom) {
		ArrayList<Articles> listeAllArticlesByThematiquesId = new ArrayList<Articles>();
		listeAllArticlesByThematiquesId.addAll(this.articlesRepository.findByThematiquesIdOrderByIdDesc(id));
		if (listeAllArticlesByThematiquesId.size()- indexFrom <= 0) {
			return new ArrayList<Articles>();
		} else if (listeAllArticlesByThematiquesId.size() - indexFrom >= 10) {
			int indexTo = indexFrom + 10;
			return listeAllArticlesByThematiquesId.subList(indexFrom, indexTo);
		} else {
			int indexTo = indexFrom + (listeAllArticlesByThematiquesId.size() % 10);
			return listeAllArticlesByThematiquesId.subList(indexFrom, indexTo);
		}


		
	}

	
	

	// Methode pour enlver de l'affichage 10 articles à chaque cliques ShowLess :

//	@Override
//	public List<Articles> removeTenArticlesByClick(int clickShowLess) {
//		ArrayList<Articles> listeAllArticles = new ArrayList<Articles>();
//		listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());
//		ArrayList<Articles> listTenArticlesByClick = new ArrayList<Articles>();
//		for (int i = listeAllArticles.size() - 10 * clickShowLess; i < listeAllArticles.size(); i++) {
//			Iterator<Articles> itr = listeAllArticles.iterator();
//			while (itr.hasNext()) {
//
//				if (clickShowLess != 0) {
//					itr.remove();
//					System.out.println(">>> liste articles apres suppresion de 10: " + listeAllArticles);
//				}else {listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());}
//			} 
//		}return listeAllArticles;

	// int nbreClick=0;+10*nbreClick-10
	// (int i = 0; i < 10*clickShowLess+10; i++)
	// listeAllArticles.size()-10; i < listeAllArticles.size(); i++)
	// for(int i = (int) (listeAllArticles.size()-(10*clickShowLess)); i <
	// listeAllArticles.size(); i--)
	// for (int i =listeAllArticles.size()-10*clickShowLess; i <
	// listeAllArticles.size(); i++)
//		for (int i = listeAllArticles.size() - 10 * clickShowLess; i < listeAllArticles.size(); i++) {
//			if (clickShowLess == 0) {
//				listTenArticlesByClick.addAll(this.articlesRepository.findAllByOrderByIdDesc());
//			}
//
//			else {
//				listeAllArticles.remove(i);
//
//				System.out.println(">>> liste articles apres suppresion de 10: " + listeAllArticles);
//			}
//		}
//		return listeAllArticles;
	// listTenArticlesByClick.addAll(listeAllArticles);}

	// }
	@Override
	public List<Articles> removeTenArticlesByClick(int clickShowLess) {
		ArrayList<Articles> listeAllArticles = new ArrayList<Articles>();
		listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());
		// ArrayList<Articles> listTenArticlesByClick = new ArrayList<Articles>();
		for (int i = listeAllArticles.size() - 10 * clickShowLess; i < listeAllArticles.size(); i++) {
			Iterator<Articles> itr = listeAllArticles.iterator();

			while (itr.hasNext()) {
				Articles listeAllArticle = itr.next();
				if (clickShowLess != 0) {
					itr.remove();
					System.out.println(">>> liste articles apres suppresion de 10: " + listeAllArticles);
				}
//				else {
//					listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());
//				}
			}

		}
		Set<Articles> mySet = new HashSet<Articles>(listeAllArticles);
		List<Articles> listTenArticlesByClick = new ArrayList<Articles>(mySet);
		return listTenArticlesByClick;
	}

	@Override
	public List<Articles> removeAllArticlesByThematiquesIdByClick(Long id, Long nbreClick) {
		ArrayList<Articles> listeAllArticlesByThematiquesId = new ArrayList<Articles>();
		listeAllArticlesByThematiquesId.addAll(this.articlesRepository.findByThematiquesIdOrderByIdDesc(id));
		ArrayList<Articles> listeAllArticlesByThematiquesIdByClick = new ArrayList<Articles>();
		// int nbreClick=0;
		for (int i = 0; i < 10 + 10 * nbreClick; i++) {
			listeAllArticlesByThematiquesIdByClick.remove(listeAllArticlesByThematiquesId.get(i));
		}
		return listeAllArticlesByThematiquesIdByClick;
	}

	@Override
	public Long getSizeAllArticlesList() {
		ArrayList<Articles> listeAllArticles = new ArrayList<Articles>();
		listeAllArticles.addAll(this.articlesRepository.findAllByOrderByIdDesc());
		Long sizeListAllArticlesBackend = (long) listeAllArticles.size();
		return sizeListAllArticlesBackend;
	}

	
	
	
}
