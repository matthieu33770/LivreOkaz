package filRouge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import filRouge.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer>{

}
