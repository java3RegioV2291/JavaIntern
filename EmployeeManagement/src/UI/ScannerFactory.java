package UI;

import java.util.Scanner;

public class ScannerFactory {

	private static Scanner SCANNER; // khai báo biến SCANNER

	public static Scanner getScanner() {
		if (SCANNER == null) {
			SCANNER = new Scanner(System.in);
		}
		return SCANNER;
	}
}
