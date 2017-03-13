package springproject.model;

public class Utilities {
	private static Long number = 0L;
	
	public static Long getNextNumber(){
		return number++;
	}
	
}
