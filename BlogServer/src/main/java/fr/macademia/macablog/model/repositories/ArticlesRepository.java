package fr.macademia.macablog.model.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import fr.macademia.macablog.model.entities.Articles;



@Repository
public interface ArticlesRepository extends JpaRepository <Articles, Long>{
	Optional<Articles> findById(Long id);
	List<Articles> findAll();
	List<Articles> findAllByOrderByIdAsc();
	List<Articles> findAllByOrderByIdDesc();//trouvé tout les articles dans l'ordre decroissant
//	List<Articles> findTop10ByOrderByLevelDesc();
	
	
	
	//Methodes pour trouver la liste des articles par ID  thematiques ou sous thematiques
		List<Articles> findByThematiquesId(Long id);

		List<Articles> findBySubThematiquesId(Long id);
	
	
	
	//Methodes pour trouver la liste des articles par thematiques ou sous thematiques
	Optional<List<Articles>> findByThematiquesName(String thematiques);

	Optional<List<Articles>> findBySubThematiquesSubName(String subThematiques);

//	ArrayList<Articles> findByKeywords(Long id);
//	Méthode pour l'auto-complétion
	@Query(value="select name from articles where name like %:keyword%", nativeQuery = true)
	Optional<List<String>> search(@Param("keyword")String keyword);
	
	//Methode pour trouver un article par son titre
	Optional<Articles> findByTitle(String title);
//	Page<Articles> findBySubThematiquesId(Pageable requestPage);
	Page<Articles> findAllByOrderByIdDesc(Pageable requestPage);
	Page<Articles>findByThematiquesId(Pageable requestPage,Long id);
	Page<Articles>findBySubThematiquesId(Pageable requestPage,Long id);
	
}
