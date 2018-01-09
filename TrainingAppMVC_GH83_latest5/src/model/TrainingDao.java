package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import controllers.TrainingRowMapper;

@Component("trainingDao")
public class TrainingDao {

	private NamedParameterJdbcTemplate database1;
	private JdbcTemplate database2;

	
	
	
	public TrainingDao() {
		//System.out.println("Dao loaded");
	}

	
	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.database1 = new NamedParameterJdbcTemplate(dataSource);
		this.database2 = new JdbcTemplate(dataSource);
	}

	
	
	
	
	
	
	
	// this method will return one training from database for today day
	public Training getTraining(String userName, String weekDay) {

		// get training name
		MapSqlParameterSource parameter1 = new MapSqlParameterSource();
		parameter1.addValue("userName", userName);
		parameter1.addValue("weekDay", weekDay);

		Training training = database1.queryForObject(
				"select * from training, users where training.userName=:userName"
						+ " and users.userName=:userName and training.weekDay = :weekDay and users.enabled=true",
				parameter1, new TrainingRowMapper());

		String trainingName = training.getTrainingName();
		parameter1.addValue("trainingName", trainingName);

		System.out.println("training name is " + trainingName); // test

		// get all exercises from that training
		List<Exercise> exercises = database1.query(
				"select * from" + " trainingSchedule where trainingName=:trainingName", parameter1,
				new RowMapper<Exercise>() {

					public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {

						Exercise exercise = new Exercise();
						exercise.setNameOfExercise(rs.getString("exerciseName"));
						exercise.setGroupId(rs.getInt("groupId"));
						int groupId = exercise.getGroupId();

						MapSqlParameterSource parameter = new MapSqlParameterSource();
						parameter.addValue("groupId", groupId);
						System.out.println("Group id is: " + groupId);
						// get all sets from each exercise
						List<Set> sets = database1.query(
								"select  setNo, repsNo, weight from setPlan where groupId=:groupId", parameter,
								new RowMapper<Set>() {

									public Set mapRow(ResultSet rs, int rowNum) throws SQLException {
										Set set = new Set();
										set.setSetNo(rs.getInt("setNo"));
										set.setReps(rs.getInt("repsNo"));
										set.setWeight(rs.getDouble("weight"));
										return set;
									}
								});
						exercise.setSets(sets);
						return exercise;
					}
				});
		training.setExercises(exercises);
		return training;
	}

	
	
	
	
	
	
	
	
	
	
	
	// this method will present full training to the user
	public Training presentTraining(String username, String trainingName) {

		System.out.println("requested trainig is " + trainingName);

		// Training training = new Training();

		MapSqlParameterSource parameter1 = new MapSqlParameterSource();
		parameter1.addValue("trainingName", trainingName);
		parameter1.addValue("userName", username);

		Training training = database1.queryForObject(
				"select * from training, users where training.userName=:userName"
						+ " and users.userName=:userName and training.trainingName = :trainingName and users.enabled=true",
				parameter1, new TrainingRowMapper());

		// get all exercises from that training
		List<Exercise> exercises = database1.query(
				"select * from" + " trainingSchedule where trainingName=:trainingName", parameter1,
				new RowMapper<Exercise>() {

					public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
						Exercise exercise = new Exercise();
						exercise.setNameOfExercise(rs.getString("exerciseName"));
						exercise.setGroupId(rs.getInt("groupId"));
						int groupId = exercise.getGroupId();

						MapSqlParameterSource parameter = new MapSqlParameterSource();
						parameter.addValue("groupId", groupId);
						System.out.println("Group id is: " + groupId);
						// get all sets from each exercise
						List<Set> sets = database1.query(
								"select setId, setNo, repsNo, weight from setPlan where groupId=:groupId", parameter,
								new RowMapper<Set>() {

									public Set mapRow(ResultSet rs, int rowNum) throws SQLException {

										System.out.println("setId is " + rs.getInt("setId"));

										Set set = new Set();
										set.setSetNo(rs.getInt("setNo"));
										set.setReps(rs.getInt("repsNo"));
										set.setWeight(rs.getDouble("weight"));
										return set;
									}
								});
						exercise.setSets(sets);
						return exercise;
					}
				});
		training.setTrainingName(trainingName);
		// training.setWeekDay(weekDay);

		training.setExercises(exercises);
		return training;
	}

	
	
	
	
	
	
	
	
	
	
	
	// this method will return all trainings for particular user
	public List<Training> getUsersTrainings(String userName) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("userName", userName);

		// System.out.println("DaohowUsersTrainings on place");

		return database1.query("select * from training, users where training.userName=:userName"
				+ " and users.userName=:userName and users.enabled=true", parameter, new TrainingRowMapper());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// this method will return all trainings from database
	public List<Training> getTrainings() {

		return database1.query(
				"select * from training, users where training.username=users.username and users.enabled=true",
				new TrainingRowMapper());

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// this method will display only public training for guest users
	public List<Training> getPublicTraining() {

		return database1.query("select * from training where username = 'show'", new RowMapper<Training>() {
			public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
				Training training = new Training();
				training.setTrainingName(rs.getString("trainingName"));
				return training;
			}
		});
	}

	
	
	
	
	
	
	
	
	
	
	
	
	// method that checks if training exists
	public boolean trainingExists(String userName, String weekDay) {

		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("userName", userName);
		parameter.addValue("weekDay", weekDay);

		//System.out.println("Exist check1 Username " + userName + " weekday " + weekDay); // to
																							// remove

		return database1.queryForObject("select count(*) from training where userName=:userName and weekDay=:weekDay",
				parameter, Integer.class) > 0;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// method that checks if training exists
		public boolean trainingExists(String userName, String trainingName, String weekDay) {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("userName", userName);
			parameter.addValue("trainingName", trainingName);
			parameter.addValue("weekDay", weekDay);

			//System.out.println("Exist check1 Username " + userName + " trainingName " + trainingName + " weekday " + weekDay); // to
																								// remove

			return database1.queryForObject("select count(*) from training where userName=:userName and trainingName=:trainingName and weekDay=:weekDay",
					parameter, Integer.class) > 0;
		}
	
		
		
		
		
		
		
		
		
		
	
	// this method will create new user
	public void createTraining(Training training) {

		//System.out.println("Create test from dao " + training.getTrainingName() + ", " + training.getWeekDay() + ", " + training.getUserName() + ", " + training.toString());
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("trainingName", training.getTrainingName());
		parameter.addValue("weekDay", training.getWeekDay());
		parameter.addValue("userName", training.getUserName());

//		System.out.println();
//		System.out.println("test from dao " + training.getTrainingName() + ", " + training.getWeekDay() + ", "
//				+ training.getUserName() + ", " + training.toString());

		try {
			database1.update("insert into training (trainingName, weekDay, userName) values (:trainingName, :weekDay , :userName)",	parameter);
			System.out.println("training table updated");
		} catch (DataAccessException e) {			
			e.printStackTrace();
		}

		List<Exercise> exercises = training.getExercises();

		//System.out.println("Wszystkie cwiczenia is " + exercises.size());
		//System.out.println("Wszystkie cwiczenia" + exercises.toString());

		for (int i = 0; i < exercises.size(); i++) {

			parameter.addValue("exerciseName", exercises.get(i).getNameOfExercise());

			//System.out.println("Dane cwiczenie to" + exercises.get(i).getNameOfExercise());

			database1.update("insert into trainingSchedule (trainingName, exerciseName) values  (:trainingName, :exerciseName)", parameter);

			Integer groupId = database1.queryForObject( "select groupId from trainingSchedule where trainingName=:trainingName and exerciseName=:exerciseName ", parameter, Integer.class);

			//System.out.println(" this Group id is: " + groupId);// test to
																// remove

			// WORKING //
			List<Set> sets = exercises.get(i).getSets();

			System.out.println("Wszystkie set to " + sets.size());

			for (int j = 0; j < sets.size(); j++) {

				Set set = sets.get(j);
				System.out.println("groupId is " + groupId);

				parameter.addValue("groupId", groupId);

				System.out.println("Set no is " + set.getSetNo());
				parameter.addValue("setNo", set.getSetNo());

				parameter.addValue("repsNo", set.getReps());
				System.out.println("repsNo is " + set.getReps());

				parameter.addValue("weight", set.getWeight());
				System.out.println("weight is " + set.getWeight());

				database1.update("insert setPlan (groupId, setNo, repsNo, weight) values  (:groupId, :setNo, :repsNo, :weight)", parameter);

				Integer setId = database1.queryForObject(
						"select setId from setPlan where groupId=:groupId and setNo=:setNo ", parameter, Integer.class);
				parameter.addValue("setId", setId);
				System.out.println("setId is " + setId);

				database1.update("insert sets (setId, groupId) values  (:setId, :groupId)", parameter);
			}
		}
		System.out.println("Training Saved");
		
	}

	
	
	
	
	
	
	
	
	
	
	// this method will delete full training in all tables
	public void deleteTraining(String userName, String trainingName, String weekDay){
		
		if(trainingExists(userName, trainingName, weekDay)){
			
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("trainingName", trainingName);
			parameter.addValue("weekDay", weekDay);
			parameter.addValue("userName", userName);
			
			// delete all from training table
			database1.update("delete from training where trainingName=:trainingName and userName=:userName and weekDay=:weekDay" , parameter);
			System.out.println("t Deleted");
			
			
			// get all related groupId
			final List<Integer>groupIds = new ArrayList<>();
			
			database1.query(
					"select * from" + " trainingSchedule where trainingName=:trainingName", parameter,
					new RowMapper<Exercise>() {

						public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
							Exercise exercise = new Exercise();
							exercise.setNameOfExercise(rs.getString("exerciseName"));
							exercise.setGroupId(rs.getInt("groupId"));
							int groupId = exercise.getGroupId();
							System.out.println("Group id is " + groupId);
							groupIds.add(groupId);
							return exercise;
						}
					});
			System.out.println("Group ids are "  + groupIds.toString());
			
			// delete all from trainingSchedule table
			for(int i = 0; i <groupIds.size();i++ ){				
				
				try {
					parameter.addValue("groupId", groupIds.get(i));
					database1.update("delete from trainingSchedule where groupId=:groupId", parameter);
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				try {
					database1.update("delete from setPlan where groupId=:groupId", parameter);
				} catch (DataAccessException e) {					
					e.printStackTrace();
				}
				try {
					database1.update("delete from sets where groupId=:groupId", parameter);
				} catch (DataAccessException e) {					
					e.printStackTrace();
				}
			}
			System.out.println("training deleted");
			
		}else{
			System.out.println("training is still there");
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// this method will create new user
		public void updateTraining(Training training, Training safeCopy) {
			
			// save old training
			
			// get new training 
			System.out.println();
			System.out.println("Update test from dao " + training.getTrainingName() + ", " + training.getWeekDay() + ", " + training.getUserName());
			System.out.println();
			System.out.println("Update test from dao " + safeCopy.getTrainingName() + ", " + safeCopy.getWeekDay() + ", " + safeCopy.getUserName());
			
			// if training exists
			if (trainingExists(safeCopy.getUserName(), safeCopy.getTrainingName(), safeCopy.getWeekDay())) {
				
				System.out.println("Old training to delete exists " + safeCopy.getTrainingName() + ", " + safeCopy.getWeekDay() + ", " + safeCopy.getUserName());	
				
				// delete old from database
				deleteTraining(safeCopy.getUserName(), safeCopy.getTrainingName(), safeCopy.getWeekDay());	
				// create new on the place of old
				createTraining(training);	
				
				
				System.out.println("training updated");
			}else{
				System.out.println("training not updated");
			}
			
			
		}
	
	
		
		
		
		
		
		
		
		public List<String> getAllExercisesNames(){
			
			List<String> exerciseNames = database1.query("select * from excerciseList ", 
					new RowMapper<String>() {
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {							
							String exerciseName = rs.getString("exerciseName");							
							return exerciseName;
						}
					});			
//			System.out.println("exerciseNames " + exerciseNames.toString());
			
			return exerciseNames;			
		}
	
		
		
		
		
		
		
		
		
		
		
		public void addExercisesName(String exerciseName){
			
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("exerciseName", exerciseName);
			database1.update("insert into excerciseList (exerciseName) values (:exerciseName)",	parameter);
			System.out.println("Exercise name added");
			
		}


}








// end of class
