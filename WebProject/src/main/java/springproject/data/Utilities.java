package springproject.data;

public class Utilities {
	private static Long numberUser = 0L;
	private static Long numberMessage = 0L;
	
	public static Long getNextUser(){
		return numberUser++;
	}
	
	public static Long getNextMessage(){
		return numberMessage++;
	}
}
