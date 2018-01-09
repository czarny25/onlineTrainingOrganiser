package controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Training;
import model.User;
import service.UserService;

@Controller
public class LoginController {
	
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	
	
	//////////// login stuff ///////////////////////////
	
	
	@RequestMapping(value="/logIn")
	public String logIn(){
		return "logIn";
	}
	
	
	@RequestMapping(value="/accessDenied")
	public String accessDenied(){		
		return "accessDenied";
	}
	
	@RequestMapping(value="/logOut")
	public String logOut(){		
		return "logIn";
	}
	
	////////////////////////////////////////////////////
	
	
	
	
	
	@RequestMapping("/adminPage")
	public String showAdminPage(Model model){		
		
		//throw new AccessDeniedException("Wrong");
		
		try {
			return "adminPage";
		} catch (AccessDeniedException e) {
			return "accessDenied";
		}
	}
	
	
////////////  account stuff ///////////////////////////

	
	@RequestMapping(value="/createNewAccount")
	public String createAccount(Model model){
		
		model.addAttribute("user", new User());		
		return "createNewAccount";
	}
	
	@RequestMapping(value="/doCreateAccount", method=RequestMethod.POST)
	public String accountCreated(@Valid User user, BindingResult res){
		
		if(res.hasErrors()){
			return "createNewAccount";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);			
						
		try {
			userService.create(user);
		} catch (DuplicateKeyException e) {
			res.rejectValue("userName", "DuplicateKey.user.userName", "this user already exists");
			return "createNewAccount";
		}
			//System.out.println(user.toString());			
			return "accountCreated";
	}
	
	
///////////////////////////////////////////////////////////////////////	
	
	
	
	
	
	@RequestMapping(value="/createUser")
	public String createUser(Model model){
		
		model.addAttribute("user", new User());		
		return "createUser";
	}
	
	
	
	@RequestMapping(value="/doCreateUser", method=RequestMethod.POST)
	public String userCreated(@Valid User user, BindingResult res){
		
		if(res.hasErrors()){
			return "createNewAccount";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);			
						
		try {
			userService.create(user);
		} catch (DuplicateKeyException e) {
			res.rejectValue("userName", "DuplicateKey.user.userName", "this user already exists");
			return "createNewAccount";
		}
			//System.out.println(user.toString());			
			return "accountCreated";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/showUsers")
	public String showUsersPage(Model model){
		
		try {
			List<User> users =  userService.getAllUsers();
			//System.out.println(users.toString()); // test to remove	
			
			model.addAttribute("users", users);
			
		} catch (AccessDeniedException e) {
			System.out.println("Exception: " + e.getClass());
			return "accessDenied";
		}
		
		return "showUsers";
	}
	
	
	
}
	
	
	
	
	
