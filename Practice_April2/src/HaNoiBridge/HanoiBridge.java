package HaNoiBridge;
import java.util.ArrayList;
import java.util.Stack;

public class HanoiBridge {

	static ArrayList<Integer> pileA = new ArrayList<>();
	static ArrayList <Integer> pileB = new ArrayList<>();
	static ArrayList<Integer> pileC = new ArrayList<>();
	static int numOfPile = 8;
	
	public static void main (String[] args) {
		
		
	
		
		
	}
	//ham khai bao pile ban dau: 
	private static void fillPile(int numOfPile, ArrayList<Integer> pileX) {
		for(int pileSize=1; pileSize<=numOfPile ; pileSize++) {
			pileX.add(pileSize);
		}
		return;
	}
	private static void arrangePlate (int plate, ArrayList<Integer> targetPile, ArrayList<Integer> curPile) {
		curPile.remove() [0]; 
		
	}
	
	// ham get Right
	private static String getRightPile (String curPile) {
		switch (curPile): {
			case "A":
				return "B"; 
				break; 
			case "B":
				return "C";
				break; 
			case "C": 
				return "A"; 
				break;
			dafault:
				return "Invalid";
				break;
	}
	
	}
	// ham getLeft
	private static String getLeftPile (String curPile) {
		switch (curPile) {
			case "A":
				return "C"; 
				break; 
			case "B":
				return "A";
				break; 
			case "C": 
				return "B"; 
				break;
			dafault:
				return "Invalid";
				break;
	}
	
	
	
	//  plate, pile
	
	
	
	
	
	
	
}
