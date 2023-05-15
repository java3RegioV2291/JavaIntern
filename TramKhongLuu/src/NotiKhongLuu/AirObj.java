package NotiKhongLuu;

public abstract class AirObj {

	String type; 
	String index;
	//boolean isFromPlane;
	protected void setIndex(String _index) {		
		this.index = _index;
		
	}
	
	protected String getType() {
		return this.type;
	}
	protected String getIndex() {
		return this.index;
	}
	protected String getFullName() {
		return this.type + " "+ this.index;
	}
	protected void receiveNoti(AirObj fromObj, String noti) {
		System.out.println(this.getFullName() +" received noti: "+noti+ " FROM "+ fromObj.getFullName());
//		if (fromObj.type =="plane") {
//			isFromPlane = true; 
//		} else isFromPlane = false; 
//		
//		}
	}
}
