package ShowbizPeople;

public abstract class AbstractPeople2 {

	public String name;
	public int age;

	protected void setGeneralInfor(String _name, int _age) {
		this.name = _name;
		this.age = _age;

	};
	protected String getName() {
		return this.name;		
	}
	protected int getAge() {
		return this.age;
	}
}
