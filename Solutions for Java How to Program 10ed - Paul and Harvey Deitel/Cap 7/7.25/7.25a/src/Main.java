// 7.25a
// THIS SOLUTION VERSION WAS INSPIRED BY iRobot42 c++ version of the problem
// https://github.com/iRobot42/Deitels-Cpp-10e/blob/master/07%20-%20Class%20Templates%20array%20and%20vector.%20Catching%20Exceptions/07.24%20-%20Eight%20Queens/ex_07_24.cpp

import java.security.SecureRandom;

// 8 queen problem with random position brute force
public class Main {
    private static final int SIZE = 8;
    private static boolean[][] board = new boolean[SIZE][SIZE];
    private static int[][] heuristicBoard = new int[SIZE][SIZE];
    private static boolean[][] eliminatedSquares = new boolean[SIZE][SIZE];
    private static int currentRow = 0;
    private static int currentCol = 5;
    public static void main(String[] args) {
        if (placeQueen()) {
            printBoard();
        } else {
            System.out.print("Não achou solução");
        }
    }
    public static boolean placeQueen(){
        int queenSolution = 0;
        SecureRandom teclado = new SecureRandom();
        int row;
        int col;
        int tries = 0;
        while(tries < 900000){
            row = teclado.nextInt(8);
            col = teclado.nextInt(8);

            if(!eliminatedSquares[row][col]) {
                currentRow = row;
                currentCol = col;
                board[currentRow][currentCol] = true;
                setEliminatedSquares();
                queenSolution++;
            }
            if(queenSolution == 8){
                System.out.printf("Solução encontrada na tentativa de número %d%n", tries);
                return true;
            }
            tries++;
        }
        return false;
    }
    public static void setEliminatedSquares(){
        // Checks both vertical and horizontal and eliminates the attacked squares
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(row == currentRow || col == currentCol){
                    eliminatedSquares[row][col] = true;
                }
            }
        }
        // Checks both diagonals
        for(int diagonal = 1; diagonal < SIZE; diagonal++){
            // These are all the combinations needed to find both diagonals
            // that is (r+1,c+1), (r-1,c-1), (r+1,c-1), (r-1,c+1)
            int rowEqual = currentRow + diagonal;
            int colEqual = currentCol + diagonal;
            int rowDiff = currentRow -  diagonal;
            int colDiff = currentCol -  diagonal;
            if(rowEqual < SIZE && colEqual < SIZE) eliminatedSquares[rowEqual][colEqual] = true;
            if(rowDiff >= 0 && colDiff >= 0  )     eliminatedSquares[rowDiff][colDiff] = true;
            if(rowEqual < SIZE && colDiff >= 0   ) eliminatedSquares[rowEqual][colDiff] = true;
            if(rowDiff >= 0 && colEqual < SIZE   ) eliminatedSquares[rowDiff][colEqual] = true;
        }
    }
    public static int countEliminatedSquares(int currentRow, int currentCol){
        int squaresEliminated = 0;
        // Checks both vertical and horizontal and eliminates the attacked squares
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if((row == currentRow || col == currentCol) && !eliminatedSquares[row][col]){
                    squaresEliminated++;
                }
            }
        }
        // Checks both diagonals
        for(int diagonal = 1; diagonal < SIZE; diagonal++){
            // These are all the combinations needed to find both diagonals
            // that is (r+1,c+1), (r-1,c-1), (r+1,c-1), (r-1,c+1)
            int rowEqual = currentRow + diagonal;
            int colEqual = currentCol + diagonal;
            int rowDiff = currentRow -  diagonal;
            int colDiff = currentCol -  diagonal;
            if((rowEqual < SIZE && colEqual < SIZE)  && !eliminatedSquares[rowEqual][colEqual])  squaresEliminated++;
            if((rowDiff >= 0 && colDiff >= 0)        && !eliminatedSquares[rowDiff][colDiff])    squaresEliminated++;
            if((rowEqual < SIZE && colDiff >= 0)     && !eliminatedSquares[rowEqual][colDiff])   squaresEliminated++;
            if((rowDiff >= 0 && colEqual < SIZE)     && !eliminatedSquares[rowDiff][colEqual])    squaresEliminated++;
        }
        return squaresEliminated;
    }
    public static void fillsEliminationSquaresNumbers(){
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(!eliminatedSquares[row][col]){
                    heuristicBoard[row][col] = countEliminatedSquares(row, col);
                }
            }
        }
    }
    public static int[] findLowestEliminationNumber(){
        int minimum = 22;
        int[] rowAndCol = new int[2];
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if((heuristicBoard[row][col] < minimum) && !eliminatedSquares[row][col]){
                    minimum = heuristicBoard[row][col];
                    rowAndCol[0] = row;
                    rowAndCol[1] = col;
                }
            }
        }
        return rowAndCol;
    }
    public static void printBoard(){
        for(int row = 0; row < SIZE; row++){
            for(int col = 0; col < SIZE; col++){
                if(board[row][col]){
                    System.out.printf(" Q%d", row+1);
                }
                else{
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}