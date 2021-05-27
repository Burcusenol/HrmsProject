package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);

}
