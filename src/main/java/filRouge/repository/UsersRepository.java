package filRouge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import filRouge.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

		List<Users> findBynom(String nom); 
}
