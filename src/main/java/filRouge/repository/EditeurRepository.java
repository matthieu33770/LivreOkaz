package filRouge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import filRouge.model.Editeur;

@Repository
public interface EditeurRepository extends JpaRepository<Editeur, Integer>{

}
