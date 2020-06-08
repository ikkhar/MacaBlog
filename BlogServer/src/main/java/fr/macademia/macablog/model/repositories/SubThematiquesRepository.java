package fr.macademia.macablog.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.macademia.macablog.model.entities.SubThematiques;
import fr.macademia.macablog.model.entities.Thematiques;

@Repository
public interface SubThematiquesRepository extends JpaRepository<SubThematiques ,Long> {
	Optional<SubThematiques> findById(Long id);
	List<SubThematiques> findAll();
	List<SubThematiques> findAllByOrderByIdAsc();
	Optional<SubThematiques> findBySubName(String subThematiqueName);
}
