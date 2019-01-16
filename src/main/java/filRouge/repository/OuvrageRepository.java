package filRouge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import filRouge.model.Ouvrage;

@Repository
public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer>{

}
