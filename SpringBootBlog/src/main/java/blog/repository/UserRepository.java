package blog.repository;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import blog.entity.User;

@Component
public interface UserRepository extends Repository<User, Long> {

	public User findUserByName(String username);
}
