package Matrix;

public class OriginalObject {
	public int height; 
	public String name;
	public OriginalObject ( int _height,String _name) {
		this.height = _height; 
		this.name = _name;
	}
	
	public OriginalObject() {};

	private int getHeight() {
		return this.height;
	}

	private String getName() {
		return this.name;
	}
}
