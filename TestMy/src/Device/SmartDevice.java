package Device;

public interface SmartDevice {		
	   
		
		void turnOn();

	    void turnOff();

	    int getMemory();

	    void setMemory(int _memory);

	    void connectWifi();
	    boolean hasWifi();

	    void setLanguage(Language _language);

	    void printStatus();
	
}
