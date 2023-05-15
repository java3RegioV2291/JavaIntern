package Cloning;

public class ObjFeatures implements Cloneable {
	public int height;
	public String name;

	public ObjFeatures(int _height, String _name) {
		this.height = _height;
		this.name = _name;
	}

	protected int getHeight() {
		return this.height;
	}

	protected String getName() {
		return this.name;
		
	}
	@Override
	public Object clone() throws CloneNotSupportedException {

		return (ObjFeatures) super.clone();
	}
}
