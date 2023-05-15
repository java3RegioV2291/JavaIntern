package NotiKhongLuu;
import java.util.List;
import java.util.ArrayList;
public class Plane extends AirObj {
	
	protected Plane(List<Plane> listOfPlanes) {
	this.type="plane";	
	listOfPlanes.add(this);
	}
	
	protected void sendNoti (AirflowStation midStation, Plane toPlane, String noti) { 
		System.out.println( this.getFullName() +" sent noti:  " + noti +" via " + midStation.getFullName()+ " TO: "+ toPlane.getFullName() );
		midStation.sendNoti(this,toPlane,noti);
	}
	
}