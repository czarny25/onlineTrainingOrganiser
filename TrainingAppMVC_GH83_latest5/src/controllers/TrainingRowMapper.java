package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Training;
import model.User;

public class TrainingRowMapper implements RowMapper<Training>{

	@Override
	public Training mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		user.setUserName(rs.getString("userName"));
		user.setUserEmail(rs.getString("userEmail"));
		//user.setAuthority(rs.getString("authority"));
		user.setEnabled(true);
		
		Training training = new Training(); 
		training.setTrainingName(rs.getString("trainingName"));
		training.setWeekDay(rs.getString("weekDay"));
		training.setUserName(user);
		
		
		
//		System.out.println(" Training row mapper - " + training.toString());
				
	return training;
	}

}
