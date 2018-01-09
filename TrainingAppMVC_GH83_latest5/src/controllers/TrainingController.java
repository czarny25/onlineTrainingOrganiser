package controllers;

import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import model.Exercise;
import model.Set;
import model.Training;
import model.User;
import service.TrainingService;

@Controller
public class TrainingController {

	private TrainingService trainingService;
	
	
	//Save copy of training for safe keeping
	private	Training safeCopy;
	 

	@Autowired
	public void setTrainingService(TrainingService trainingService) {
		this.trainingService = trainingService;
	}

	
	
	
	
	//////// this method will direct user straight to todays - completed
	
	@RequestMapping("/showTodaysTraining")
	public String showTraining(Model model, Principal principal) {

		String username = principal.getName();// refers to userName of currently
												// logged user
		User user = new User();
		user.setUserName(username);		
		
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // full name of the todays day 
        String weekDay = simpleDateformat.format(new Date());		
        System.out.println("todays is " + weekDay);

        
        
        
		Training training = new Training();
		// training.getUser().setUserName(username);
		training.setUserName(user);
		// list of exercise names for update
		List<String> exeNames = trainingService.getAllExercisesNames();
		

		if (trainingService.trainingExists(username, weekDay)) {

			System.out.println("Training exists "); // test to remove

			training = trainingService.getTodaysTraining(username, weekDay);

			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

			String json = "";
			try {
				json = ow.writeValueAsString(training);
			} catch (JsonProcessingException e1) {				
				e1.printStackTrace();
			}

			
			String names = "";
			try {
				names = ow.writeValueAsString(exeNames);
			} catch (JsonProcessingException e1) {
				e1.printStackTrace();
			}
					
			model.addAttribute("training", training);
			model.addAttribute("json", json);
			model.addAttribute("names", names);
			
			

			
			// presentation //////////////////////////
			System.out.println("// presentation //////////////////////////");
			 System.out.println(training.getTrainingName());
			
			 for(Exercise e: training.getExercises()){
				 System.out.println(" " + e.getNameOfExercise());
			
				 for(Set s: e.getSets()){
					 System.out.println(" " + s.getSetNo() + ". " + s.getReps() + ". " + s.getWeight());
				 }
			 }
			 
			 //System.out.println("to jest " + training.getTrainingName() );
			 
			 String showTodaysTraining  = "presentTraining?trainingName="+training.getTrainingName();
			 
			 System.out.println("to jest " + showTodaysTraining );
			 //presentTraining?trainingName=${training.trainingName}
			 
			///////////////////////////////////////////

			return "showTraining";
		} else {
			return "noTrainingToday";
		}
	}

	////////// end of todays training ////////////

	
	
	
	
	
	////////////   this method will present only training marked public to unregister user  ///////////////
	
	@RequestMapping("/showTrainingExamples")
	public String showPublicTraining(Model model) {

		List<Training> trainings = trainingService.showPublicTraining();
		// System.out.println(trainings.toString()); // test to remove
		model.addAttribute("trainings", trainings);
		return "showPublicTrainings";
	}

	
	
	
	
	
	////////////this method will present list of all training's for particular user  ///////////////
	
	@RequestMapping("/showUsersTrainings")
	public String showUsersTrainings(Model model, Principal principal) {

		String username = null;
		try {
			username = principal.getName();
		} catch (Exception e2) {
			System.out.println("User not logged in ");
			e2.printStackTrace();
			return "logIn";
		}		
		
		List<Training> trainings = trainingService.getUsersTrainings(username);																		

		model.addAttribute("trainings", trainings);
		return "showUsersTrainings";
	}

	
	
	
	
	
	
	
	
	
	////////////    This method will present list of all available training   /////////////////
	
	@RequestMapping("/showAllTrainings")
	public String showAllTrainings(Model model) {

		List<Training> trainings = trainingService.getTrainigs();

//		System.out.println("showAllTrainings on place" + trainings.toString()); // test																				

		model.addAttribute("trainings", trainings);
		return "showAllTrainings";
	}

	
	
	
	
	
	
	
	
	////////////this method will present single training for use  ///////////////

	@RequestMapping(value = "/presentTraining", method = RequestMethod.GET)
	public String presentTraining(Model model, String trainingName, Principal principal) {

		
		String username = null;
		try {
			username = principal.getName();
		} catch (Exception e2) {
			//System.out.println("User not logged in ");
			e2.printStackTrace();
			return "logIn";
		}
		
		//System.out.println("Loged as " + username + " and training name is: " + trainingName);// test		
		
		User user = new User();
		user.setUserName(username);
		
		Training training = new Training();
		// extraction from database
		training = trainingService.presentTraining(username, trainingName);
		training.setUserName(user);
		
		// list of exercise names for update
		List<String> exeNames = trainingService.getAllExercisesNames();
		//System.out.println("exerciseNames " + exeNames.toString());// test
		
		
		// presentation to view TEST TO REMOVE
		System.out.println();
		System.out.println("Reading ");
		System.out.println("Name of training " + training.getTrainingName());
		System.out.println("Day of the week " + training.getWeekDay());
		System.out.println("Name of user " + training.getUserName());
		
		for (Exercise e : training.getExercises()) {
			System.out.println(" " + e.getNameOfExercise());
			for (Set s : e.getSets()) {
				System.out.println("  " + s.getSetNo() + ". " + s.getReps() + ". " + s.getWeight());
			}
		}
		/// end of presentation
		
		
		
		//Save copy is instantiated
		safeCopy = training;
		
		// presentation to view
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = ow.writeValueAsString(training);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}

