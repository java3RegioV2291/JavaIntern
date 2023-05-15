package AbstractShape2;

import java.util.Scanner;

public class HinhThang extends GeneralShape {
	float height;
	float base;
	float top;
	double area;
	

	protected void nhapKichthuoc() {
		this.name = " thang ";
		do {
			System.out.println("Nhập cạnh đánh, cạnh trên, chiều cao của hình " + this.name);
			String input= nhapTho();
			String[] kichThuoc;
			kichThuoc = input.split(";");
			this.base = Float.parseFloat(kichThuoc[0]);
			this.top = Float.parseFloat(kichThuoc[1]);
			this.height = Float.parseFloat(kichThuoc[2]);
			//System.out.println ("Đến dòng 19");
		} while (!checkInputSize(this.base)|| !checkInputSize(this.top)|| !checkInputSize(this.height));
		
	}

	protected double calculateArea() {
		this.area = 0.5 * this.height * (this.top + this.base);
		return this.area;
	}
}
