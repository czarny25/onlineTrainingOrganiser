package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import model.Training;
import model.TrainingDao;
import model.User;


@Service("trainingService")
public class TrainingService {
	
private TrainingDao trainingModel;
	
	@Autowired
	public void setTrainingDao(TrainingDao trainingModel) {
		this.trainingModel = trainingModel;
	}

	
	public List<Training> getTrainigs(){		
		return trainingModel.getTrainings();		
	}	
	
	public Training getTodaysTraining(String userName, String weekDay){	
		return trainingModel.getTraining(userName, weekDay);		
	}

	public List<Training> showPublicTraining() {
		return trainingModel.getPublicTraining();
		
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public void createTraining(Training training) {		
		trainingModel.createTraining(training);		
	}


	public boolean trainingExists(String username, String weekDay) {
		return trainingModel.trainingExists(username, weekDay);		
	}

	

	public List<Training> getUsersTrainings(String userName) {
		return trainingModel.getUsersTrainings(userName);
	}


	public Training presentTraining(String username, String trainingName) {
		return trainingModel.presentTraining(username, trainingName);		
	}


	public void deleteTraining(String username, String trainingName, String weekDay) {
		trainingModel.deleteTraining(username, trainingName ,weekDay);	
		
	}


	public void updateTraining(Training training, Training safeCopy) {
		trainingModel.updateTraining(training, safeCopy);	
		
	}


	public List<String> getAllExercisesNames() {
		return trainingModel.getAllExercisesNames();	
	}


	public void addExercisesName(String exerciseName) {
		trainingModel.addExercisesName(exerciseName);
		
	}

}
