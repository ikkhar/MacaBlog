package fr.macademia.macablog.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.macademia.macablog.model.entities.SubThematiques;

@Repository
public interface SubThematiquesRepository extends JpaRepository<SubThematiques ,Long> {

}
