package fr.macademia.macablog.model.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import fr.macademia.macablog.model.entities.Articles;



@Repository
public interface ArticlesRepository extends JpaRepository <Articles, Long>{
	Optional<Articles> findById(Long id);
	List<Articles> findAll();
	
	//Methodes pour trouver la liste des articles par thematiques ou sous thematiques
	Optional<List<Articles>> findByThematiquesName(String thematiques);

	Optional<List<Articles>> findBySubThematiquesSubName(String subThematiques);

//	ArrayList<Articles> findByKeywords(Long id);
//	Méthode pour l'auto-complétion
	@Query(value="select name from articles where name like %:keyword%", nativeQuery = true)
	Optional<List<String>> search(@Param("keyword")String keyword);
	
	//Methode pour trouver un article par son titre
	Optional<Articles> findByTitle(String title);
	
}
