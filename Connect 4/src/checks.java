import java.util.*;

public class checks {

    //Checks if someone won or not
    public boolean horizontalCheck(String[][] board, String red, String yellow) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length - 3; column++) {
                if ((board[row][column].equals(red)) && (board[row][column + 1].equals(red)) && (board[row][column + 2].equals(red)) && (board[row][column + 3].equals(red))) {
                    System.out.println("Player 1  wins! (Horizontal)");
                    return false;
                } else if ((board[row][column].equals(yellow)) && (board[row][column + 1].equals(yellow)) && (board[row][column + 2].equals(yellow)) && (board[row][column + 3].equals(yellow))) {
                    System.out.println("Player 2  wins! (Horizontal)");
                    return false;
                }
            }
        }

        return true;
    }

    public boolean verticalCheck(String[][] board, String red, String yellow) {
        for (int row = 0; row < board.length - 3; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if ((board[row][column].equals(red)) && (board[row + 1][column].equals(red)) && (board[row + 2][column].equals(red)) && (board[row + 3][column].equals(red))) {
                    System.out.println("Player 1  wins! (Vertical)");
                    return false;
                } else if ((board[row][column].equals(yellow)) && (board[row + 1][column].equals(yellow)) && (board[row + 2][column].equals(yellow)) && (board[row + 3][column].equals(yellow))) {
                    System.out.println("Player 2  wins! (Vertical)");
                    return false;
                }
            }
        }

        return true;
    }

    public boolean downDiagonalCheck(String[][] board, String red, String yellow) {
        for (int row = 0; row < board.length - 3; row++) {
            for (int column = 0; column < board[row].length - 3; column++) {
                if ((board[row][column].equals(red)) && (board[row + 1][column + 1].equals(red)) && (board[row + 2][column + 2].equals(red)) && (board[row + 3][column + 3].equals(red))) {
                    System.out.println("Player 1  wins! (Downward Diagonal)");
                    return false;
                } else if ((board[row][column].equals(yellow)) && (board[row + 1][column + 1].equals(yellow)) && (board[row + 2][column + 2].equals(yellow)) && (board[row + 3][column + 3].equals(yellow))) {
                    System.out.println("Player 2  wins! (Downward Diagonal)");
                    return false;
                }
            }
        }

        return true;
    }

    public boolean upDiagonalCheck(String[][] board, String red, String yellow) {
        for (int row = 3; row < board.length; row++) {
            for (int column = 0; column < board[row].length - 3; column++) {
                if ((board[row][column].equals(red)) && (board[row - 1][column + 1].equals(red)) && (board[row - 2][column + 2].equals(red)) && (board[row - 3][column + 3].equals(red))) {
                    System.out.println("Player 1  wins! (Upward Diagonal)");
                    return false;
                } else if ((board[row][column].equals(yellow)) && (board[row - 1][column + 1].equals(yellow)) && (board[row - 2][column + 2].equals(yellow)) && (board[row - 3][column + 3].equals(yellow))) {
                    System.out.println("Player 2  wins! (Upward Diagonal)");
                    return false;
                }
            }
        }

        return true;
    }

    //checks if the array column is empty or not
    public int emptyCheck(String[][] board, String red, String yellow, String empty, int location) {
        for (int row = 0; row < board.length; row++) {
            if (board[0][location].equals(empty)) return 0;
            else if (board[row][location].equals(empty) && !(board[row - 1][location].equals(empty)) && row != board.length)
                return row;
            else if (!board[5][location].equals(empty)) return -1;
        }
        return -1;
    }

    //TEMPORARY
    public static void display(String[][] board) {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = board.length-1; row >= 0; row--) {
            System.out.print("|");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }
}