package playTungCon;
import java.util.Map;
import java.util.HashMap;
public class TestChessMrDungLuong {
	  
	  private static Map<String, AbstractPiece> pieceMap = new HashMap<>();
	  
	  public static void main(String[] args) {         // cũng là test chess nhưng mà rộng hơn
	    String[][] board = new String[8][8];
	    //initData();
	    AbstractPiece piece = pieceMap.get("R");
	    piece.move(board, "5_5", "5_3");

	  }
	  
	  private static void initData() {
	   // pieceMap.put("N", new Knight());
	    pieceMap.put("R", new Rook());
	  }
	  
	  private void testRook() {
	    String[][] board = new String[8][8];
	    
	    board[5][5] = "WR";
	    board[1][2] = "WK";
	    
	    Rook rook= new Rook();
	    rook.move(board, "5_5", "5_3");
	    
	    System.out.println("old pos: " + board[5][5]);
	    System.out.println("new pos: " + board[5][3]);
	  }
	}
}