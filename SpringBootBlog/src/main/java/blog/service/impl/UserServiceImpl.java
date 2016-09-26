package blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.entity.User;
import blog.repository.UserRepository;
import blog.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUser() {
		return null;
	}

	@Override
	public boolean isValidUser(String username, String password) {
		User user = userRepository.findUserByName(username);
		if (password.equals(user.getPassword()))
			return true;
		else
			return false;

	}

}
