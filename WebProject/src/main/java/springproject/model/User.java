package springproject.model;

import springproject.data.Utilities;
import javax.validation.constraints.*;

public class User {
	private final Long id;
	
	@NotNull
	@Size(min=5, max=16, message="{firstName.size}")
	private String firstName;
	
	@NotNull
	@Size(min=5, max=25, message="{lastName.size}")
	private String lastName;
	
	@NotNull
	@Size(min=2, max=30, message="{userName.size}")
	private String userName;
	
	@NotNull
	@Size(min=2, max=30, message="{password.size}")
	private String password;
	
	
	public User(){
		id = Utilities.getNextUser();
	}
	
	public User(Long id, String firstName, String lastName, String userName, String password){
		this.id = id;
		this.firstName = firstName;
		this.lastName  = lastName;
		this.userName  = userName;
		this.password  = password;
	}

	public User(String firstName, String lastName, String userName, String password){
		this(Utilities.getNextUser(),firstName,lastName,userName,password);
	}
		

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
