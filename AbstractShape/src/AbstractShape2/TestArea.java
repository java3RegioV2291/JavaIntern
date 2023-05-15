package AbstractShape2;

import java.util.Scanner;

public class TestArea {

	public static void main(String[] args) {
		System.out.println("Nhập loại hình cần tính diện tích: tròn,  chữ nhật, hình thang, (1/2/3)");
		Scanner sc = new Scanner(System.in);
		String optionNumber = sc.nextLine();
		int shapeType = Integer.parseInt(optionNumber);
		if (shapeType == 1) {
			Circle circle1 = new Circle();
			circle1.nhapKichthuoc();
			circle1.printArea();
		} else if (shapeType == 2) {
			Rectangle rec1 = new Rectangle();
			rec1.nhapKichthuoc();
			rec1.printArea();
		} else if (shapeType == 3) {
			HinhThang hinhthang1 = new HinhThang();
			hinhthang1.nhapKichthuoc();
			hinhthang1.printArea();

		}

	}
}
