package TicTacToe;
import java.util.Scanner;

public class TestCaroNewRule4 {

    static String[][] board;
    static String player1 = "x";
    static String player2 = "o";

    static int size;
    static int numMarkWin = 5;

    static int checkNum = numMarkWin - 1;
    static int[] curPoint = new int[2];
    static String currentPlayer = player1;
    static int curRow;
    static int curCol;

    public static void main(String[] args) {

        createBoard();
        printBoard();

        while (!isBoardFull()) {
            // Nguoi choi nhap toa do
            play(currentPlayer);
            printBoard();
            if (checkWin(currentPlayer, curPoint))
                return;

            // muonn dung chuogn trinh tại dây luôn
        }

        if (isBoardFull())
            System.out.println("Game hoa!");
        return;
    }

    // cac method
    private static boolean checkWin(String currentPlayer, int[] curPoint) {
        if (checkHorizontal(currentPlayer, curPoint) || checkVertical(currentPlayer, curPoint)
                || checkDiagonal(currentPlayer, curPoint)) {
            System.out.println("Player " + currentPlayer + " win. End game!");
            return true;
        } else {
            System.out.println("Player " + currentPlayer + " haven't won. Game continues");
            changePlayer();
            return false;
        }
    }

    public static String[][] createBoard() { // khởi tạo cái khung

        System.out.print("Enter the size of the board: ");
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        board = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = "-";
            }
        }
        return board;
    }

    private static void printBoard() {
        System.out.println();

        for (String[] innerBoard : board) {
            System.out.print("| ");
            for (String playerMark : innerBoard) {
                System.out.print(playerMark + " | ");
            }
            System.out.println();
            System.out.println();
        }
    }

    private static String inputLocation(String currentPlayer) {
        System.out.println("Input the location of " + currentPlayer + " for example 2-3");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        while (input.contains("--"))
            input = input.replace("--", "-");
        return input;
    }

    //
    private static int[] takeIntLocation(String input, String currentPlayer) { // turn string to arr int []

        String[] arr2 = input.split("-");
        curPoint[0] = Integer.parseInt(arr2[0].trim());
        curPoint[1] = Integer.parseInt(arr2[1].trim());
        return curPoint;
    }

    private static boolean checkLocation(String input, String currentPlayer) {
        int curRowForTest;
        int curColForTest;
        try {
            String[] arr = input.split("-");
            curRowForTest = Integer.parseInt(arr[0].trim());
            curColForTest = Integer.parseInt(arr[1].trim());
            if (curRowForTest < 0 || curRowForTest >= size || curColForTest < 0 || curRowForTest >= size) { // OR
                System.out.println("Vi tri khong hop le, vui long nhap lai!");

                return false;

            } else if (!board[curRowForTest][curColForTest].equals("-")) {
                System.out.println("O nay da duoc danh, vui long nhap lai!");
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Invalid location. Input location again");
            return false;
        }

    }

    public static void play(String currentPlayer) {
        // check nuoc di hop le
        String input;
        do {
            input = inputLocation(currentPlayer);
            curPoint = takeIntLocation(input, currentPlayer);
        } while (!checkLocation(input, currentPlayer));
        curRow = curPoint[0];
        curCol = curPoint[1];
        board[curRow][curCol] = currentPlayer; // ủa sao lượt của o thì ko tick đc v?
        return;
    }

    private static boolean isBoardFull() {
        boolean isFull = true;

        for (String[] innerBoard : board) {
            for (String playerMark : innerBoard) {
                if (playerMark.equals("-"))
                    return false;
            }

        }
        return isFull;
    }

    private static boolean checkHorizontal(String currentPlayer, int[] curPoint) {

        for (int i = 0; i < numMarkWin; i++) {
            int left = checkNum - i;
            int right = i;

            // System.out.println("i: " + i + " left " + left + " right " + right);
            if (checkLeftRight(currentPlayer, curPoint, left, right)) {
                // 5 con ms tra ve true
                int wayLeft = curPoint[1] - left - 1;
                int wayRight = curPoint[1] + right + 1;
                int curRow2 = curPoint[0];
                // System.out.println("wayLeft" + wayLeft); // chua chay toi
                System.out.println("wayRight" + wayRight); // chua chay toi
                if (!check2way(curRow, wayLeft, curRow2, wayRight, currentPlayer)) // nếu bị chặn thì phải return false
                                                                                   // chứ
                    return true;
            }
        }

        return false;
    }

    private static String otherPlayer(String currentPlayer) {
        if (currentPlayer == player1)
            return player2;
        else
            return player1;
    }

    private static boolean check2way(int row1, int col1, int row2, int col2, String currentPlayer) {
        // tim truong hop thua, bị chặn
        // System.out.println("Diem test 1, 2 lan luot la - TEST 1" + board[row1][col1]
        // + "va " + board[row2][col2]);
        if ((checkValidMarkLocation(row1, col1) && board[row1][col1].equals(otherPlayer(currentPlayer)))
                && (checkValidMarkLocation(row2, col2)
                        && board[row2][col2].equals(otherPlayer(currentPlayer)))) {
            System.out.println("Bi chan 2 dau");
            // 3- System.out.println("Diem test 1, 2 lan luot la TEST 2" + board[row1][col1]
            // +
            // "va " + board[row2][col2]);
            return true;
        }

        return false;
    }

    private static boolean checkValidMarkLocation(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size)
            return false;
        return true;

    }

    private static boolean checkLeftRight(String currentPlayer, int[] curPoint, int left, int right) {
        int countCorrect = 1;
        int rong = 0;
        int curCol = curPoint[1];
        int curRow = curPoint[0];

        // check left
        for (int i = 1; i <= left; i++) {
            int newCol = curCol - i;
            // check out of board col

            if (newCol >= 0 && newCol < size) {
                // System.out.println(" curRow " + curRow + " newCol " + newCol);
                String newPointMark = board[curRow][newCol];
                if (newPointMark.equals("-")) {
                    rong++;
                    countCorrect++;
                    if (rong > 2)
                        return false;
                } else {
                    if (!currentPlayer.equals(newPointMark)) {
                        return false;
                    } else {
                        countCorrect++;
                    }

                }
            }
        }

        // check right
        for (int i = 1; i <= right; i++) {
            int newCol = curCol + i;

            // check out of board col
            if (newCol < size && newCol >= 0) {
                String newPointMark = board[curRow][newCol];
                if (newPointMark.equals("-")) {
                    rong++;
                    countCorrect++;
                    if (rong > 2)
                        return false;
                } else {
                    if (!currentPlayer.equals(newPointMark)) {
                        return false;
                    } else {
                        countCorrect++;
                    }
                }
            }
        }

        // System.out.println("Cho cuoi check LeftRightCountCorrect: " + countCorrect);
        int midCol = curCol - left + 2;
        if (checkValidMarkLocation(curRow, midCol) && (board[curRow][midCol]).equals("-")
                && countCorrect == numMarkWin && rong == 1)
            return true;
        else
            return false;

    }

    private static void changePlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    } // sao cái này sai nhở? nó kêu ko chạy đc

    // check hàng dọc:
    private static boolean checkVertical(String currentPlayer, int[] curPoint) {

        for (int i = 0; i < numMarkWin; i++) {
            int above = checkNum - i;
            int below = i;
            // System.out.println(" above " + above + " below" + below);

            if (checkAboveBelow(currentPlayer, curPoint, above, below) == true) {
                int wayAbove = curPoint[0] - above - 1;
                int wayBelow = curPoint[0] + below + 1;
                int curCol2 = curPoint[1];
                if (!check2way(wayAbove, curCol, wayBelow, curCol2, currentPlayer)) // nếu ko bị chặn 2 đầu
                    return true;
            }
        }

        return false;
    }

    private static boolean checkAboveBelow(String currentPlayer, int[] curPoint, int above, int below) {
        int countCorrect = 1;
        int rong = 0;
        // check above
        for (int i = 1; i <= above; i++) {
            int newRow = curRow - i;
            // check out of board row
            if (newRow >= 0 && newRow < size) {
                String newPointMark = board[newRow][curCol];
                if (newPointMark.equals("-")) {
                    rong++;
                    countCorrect++;
                    if (rong > 2)
                        return false;
                } else if (!currentPlayer.equals(newPointMark)) {
                    return false;
                } else {
                    countCorrect++;
                }
            }
        }

        // check below
        for (int i = 1; i <= below; i++) {
            int newRow = curRow + i;
            if (newRow < size && newRow >= 0) {
                String newPointMark = board[newRow][curCol];
                if (newPointMark.equals("-")) {
                    rong++;
                    countCorrect++;
                    if (rong > 2)
                        return false;
                } else if (!currentPlayer.equals(newPointMark)) {
                    return false;
                } else {
                    countCorrect++;
                }
            }
        }
        int midRow = curRow - above + 2;
        if (checkValidMarkLocation(midRow, curCol) && (board[midRow][curCol]).equals("-")
                && countCorrect == numMarkWin && rong == 1) {
            System.out.println(" cho check Above Below: countCorrect:  " + countCorrect);
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkDiagonal(String currentPlayer, int[] curPoint) {

        for (int i = 0; i < numMarkWin; i++) {
            int rightDiagonal = checkNum - i;
            int leftDiagonal = i;
            if (checkUpperDiagonal(currentPlayer, curPoint, leftDiagonal, rightDiagonal)
                    || checkLowerDiagonal(currentPlayer, curPoint, leftDiagonal, rightDiagonal)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkUpperDiagonal(String currentPlayer, int[] curPoint, int leftDiagonal,
            int rightDiagonal) {
        int countCorrect = 1;
        int rong = 0;

        // check ben trai duong cheo
        for (int i = 1; i <= leftDiagonal; i++) {
            int newRow = curRow + i;
            int newCol = curCol - i;

            // check out of board row
            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                String newPointMark = board[newRow][newCol];

                if (newPointMark.equals("-")) {
                    rong++;
                    countCorrect++;
                    if (rong > 2)
                        return false;

                } else if (!currentPlayer.equals(newPointMark)) {
                    return false;
                } else {
                    countCorrect++;
                }
            }
        }

        // check ben phai duong cheo
        for (int i = 1; i <= rightDiagonal; i++) {
            int newRow = curRow - i;
            int newCol = curCol + i;
            // check out of board col
            if (newRow < size && newRow >= 0 && newCol < size && newCol >= 0) {
                String newPointMark = board[newRow][newCol];
                if (newPointMark.equals("-")) {
                    rong++;
                    countCorrect++;
                    if (rong > 2)
                        return false;
                } else if (!currentPlayer.equals(newPointMark)) {
                    return false;
                } else {
                    countCorrect++;
                }
            }
        }

        int midRow = curRow + leftDiagonal - 2;
        int midCol = curCol - leftDiagonal + 2;
        if (checkValidMarkLocation(midRow, midCol) && (board[midRow][midCol]).equals("-")
                && countCorrect == numMarkWin && rong == 1) {
            int newRow1 = curRow + leftDiagonal + 1;
            int newCol1 = curCol - leftDiagonal - 1;
            int newRow2 = curRow - rightDiagonal - 1;
            int newCol2 = curCol + rightDiagonal + 1;
            if (!check2way(newRow1, newCol1, newRow2, newCol2, currentPlayer))
                return true;
        }

        return false;
        // check LowerDiagonal

    }

    // lower Diagonal
    private static boolean checkLowerDiagonal(String currentPlayer, int[] curPoint, int leftDiagonal,
            int rightDiagonal) {
        int countCorrect = 1;
        int rong = 0;
        // check ben trai duong cheo
        for (int i = 1; i <= leftDiagonal; i++) {
            int newRow = curRow - i;
            int newCol = curCol - i;

            // check out of board row
            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                String newPointMark = board[newRow][newCol];
                if (newPointMark.equals("-")) {
                    rong++;
                    countCorrect++;
                    if (rong > 2)
                        return false;
                } else if (!currentPlayer.equals(newPointMark)) {
                    return false;
                } else {
                    countCorrect++;
                }
            }
        }

        // check trai duong cheo
        for (int i = 1; i <= rightDiagonal; i++) {
            int newRow = curRow + i;
            int newCol = curCol + i;
            // check out of board col
            if (newRow >= 0 && newRow < size && newCol < size && newCol >= 0) {

                String newPointMark = board[newRow][newCol];
                if (newPointMark.equals("-")) {
                    rong++;
                    countCorrect++;
                    if (rong > 2)
                        return false;
                } else if (!currentPlayer.equals(newPointMark)) {
                    return false;
                } else {
                    countCorrect++;
                }
            }
        }

        int midRow = curRow - leftDiagonal + 2;
        int midCol = curCol - leftDiagonal + 2;
        if (checkValidMarkLocation(midRow, midCol) && (board[midRow][midCol]).equals("-")
                && countCorrect == numMarkWin && rong == 1) {
            int newRow1 = curRow - leftDiagonal - 1;
            int newCol1 = curCol - leftDiagonal - 1;
            int newRow2 = curRow + rightDiagonal + 1;
            int newCol2 = curCol + rightDiagonal + 1;
            if (!check2way(newRow1, newCol1, newRow2, newCol2, currentPlayer))
                return true;
        }

        return false;

    }

}

