package fr.macademia.macablog.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import fr.macademia.macablog.model.entities.Auteur;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long>{
	Optional<Auteur> findById(Long id);
}
