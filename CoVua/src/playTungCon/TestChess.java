package playTungCon;

public class TestChess {
	  public static void main(String[] args) {
	    
	    String[][] board = new String[8][8];
	    
	    board[4][0] = "WQ";
	    //board[3][1]= "BK";
	    
//	    board[1][2] = "WK";
	    
	    QuanQueen queen= new QuanQueen();
	    
	    queen.move(board, "4_0", "2_2");
	    
	    System.out.println("old pos: " + board[4][0]);
	   // System.out.println("mid pos: " + board[1][3]);
	    System.out.println("new pos: " + board[2][2]);
	    
	  }
	}
