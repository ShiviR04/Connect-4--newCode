import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        checks check = new checks();
        boolean gameRun = true;
        String[][] board = new String[6][7];
        int turn = 0;
        //red = player 1
        String red = "R";

        //yellow = player 2
        String yellow = "Y";

        //whitespace
        String empty = " ";
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                board[row][column] = empty;
            }
        }
        while (gameRun) {

            //TEMPORARY
            checks.display(board);

            //checks if someone won or not
            if (check.verticalCheck(board, red, yellow) == false) System.exit(0);

            if (check.horizontalCheck(board, red, yellow) == false) System.exit(0);

            if (check.downDiagonalCheck(board, red, yellow) == false) System.exit(0);

            if (check.upDiagonalCheck(board, red, yellow) == false) System.exit(0);

            //checks if game is a draw
            //gameRun = check.draw(board, red, yellow, empty, turn);
            if (turn == 42){
                System.out.println("Game is a draw!");
                System.exit(0);
            }


            //Ask where to place piece
            boolean piece = false;
            int location = -1;
            turn++;
            while (!piece && (location < 0 || location > 6)) {
                System.out.println("Enter the column (0 to 6) you want to put your piece in: ");
                location = scanner.nextInt();
                int rowCheck = -10;
                if (location >= 0 && location <= 6) rowCheck = check.emptyCheck(board, red, yellow, empty, location);
                if (rowCheck == -1) {
                    while(rowCheck == -10 || rowCheck == -1){
                        System.out.println("The column is full, enter another column: ");
                        location = scanner.nextInt();
                        rowCheck = check.emptyCheck(board, red, yellow, empty, location);
                    }
                }
                if (rowCheck != -10){
                    if (turn % 2 != 0) board[rowCheck][location] = red;
                    else if (turn % 2 == 0) board[rowCheck][location] = yellow;
                    piece = true;
                }
            }
        }
    }
}