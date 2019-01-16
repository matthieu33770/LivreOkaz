package filRouge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import filRouge.model.Auteur;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer>{

}
