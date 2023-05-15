package Test_Object;
import java.util.ArrayList;

public class Dog {
	public static void main(String[] args) {
		//var name = new StringBuilder("Webby");
		ArrayList<String> arr1= new ArrayList<> ();
		arr1.add("Chu Nhat chill");
		
		speak(arr1);
		System.out.print(arr1.size()); // WebbyGeorgette
	}

	public static void speak(ArrayList arr) {
		
		System.out.println(arr.size());
		//arr.add("qqq"); 
	}
}