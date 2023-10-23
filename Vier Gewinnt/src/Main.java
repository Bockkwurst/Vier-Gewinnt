import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '}};

        //Hier können die Spieler ihre Namen eingeben//
        System.out.println("Spieler 1 Name: ");
        String playerOneName = scanner.nextLine();
        System.out.println("Spieler 2 Name: ");
        String playerTwoName = scanner.nextLine();

        printBoard(board);

        while (true){
            playerOneMove(board, scanner, 'X', playerOneName);
            if (isGameFinished(board, playerOneName, playerTwoName) == true){
                break;
            }
            printBoard(board);

            playerTwoMove(board, scanner, 'O', playerTwoName);
            if (isGameFinished(board, playerOneName, playerTwoName) == true) {
                break;
            }
            printBoard(board);
        }
        scanner.close();

    }
    private static void playerOneMove(char[][] board, Scanner scanner, char symbol, String playerOneName) {
        String userInput;
        while (true) {
            System.out.println(playerOneName + " ist am Zug\nWo willst du setzen?");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)){
                break;
            } else {
                System.out.println("Ungültige Eingabe.");
            }
        }
        placeMove(board, userInput, 'X');
    }
    private static void playerTwoMove(char[][] board, Scanner scanner, char symbol, String playerTwoName) {
        String userInput;
        while (true) {
            System.out.println(playerTwoName + " ist am Zug\nWo willst du setzen?");
            userInput = scanner.nextLine();
            if (isValidMove(board, userInput)){
                break;
            } else {
                System.out.println("Ungültige Eingabe.");
            }
        }
        placeMove(board, userInput, 'O');
    }
    private static void printBoard(char[][] board){
        System.out.println("+-+-+-+-+-+-+-+");
        System.out.println("|" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|" + board[0][3] + "|" + board[0][4] + "|" + board[0][5] + "|" + board[0][6] + "|");
        System.out.println("+-+-+-+-+-+-+-+");
        System.out.println("|" + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|" + board[1][3] + "|" + board[1][4] + "|" + board[1][5] + "|" + board[1][6] + "|");
        System.out.println("+-+-+-+-+-+-+-+");
        System.out.println("|" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|" + board[2][3] + "|" + board[2][4] + "|" + board[2][5] + "|" + board[2][6] + "|");
        System.out.println("+-+-+-+-+-+-+-+");
        System.out.println("|" + board[3][0] + "|" + board[3][1] + "|" + board[3][2] + "|" + board[3][3] + "|" + board[3][4] + "|" + board[3][5] + "|" + board[3][6] + "|");
        System.out.println("+-+-+-+-+-+-+-+");
        System.out.println("|" + board[4][0] + "|" + board[4][1] + "|" + board[4][2] + "|" + board[4][3] + "|" + board[4][4] + "|" + board[4][5] + "|" + board[4][6] + "|");
        System.out.println("+-+-+-+-+-+-+-+");
        System.out.println("|" + board[5][0] + "|" + board[5][1] + "|" + board[5][2] + "|" + board[5][3] + "|" + board[5][4] + "|" + board[5][5] + "|" + board[5][6] + "|");
        System.out.println("+-+-+-+-+-+-+-+");
    }

    private static void placeMove(char[][] board, String position, char symbol){
        int col;
        switch (position){
            case "1":
                col = 0;
                break;
            case "2":
                col = 1;
                break;
            case "3":
                col = 2;
                break;
            case "4":
                col = 3;
                break;
            case "5":
                col = 4;
                break;
            case "6":
                col = 5;
                break;
            case "7":
                col = 6;
                break;
            default:
                System.out.println(":(");
                return;
        }
        for (int row = 5; row >= 0; row--){
            if (board[row][col] == ' '){
                board[row][col] = symbol;
                return;
            }
        }
        System.out.println("Diese Reihe ist bereit voll!");
    }
    private static boolean isValidMove(char[][]board, String position) {
        switch (position) {
            case "1":
                return (board[5][0] == ' ' || board[4][0] == ' ' || board[3][0] == ' ' || board[2][0] == ' ' || board[1][0] == ' ' || board[0][0] == ' ');
            case "2":
                return (board[5][1] == ' ' || board[4][1] == ' ' || board[3][1] == ' ' || board[2][1] == ' ' || board[1][1] == ' ' || board[0][1] == ' ');
            case "3":
                return (board[5][2] == ' ' || board[4][2] == ' ' || board[3][2] == ' ' || board[2][2] == ' ' || board[1][2] == ' ' || board[0][2] == ' ');
            case "4":
                return (board[5][3] == ' ' || board[4][3] == ' ' || board[3][3] == ' ' || board[2][3] == ' ' || board[1][3] == ' ' || board[0][3] == ' ');
            case "5":
                return (board[5][4] == ' ' || board[4][4] == ' ' || board[3][4] == ' ' || board[2][4] == ' ' || board[1][4] == ' ' || board[0][4] == ' ');
            case "6":
                return (board[5][5] == ' ' || board[4][5] == ' ' || board[3][5] == ' ' || board[2][5] == ' ' || board[1][5] == ' ' || board[0][5] == ' ');
            case "7":
                return (board[5][6] == ' ' || board[4][6] == ' ' || board[3][6] == ' ' || board[2][6] == ' ' || board[1][6] == ' ' || board[0][6] == ' ');
            default:
                return false;
        }
    }
    private static boolean isGameFinished(char[][] board, String playerOneName, String playerTwoName){
        if (wins(board, 'X')){
            printBoard(board);
            System.out.println(playerOneName + " hat gewonnen!");
            return true;
        } else if (wins(board , 'O')){
            printBoard(board);
            System.out.println(playerTwoName + " hat gewonnen!");
            return true;
        }
        for (int row = 0; row <6; row++){
            for (int col = 0; col <7; col++){
                if (board[row][col] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Unentschieden!");
        return true;
    }
    private static boolean wins(char[][] board, char symbol){
        for (int row = 0; row <6; row++){
            for (int col = 0; col <4; col++){
                if (board[row][col] == symbol &&
                        board[row][col+1] == symbol &&
                        board[row][col +2] == symbol &&
                        board[row][col+3] == symbol){
                    return true;
                }
            }
        }
        for (int col = 0; col < 7; col++){
            for (int row = 0; row < 3; row++){
                if (board[row][col] == symbol &&
                        board[row +1][col] == symbol &&
                        board[row+2][col] == symbol &&
                        board[row+3][col] == symbol){
                    return true;
                }
            }
        }
        return false;
    }
}