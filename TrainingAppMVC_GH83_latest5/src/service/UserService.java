package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import model.User;
import model.UserDao;


@Service("userService")
public class UserService {
	
	
	private UserDao userModel;

	@Autowired
	public void setUserModel(UserDao userModel) {
		this.userModel = userModel;
	}
	
	
	public void  create(User user) {		
		userModel.createUser(user);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		List<User> users = userModel.getAllUsers();
		return users;
	}

}



