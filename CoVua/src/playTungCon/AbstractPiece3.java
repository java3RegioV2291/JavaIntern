package playTungCon;

public abstract class AbstractPiece3 {
	static String curPos="-1_-1"; 
	static String targetPos="-1_-1";
	static String[][] board;
	static String[] curPostArr = curPos.split("_");
	int curRow = Integer.parseInt(curPostArr[0]);
	int curCol = Integer.parseInt(curPostArr[1]);
	
	// lấy nguyên string quân hiện tại
	String curPiece = board[curRow][curCol];
	String curPieceColor = curPiece.substring(0,1);

	String[] targetPosArr = targetPos.split("_");
	int targetRow = Integer.parseInt(targetPosArr[0]);
	int targetCol = Integer.parseInt(targetPosArr[1]);
	
	String targetPiece = board[targetRow][targetCol];
	

	protected static boolean checkTargetPiece(String curPos, String targetPos) {  // check coi thuộc trường hợp đi được hay ko
		
		boolean newBlank=false;
		boolean isOpponent=false;
		boolean isOurPiece=false;
		
//		String[] curPostArr = curPos.split("_");
//		int curRow = Integer.parseInt(curPostArr[0]);
//		int curCol = Integer.parseInt(curPostArr[1]);
//		
//		// lấy nguyên string quân hiện tại
//		String curPiece = board[curRow][curCol];
//		String curPieceColor = curPiece.substring(0,1);
//
//		String[] targetPosArr = targetPos.split("_");
//		int targetRow = Integer.parseInt(targetPosArr[0]);
//		int targetCol = Integer.parseInt(targetPosArr[1]);
//		
//		String targetPiece = board[targetRow][targetCol];
		
		  // lấy nguyên các kí tự, vd WR1
		
		if (targetPiece == null) {
			newBlank= true;			  
			// nếu trống thì chơi luôn ủa j dợ, có bị lỗi chỗ nào hok
		} else {
			String targetPieceColor = targetPiece.substring(0,1); // màu của quân ô đích
			if (curPieceColor.equals(targetPieceColor)) {    // quân mình ở goal thì ko đánh
				isOurPiece=true;
				
			} else {
				isOpponent=true;
			}
		}

		if (isOpponent==true|isOurPiece==false| newBlank==true) return true;
		return false;
	}

	public void move(String curPos, String targetPos) {   // move xong trả lại bàn cờ
		
		if (checkTargetPiece(curPos,targetPos) && checkValidMove(curPos, targetPos)) {   // di chuyển nếu thỏa điều kiện hết
			targetPiece=curPiece;
			curPiece=null;				
			return;
		}

		System.out.println("Khong the di nuoc nay. Vui long di lai");
		return;
	}

	protected abstract boolean checkValidMove(String curPos, String targetPos);
	
	public static int findMax(int a, int b) {
    	if (a>b) return a;
    	else return b; 
    }
    
    public static int findMin(int a, int b) {
    	if (a>b) return b;
    	else return a; 
    }

}
