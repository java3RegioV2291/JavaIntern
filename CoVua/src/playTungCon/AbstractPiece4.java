package playTungCon;

public abstract class AbstractPiece4 {
	  
	  protected static String[][] checkTargetPiece(String[][] board, String curPos, String targetPos) {
	    String[] curPostArr = curPos.split("_");
	    int curRow = Integer.parseInt(curPostArr[0]);
	    int curCol = Integer.parseInt(curPostArr[1]);
	    
	    String curPiece = board[curRow][curCol];
	    String curPieceColor = curPiece.substring(0,1);
	    
	    String[] targetPosArr = targetPos.split("_");
	    int targetRow = Integer.parseInt(targetPosArr[0]);
	    int targetCol = Integer.parseInt(targetPosArr[1]);
	    
	    String targetPiece = board[targetRow][targetCol];
	    
	    if (targetPiece==null) {
	      board[targetRow][targetCol] = curPiece;
	      board[curRow][curCol] = null;
	    }else {
	      String targetPieceColor = targetPiece.substring(0,1);
	      
	      if (curPieceColor.equals(targetPieceColor)) {
	        return board;
	      }else {
	        board[targetRow][targetCol] = curPiece;
	        board[curRow][curCol] = null;
	      }
	    }
	    
	    return board;
	  }
	  
	  public String[][] move(String[][] board, String curPos, String targetPos) {

	    if (!checkValidMove(board, curPos, targetPos)) {
	      return board;
	    }

	    return checkTargetPiece(board, curPos, targetPos);
	  }
	  
	  protected abstract boolean checkValidMove(String[][] board, String curPos, String targetPos);
	  
	}
