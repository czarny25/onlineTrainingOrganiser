package test.junitTests;



import javax.sql.DataSource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import model.UserDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:configs/model-context.xml", 
		"classpath:configs/security-context.xml",
		"classpath:test/config/testData.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUser {
	
//	@Autowired
//	private UserDao userDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from users ");
		jdbc.execute("delete from authorities");
	}
	
//	@Test
//	public void createTest(){
//		
//		User user = new User("Maniek", "maniek@gefe", "mania", "ROLE_USER", true);
//		
//		assertTrue("User creation true", userDao.createUser(user));
//		
//		List<User>users =  userDao.getAllUsers();
//		
//		assertEquals("Numbers of users should be 1.", 1, users.size());
//		
//	}

	
	
	
	
}














