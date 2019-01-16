package filRouge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import filRouge.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
