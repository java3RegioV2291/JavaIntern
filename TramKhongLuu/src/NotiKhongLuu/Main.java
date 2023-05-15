package NotiKhongLuu;

import java.util.List;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		List<Plane> listOfPlanes = new ArrayList<>();
		
		AirflowStation station1 = new AirflowStation();
		station1.setIndex("1");
		Plane plane1 = new Plane(listOfPlanes);
		plane1.setIndex("1");
		Plane plane2 = new Plane(listOfPlanes);
		plane2.setIndex("2");

		station1.sendNotiToAllPlanes(listOfPlanes, "My connection is not stable but even stupid");
		plane1.sendNoti(station1, plane2, "Hurry away to avoid the hurricane");
		return;

	}
}
