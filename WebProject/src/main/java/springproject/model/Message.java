package springproject.model;

import java.util.Objects;

public class Message {
	private final Long id;
	private final String text;
	
	public Message(Long id, String text){
		this.id = id;
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
		return Objects.equals(this, that);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(id, text);
	}
}
