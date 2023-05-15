package Chapter6;


	
	public class Crocodile extends Reptile {

	protected int spped = 20; 
	public int getSpeed () {
	return super.speed;
	}

	public static void main (String[] data) {
	var croc1 = new Crocodile();
	croc1.speed=15; 
	var croc2=new Crocodile();
	croc2.speed=20;
	System.out.println(croc1.getSpeed()); 
	System.out.println(croc2.getSpeed()); 
	}
	}


