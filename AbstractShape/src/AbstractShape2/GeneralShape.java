package AbstractShape2;

import java.util.Scanner;

public abstract class GeneralShape {
	protected String name;
	protected abstract void nhapKichthuoc(); // Mỗi đứa mỗi nhập khác nhau mà 
	protected String nhapTho() {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}
	
	protected abstract boolean checkInputString(String input);
	
	 // xử lí dữ liệu
	protected boolean checkInputSize(float size) {  
		if (size>0) return true; 
		System.out.println ("Kích thước không hợp lệ");
		return false;
	}
	
	protected abstract double calculateArea();
	protected void printArea() {
		System.out.println("Diện tích hình "+ this.name + " là "+ this.calculateArea());
	}
	
}
