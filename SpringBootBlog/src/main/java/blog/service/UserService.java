package blog.service;

import java.util.List;


import blog.entity.User;

public interface UserService {

	public List<User> findAllUser();

	public boolean isValidUser(String username, String password);
}
