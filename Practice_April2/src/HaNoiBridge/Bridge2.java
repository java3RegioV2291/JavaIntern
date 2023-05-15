package HaNoiBridge;
import java.util.ArrayList;

public class Bridge2 {


	static int numOfPlate;
	static ArrayList<Integer> pileA = new ArrayList<>();
	static ArrayList <Integer> pileB = new ArrayList<>();
	static ArrayList<Integer> pileC = new ArrayList<>();

	
	public static void main (String[] args) {	
		
		
		
	}
	//ham khai bao pile ban dau: 
	private static void fillPile(int numOfPlate, ArrayList<Integer> pileX) {
		for(int pileSize=1; pileSize<=numOfPlate ; pileSize++) {
			pileX.add(pileSize);
		}
		return;
	}
	private static void arrangePlate (int plate, ArrayList<Integer> curPile, ArrayList<Integer> targetPile) {
		System.out.println("Chuyen tu cot "+ curPile+ " sang cot "+ targetPile);
		int tempPlate=curPile.get(0);
		if (tempPlate==plate) {
		curPile.remove(0);
		targetPile.add(0,tempPlate);
		};
		return;
	}
	private static void play() {
		ArrayList<Integer> sourcePile = pileA; 
		ArrayList<Integer> transferPile = pileB;
		ArrayList<Integer> targetPile = pileC;
		numOfPlate =3;	
		int size= numOfPlate;
		fillPile(numOfPlate,pileA);
		int curPlate=1;
		while (size!=0) {
		play2TopPlate(curPlate, pileA, pileB);
		playBase(size,pileA, pileC);
		size--;
		}
		return;;
	}
//	private static void playRestPlate extends play1Plate(int _numOfPlate) {
//		numOfPlate;
//		for (int curPlate=1; curPile<=numOfPlate; curPlate++) {		
		
	}
	private static void playTopPlates(int curPlate, ArrayList<Integer> sourcePile, ArrayList<Integer> targetPile) {	
			
		arrangePlate(curPlate,sourcePile,findNextPile(curPlate,sourcePile));  // chuyen 1 sang cot C
		curPlate++; 
		arrangePlate(curPlate,sourcePile,findNextPile(curPlate,sourcePile)); // chuyen 2 sang cot B
		
		curPlate=--; // curPlate=1
		arrangePlate(curPlate,targetPile,findNextPile(curPlate,targetPile)); // chuyen 1  tu cot C sang cot B
	}
	private static void playBase(int curPlate, ArrayList<Integer> sourcePile, ArrayList<Integer> targetPile) {  // chơi đĩa 3		
		
		arrangePlate(curPlate,sourcePile,findNextPile(curPlate,sourcePile));
		return;
	}	
	
	// ham get Right
	private static ArrayList<Integer> findNextPile(int curPlate, ArrayList<Integer> curPile){
		ArrayList<Integer> targetPile;
		int tempProduct= (numOfPlate%2 + curPlate%2);
		if (tempProduct==0|tempProduct==2) 
			targetPile =getLeftPile(curPile);
			else targetPile =getRightPile(curPile);
			
		return targetPile;
		}
	
	private static ArrayList<Integer> getRightPile (ArrayList<Integer> curPile) {
		if (curPile==pileA) return pileB; 
		else if (curPile==pileB) return pileC;
		else return pileC; 			
	}
	// ham getLeft
	private static ArrayList<Integer> getLeftPile (ArrayList<Integer> curPile) {
		if (curPile.equals(pileA)) return pileC; 
		else if (curPile.equals(pileB)) return pileA;
		else return pileB; 			
	}
	
	
	
	//  plate, pile
	
	}	
	
	
	
	
	
}
