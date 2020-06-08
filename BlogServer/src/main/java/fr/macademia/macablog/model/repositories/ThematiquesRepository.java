package fr.macademia.macablog.model.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.macademia.macablog.model.entities.Thematiques;

@Repository
public interface ThematiquesRepository extends JpaRepository<Thematiques,Long> {

	Optional<Thematiques> findById(Long id);
	List<Thematiques> findAll();
	List<Thematiques> findAllByOrderByIdAsc();
	Optional<Thematiques> findByName(String thematiqueName);
}
