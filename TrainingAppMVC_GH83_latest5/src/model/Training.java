package model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import validations.ValidEmail;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Training {
	
	@Size(min=4, max=30, message="trainingName must be between 4 and 30 characters")
	@NotNull
	private String trainingName;
	
	@NotNull	
	private String weekDay;
	
	private User user;
	
	private String userName;
	
	List<Exercise> exercises;

	
	
	public Training() {
//		this.user = new User();
	}


	public Training(String trainingName, String weekDay, User user) {
		this.trainingName = trainingName;
		this.weekDay = weekDay;
		this.user = user;
		
	}	
		
	
	public Training(String trainingName, String weekDay, User user, List<Exercise> exercises) {
		super();
		this.trainingName = trainingName;
		this.weekDay = weekDay;
		this.user = user;
		this.exercises = exercises;
	}

	
	

	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}


	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
//	
	
	public String getUserName() {	
		return userName;
	}


	public void setUserName(User user) {
		String userName = user.getUserName();
		//System.out.println("User is set " + userName);
		this.userName = userName;
	}
	
	
	
	
	
	
	
	
	
	public List<Exercise> getExercises() {
		return exercises;
	}
	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}

	
	
	
//	@Override
//	public String toString() {
//		return "[trainingName=" + trainingName + ", weekDay=" + weekDay + ", user="
//				+ user.getUserName() + ", excercises to=" + exercises + "]";
//	}

	@Override
	public String toString() {
		
		return String.format("{trainingName:%s,weekDay:%s,exercises:%s}", trainingName, weekDay, exercises);
		
//		return "[trainingName=" + trainingName + ", weekDay=" + weekDay + ", user="
//				+ user.getUserName() + ", excercises to=" + exercises + "]";
	}
	
	
	
	
	
}
