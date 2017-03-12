package springproject.model;

import java.util.Date;

public class User {
	private final Long id;
	private final Date date;
	
	public User(){
		id = Utilities.getNextNumber();
		date = new Date();
	}

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}
	
}
