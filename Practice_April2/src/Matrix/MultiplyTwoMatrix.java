// MA tran A * Ma tran B 
// Ma tran C = A*B
// C[row][col] = sum(row A * col B) (SUM : Lan luot tung phan tu dong A * tung phan tu dong B)
package Matrix;

import java.util.Scanner;

public class MultiplyTwoMatrix {
	
	static float[][] matrix1 = new float[][] { { 1, 2, 3,4 },{ 1, 2, 3,4 }, { 1, 2, 3,4 } };
	static float[][] matrix2 = new float[][] { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
	
	static int row1 = matrix1.length;
	static int col1 = (matrix1[row1-1]).length;
	static int row2=col1;
	static int col2 = (matrix2[matrix2.length -1]).length;
	static Scanner sc = new Scanner(System.in);
    
     
	public static void main(String[] args) {
		
		double[][] multipliedMatrix = new double[row1][col2];			
		for (int rowIndex = 0; rowIndex < row1; rowIndex++) { 
			for (int colIndex = 0; colIndex  < col2; colIndex++) {					
				multipliedMatrix[rowIndex][colIndex] = sumproduct(takeRowMatrix(matrix1,rowIndex), takeColMatrix(matrix2,colIndex));				
			}
		}
		System.out.println("Ma tran 1 * Ma tran 2:");
		printMatrix(row1, col2, multipliedMatrix); 
		// chay dc toi day r
		return;
	}

	private static float[] takeRowMatrix(float[][] matrix, int rowIndex) {
		float[] rowMatrix= new float [col1];	    
		for (int i = 0; i < col1; i++) {
			rowMatrix[i] = matrix[rowIndex][i];			
		}
		return rowMatrix;
	}

	private static float[] takeColMatrix(float[][] matrix, int colIndex) {
		float[] colMatrix= new float [row2];
		for (int i = 0; i <row2; i++) {
			colMatrix[i] = matrix[i][colIndex];
		}
		return colMatrix;
	}

	private static double sumproduct(float[] rowMatrix, float[] colMatrix) {
		double product = 0;
		for (int i = 0; i < col1; i++) {
			product += (rowMatrix[i] * colMatrix[i]);
		}		
		return product;
	}

	private static void printMatrix(int row, int col, double[][] matrixToPrint) {
		System.out.println();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				System.out.print(matrixToPrint[i][j] + " ");
				// cho nay bi lap vo tan luon
			}
			System.out.println();
		}
		return;
	}

}
