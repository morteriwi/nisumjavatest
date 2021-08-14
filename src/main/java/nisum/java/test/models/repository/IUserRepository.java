package nisum.java.test.models.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import nisum.java.test.models.entity.User;

public interface IUserRepository extends CrudRepository<User, UUID> {
	 Optional<User> findByEmail(String email);

}
