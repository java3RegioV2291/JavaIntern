package Cloning;


public class ClassMain {
	public static void main(String[] args) throws CloneNotSupportedException {
		 ObjFeatures obj1 = new ObjFeatures(5, "Cookoo");
		
		ObjFeatures obj2 = (ObjFeatures) obj1.clone();
		obj2.height = 7;
		//obj2.name = "Cuckoo";
		
		System.out.println("Obj1" + " name: " + obj1.getName() + " height: " + obj1.getHeight());
		
		System.out.println("Obj2" + " name: " + obj2.getName() + " height: "+ obj2.getHeight());
		
        
	}
}
