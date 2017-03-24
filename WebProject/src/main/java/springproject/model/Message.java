package springproject.model;

import java.util.Objects;

import springproject.data.Utilities;

public class Message {
	private final Long id;
	private final String text;
	
	public Message(String text){
		this.id   = Utilities.getNextMessage();
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	
	@Override
	public boolean equals(Object that){
		if(this==that) return true;
		if(that==null) return false;
		if(getClass() != that.getClass()) return false;
		Message m2 = (Message) that;
		return Objects.equals(id, m2.id)
				&& Objects.equals(text, m2.text);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(id, text);
	}
}
