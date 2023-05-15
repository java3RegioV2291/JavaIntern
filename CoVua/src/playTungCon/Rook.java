package playTungCon;

public class Rook extends AbstractPiece3 {
	
	
	protected boolean checkValidMove(String[][] board, String curPos, String targetPos) {
	    String[] curPostArr = curPos.split("_");
	    int curRow = Integer.parseInt(curPostArr[0]);
	    int curCol = Integer.parseInt(curPostArr[1]);

	    String[] targetPosArr = targetPos.split("_");
	    int targetRow = Integer.parseInt(targetPosArr[0]);
	    int targetCol = Integer.parseInt(targetPosArr[1]);

	    // check item in the middle on row
	    // lay tung Piece ở giữa 

	    	
	    
	 // check item in the middle on row
	    if (curCol==targetCol) {
	    	for (int row = findMin(curRow, targetRow)+1; row < findMax(curRow, targetRow); row++) {
	  	      String middlePiece = board[row][curCol];
	  	      if (middlePiece != null) {
	  	        return false;
	  	      }
	  	    }
	    	return true;
	    }
	    

	    // check item in the middle on col
	    if (curRow==targetRow) {
	    	for (int col = findMin(curCol, targetCol)+1; col < findMax(curCol, targetCol); col++) {
			      String middlePiece = board[curRow][col];
			      if (middlePiece != null) {
			        return false;
			      }
			}
	    }
		    

//	    if (curRow == targetRow || curCol == targetCol) {   // ủa là sao m*
//	      return true;
//	    }

	    return false;
	  }

}
