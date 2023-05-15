package Software;
//import Device.SmartDevice.Laptop;
//import Device.SmartDevice.SmartPhone;
public class Main {
 
	public static void main (String[] args) {
		Device.Laptop laptop1= new Device.Laptop();
		Device.SmartPhone smartPhone1= new Device.SmartPhone();
		
		laptop1.turnOn();
		laptop1.hasWifi=true;
		BankingApp bankingApp1= new BankingApp (laptop1);
		laptop1.printStatus();
		bankingApp1.runTransaction();
		
		BankingAppVer2 bankingApp2= new BankingAppVer2 (smartPhone1);
		smartPhone1.printStatus();
		bankingApp2.runTransaction();
		bankingApp2.sendNoti();
		
	}
}
