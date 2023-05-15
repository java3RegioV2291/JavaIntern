package AbstractShape2;

import java.util.Scanner;

public class Circle extends GeneralShape {

	float radius;
	double area;

	protected void nhapKichthuoc() {
		this.name = " tròn ";
		do {
			System.out.println("Nhap kich thuoc hinh" + this.name + "ban kinh:");
			String input= nhapTho();
			this.radius = Float.parseFloat(input);
		} while (!checkInputSize(this.radius));
	}

	protected double calculateArea() {
		this.area = Math.PI * this.radius * this.radius;
		return this.area;
	}
}



