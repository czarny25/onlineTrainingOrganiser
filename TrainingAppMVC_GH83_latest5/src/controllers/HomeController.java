package controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	private static Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String showWelcomePage(Model model){		
		logger.info("Showing home page");		
		return "welcomePage";		
	}
	
	@RequestMapping("/guestPage")
	public String showOptions(Model model){				
		return "guestPage";
	}
	
	@RequestMapping("/homePage")
	public String showHomePage(Model model){				
		return "homePage";
	}
	
	@RequestMapping("/about")
	public String showAboutPage(Model model){				
		return "about";
	}
	
	@RequestMapping("/contact")
	public String showContactPage(Model model){				
		return "contact";
	}
	
//	@RequestMapping("/services")
//	public String showServicesPage(Model model){
//				
//		return "services";
//	}
	
	
	
}
