package springproject.model;

import org.springframework.beans.factory.annotation.Autowired;

import springproject.data.Utilities;

public class User {
	private final Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	/*
	@NotNull
	@Size(min=5, max=16)
	private String firstName;
	
	@NotNull
	@Size(min=5, max=25)
	private String lastName;
	
	@NotNull
	@Size(min=2, max=30)
	private String userName;
	
	@NotNull
	@Size(min=2, max=30)
	private String password;
	*/
	
	@Autowired
	public User(String firstName, String lastName, String userName, String password){
		id = Utilities.getNextUser();
		this.firstName = firstName;
		this.lastName  = lastName;
		this.userName  = userName;
		this.password  = password;
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
