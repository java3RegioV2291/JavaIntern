package Matrix;


public class DeepCopy  {
	public static void main  (String[] args ) {
		OriginalObject ori1= new OriginalObject(5,"Hello");
		OriginalObject copiedObject = deepCopy(ori1);
		System.out.println(copiedObject.getHeight() + "  "+ copiedObject.getName() );
	}
	private static OriginalObject deepCopy(OriginalObject original) {
		OriginalObject deepCopied = new OriginalObject();

			deepCopied.height = original.getHeight(); 
			deepCopied.name =original.getName();

		return deepCopied;	
			
}	
}



