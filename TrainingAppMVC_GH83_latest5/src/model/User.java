package model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;



public class User {
	
	@NotBlank
	@Size(min=2, max=30)
	@Pattern(regexp="^\\w{4,}$")
	private String userName;
	
	
	@Email	
	private String userEmail;
	
	@NotBlank
	@Size(min=4, max=30)
	@Pattern(regexp="^\\S+$")
	private String password;
	
	
	private String authority;
	private boolean enabled = false;
		
	
	public User() {
	}

	public User(String userName, String userEmail, String password, String authority, boolean enabled) {

		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.authority = authority;
		this.enabled = enabled;
		
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	
	
	
	
	
}
