package playTungCon;

public abstract class AbstractPiece {
	  
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
	      board[targetRow][targetCol] = curPiece;   // nếu null thì chơi
	    }else {
	      String targetPieceColor = targetPiece.substring(0,1);  
	      
	      if (curPieceColor.equals(targetPieceColor)) {
	        return board;
	      }else {
	        board[targetRow][targetCol] = curPiece;    //Check nếu ko phải quân mình ( là quân của đối thủ) thì cứ đi  
	      }
	    }
	    
	    return board; // move xong trả về bàn cờ
	  }
	  
	  public abstract String[][] move(String[][] board, String curPos, String targetPos); // ủa move rồi mà
		  
	  
	  
	}