		String names = "";
		try {
			names = ow.writeValueAsString(exeNames);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
				
		model.addAttribute("training", training);
		model.addAttribute("json", json);
		model.addAttribute("names", names);
		
		//System.out.println(" Presented ");
		
		return "showTraining";
	}

	
	
	
	
	
	
	
	
	////////////this method will create single training for use  ///////////////

	@RequestMapping("/createTraining")
	public String createTraining(Model model) {

		// Model model
		//System.out.println("Create training on place ");

		
		// list of exercise names for update
		List<String> exeNames = trainingService.getAllExercisesNames();
		//System.out.println("exerciseNames " + exeNames.toString());// test
		
		// presentation to view
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				

		String names = "";
		try {
			names = ow.writeValueAsString(exeNames);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		
		model.addAttribute("names", names);		
		return "createTraining";
	}

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreate(@RequestBody Training training, Principal principal, HttpServletResponse response ) {

		// System.out.println(" I m in " + testSet.getWeight());
		// System.out.println(" to jest " + training.toString());

		String username = principal.getName();
		User user = new User();
		user.setUserName(username);
		training.setUserName(user);
		
		
		
		
		// presentation to view TEST TO REMOVE
		System.out.println();
		System.out.println("Saving ");
		System.out.println("Name of training " + training.getTrainingName());
		System.out.println("Day of the week " + training.getWeekDay());
		System.out.println("Name of user " + training.getUserName());
		
		for (Exercise e : training.getExercises()) {
			System.out.println(e.getNameOfExercise());		
			for (Set s : e.getSets()) {
				System.out.println("  " + s.getSetNo() + ". " + s.getReps() + ". " + s.getWeight());
			}
		}
		// saving training to database
		trainingService.createTraining(training);

		
		
		try {
			//response.setHeader("Location", "http://localhost:8080/trainings/homePage");
			response.sendRedirect("http://localhost:8080/trainings/showUsersTrainings");
			System.out.println("Redirect is working");
		} catch (IOException e1) {
			System.out.println("Redirect not working");
			e1.printStackTrace();
		}
		
		//return "redirect:/showUsersTrainings";
		
		System.out.println("Training created controller ");
		
		return "showUsersTrainings";
	}

	
	
	
	
	
	
	////////////this method will delete single training  ///////////////
	
	@RequestMapping(value = "/deleteTraining", method = RequestMethod.GET)
	public String deleteTraining(String trainingName, String weekDay, Principal principal) {
		
		String username = principal.getName();// refers to userName of currently logged user
		
		System.out.println("Loged as " + username + " and training name is: " + trainingName);// test	
		
		trainingService.deleteTraining(username, trainingName ,weekDay);
		
		return "trainingDeleted";
	}
	
	
	
	
	////////////this method will update single training  ///////////////
	
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	public String doUpdate(@RequestBody Training training, Principal principal, HttpServletRequest request) {

		// System.out.println(" I m in " + testSet.getWeight());
		// System.out.println(" to jest " + training.toString());

		
		
		String username;
		try {
			username = principal.getName();
		} catch (Exception e1) {
			e1.printStackTrace();
			return "logIn";
		}

		
		User user = new User();
		user.setUserName(username);
		training.setUserName(user);
		
		System.out.println();
		System.out.println("safeCopy name is " + safeCopy.getTrainingName());
		
		// presentation to view TEST TO REMOVE
		System.out.println();
		System.out.println("Updating ");
		System.out.println("Name of training " + training.getTrainingName());
		System.out.println("Day of the week " + training.getWeekDay());
		System.out.println("Name of user " + training.getUserName());
		
		for (Exercise e : training.getExercises()) {
			System.out.println(e.getNameOfExercise());		
			for (Set s : e.getSets()) {
				System.out.println("  " + s.getSetNo() + ". " + s.getReps() + ". " + s.getWeight());
			}
		}
		
		// saving training to database
		trainingService.updateTraining(training, safeCopy);

		System.out.println("Training updated controller ");
		
		

//		try {
//			response.sendRedirect("http://localhost:8080/trainings/homePage");
//			//response.sendRedirect("/showUsersTrainings");
//			System.out.println("Redirect is working");
//		} catch (IOException e1) {
//			System.out.println("Redirect not working");
//			e1.printStackTrace();
//		}
		
		String redirectUrl = request.getScheme() + "://www.yahoo.com";
	    return "redirect:" + redirectUrl;
		
//		return "showUsersTrainings";
	}
	
	
////////////this method will add single exercise name training  ///////////////	
	
	@RequestMapping(value = "/getNewExercise", method = RequestMethod.POST)
	public String addExercisesName(@RequestBody String exerciseName){
		
		System.out.println("Passed exe name is " + exerciseName);
		
//		exerciseName = exerciseName.substring(3, exerciseName.length());
//		exerciseName = exerciseName.substring(0, exerciseName.length() - 4);
		
		String regx = "%2=";
	    char[] ca = regx.toCharArray();
	    for (char c : ca) {
	    	exerciseName = exerciseName.replace(""+c, "");
	    }
		
		
		String regx1 = "+";
	    char[] ca1 = regx1.toCharArray();
	    for (char c : ca1) {
	    	exerciseName = exerciseName.replace(""+c, " ");
	    }
		
	    exerciseName = exerciseName.substring(0, 1).toUpperCase() + exerciseName.substring(1);
	   
	    
	    
		
		System.out.println("Passed exe name is " + exerciseName);
		
		trainingService.addExercisesName(exerciseName);
		
		return "showTraining";
		
	}
	
	
	
}

// end of Controller


