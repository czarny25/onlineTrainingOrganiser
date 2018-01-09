package model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDao")
public class UserDao {
	
	private NamedParameterJdbcTemplate database1;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public UserDao() {
		//System.out.println("Dao loaded");		
	}
	
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.database1 = new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	
    // this method  will return all users from database only for admin access
	public List<User> getAllUsers(){		
		return database1.query("select * from users  ", BeanPropertyRowMapper.newInstance(User.class));		
	}
	

	// this method  will create new user account version 2		
	@Transactional		
	public boolean createUser(User user){
				
			
			
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("userName", user.getUserName());
			parameter.addValue("password", passwordEncoder.encode(user.getPassword()));
			parameter.addValue("userEmail", user.getUserEmail());
			parameter.addValue("userEmail", user.getUserEmail());
			parameter.addValue("authority", user.getAuthority());
			parameter.addValue("enabled", user.isEnabled());
			
			database1.update("insert into users (userName, userEmail, password, authority, enabled) values (:userName, :userEmail, :password, :authority ,:enabled)", parameter);		
			return database1.update("insert into authorities (userName, authority) values (:userName, :authority)", parameter) == 1;
				
		
	}
	


}
