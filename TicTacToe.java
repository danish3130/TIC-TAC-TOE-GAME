import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };
        boolean playerX = true;
        int moves = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard(board);

            if (playerX) {
                int row, col;
                do {
                    System.out.println("Your turn. Enter row (0-2) and column (0-2): ");
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');

                board[row][col] = 'X';
            } else {
                makeComputerMove(board);
            }

            moves++;

            if (checkWin(board, playerX)) {
                printBoard(board);
                if (playerX) {
                    System.out.println("Congratulations you win!");
                } else {
                    System.out.println("Computer wins!");
                }
                break;
            } else if (moves == 9) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            playerX = !playerX;
        }

        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static boolean checkWin(char[][] board, boolean playerX) {
        char symbol = playerX ? 'X' : 'O';
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }

        if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }

        return false;
    }

    public static void makeComputerMove(char[][] board) {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != ' ');
        board[row][col] = 'O';
        System.out.println("Computer O's move: Row " + row + ", Column " + col);
    }
}
