package playTungCon;

public class QuanQueen extends AbstractPiece4 {
	protected static int findMax(int a, int b) {
    	if (a>b) return a;
    	else return b; 
    }
    
    protected static int findMin(int a, int b) {
    	if (a>b) return b;
    	else return a; 
    }
    
	
	protected boolean checkValidMove(String[][] board, String curPos, String targetPos) {
		// check tren duong thang, ngang
		boolean innitValidation;

		String[] curPostArr = curPos.split("_");
	    int curRow = Integer.parseInt(curPostArr[0]);
	    int curCol = Integer.parseInt(curPostArr[1]);
	    //System.out.println("curRow: "+ curRow + "   curCol:" + curCol);
	    //String curPiece = board[curRow][curCol];
	    //String curPieceColor = curPiece.substring(0,1);
	    
	    String[] targetPosArr = targetPos.split("_");
	    int targetRow = Integer.parseInt(targetPosArr[0]);
	    int targetCol = Integer.parseInt(targetPosArr[1]);
	    //System.out.println("row min max là" +findMin(curRow, targetRow) + " "+findMax(curRow, targetRow) +"col max min là" +findMax (curCol, targetCol)+ "  " + findMin (curCol, targetCol));
	    //System.out.println(findMin(curCol, targetCol) - 1)
	    //System.out.println("targetRow: "+ targetRow + "   targetCol:" + targetCol);
	    //String targetPiece = board[targetRow][targetCol];
		if (curRow == targetRow | curCol == targetCol | Math.abs(curRow - targetRow) == Math.abs(curCol - targetCol)) { 
			innitValidation = true;
		} else
			innitValidation = false;

		if (innitValidation) {
			// check item in the middle on row
			if (curCol == targetCol) {
				for (int row = findMin(curRow, targetRow) + 1; row < findMax(curRow, targetRow); row++) {
					String middlePiece = board[row][curCol];
					if (middlePiece != null) {
						System.out.println("Không đi được hàng dọc do bị chặn");
						return false;
					}
				}
				//System.out.println("");
				return true;
			}

			// check item in the middle on col
			if (curRow == targetRow) {
				for (int col = findMin(curCol, targetCol) + 1; col < findMax(curCol, targetCol); col++) {
					String middlePiece = board[curRow][col];
					if (middlePiece != null) {
						System.out.println("Không đi được hàng ngang do bị chặn");
						return false;
					}
				}
				return true;
			}
			// check piece trên đường chéo

			if (Math.abs(curRow - targetRow) == Math.abs(curCol - targetCol)) {
				System.out.println(Math.abs(curRow - targetRow)+ "  "+ Math.abs(curCol - targetCol));
				if (Math.abs(curRow - targetRow) ==1) {
					System.out.println("Đi đường chéo được");
					return true;
				} else {
					long product = (curRow - targetRow) * (curCol - targetCol);
					if (product > 0) {                  // check Piece trên đường chéo đi lên
						for (int row = findMin(curRow, targetRow) + 1; row < findMax(curRow, targetRow); row++) {
							for (int col = findMin(curCol, targetCol) + 1; row < findMax(curCol, targetCol); col++) {
								String middlePiece = board[row][col];
								if (middlePiece != null) {
									System.out.println("Không đi được đường chéo do bị chặn: dòng 66");
									return false;
								}
							}

						}
						System.out.println("Nước đi đúng");
						return true;
					} else if (product < 0) {
						for (int row = findMin(curRow, targetRow) + 1; row < findMax(curRow, targetRow); row++) {
							for (int col = findMax(curCol, targetCol) - 1; col > findMin(curCol, targetCol); col--) {
								String middlePiece = board[row][col];
								if (middlePiece != null) {
									System.out.println("Không đi được đường chéo 2 do bị chặn: : dòng 79");
									return false;
								}
							}

						}
						System.out.println("Nước đi đúng");
						return true;
					}
				}  // hết trường hợp đường chéo
				}
					
				}			
			
		
		return false;
	}
}
