package AbstractShape2;

import java.util.Scanner;

public class Rectangle extends GeneralShape{
	float height;
	float width;
	double area;
		
	protected void nhapKichthuoc() {
		this.name = " chữ nhật ";
		do {
		System.out.println("Nhập kích thước hình" + this.name + "chieu dai; chieu rong:");
		String input= nhapTho();
		String [] inputArr = input.split(";");
		this.height=Float.parseFloat(inputArr[0]);
		this.width = Float.parseFloat(inputArr[1]);
		//System.out.println ("Đến dòng 19");
		} while (!checkInputSize(this.height)|| !checkInputSize(this.width));
		
	}
		//System.out.println("hinh nay la:" + this.name );	}
	
	protected double calculateArea() {		
		this.area= this.height*this.width; 		
		return this.area;
}
}
