// 7.24
// THIS SOLUTION VERSION WAS INSPIRED BY iRobot42 c++ version of the problem
// https://github.com/iRobot42/Deitels-Cpp-10e/blob/master/07%20-%20Class%20Templates%20array%20and%20vector.%20Catching%20Exceptions/07.24%20-%20Eight%20Queens/ex_07_24.cpp
// It does work but not for every starting position.
// There is a not intended feature(lol) about Q1 printed, because when the function to find the lowestElimination is called, it doesnt find anything because every
// square is deleted so it returns an initialized array that is [0,0] and sends to placeQueen function
// thats why it prints two Q1 sometimes
// this happens when the program cant find a place for the 8th queen, but in the position 0,5 you can find 8 queens and nothing is repeated as intended.
public class Main {
    private static final int SIZE = 8;
    private static boolean[][] board = new boolean[SIZE][SIZE];
    private static int[][] heuristicBoard = new int[SIZE][SIZE];
    private static boolean[][] eliminatedSquares = new boolean[SIZE][SIZE];
    private static int currentRow = 0;
    private static int currentCol = 5;
    public static void main(String[] args) {
        int queens = 0;
        //Coloca a posição atual no tabuleiro sem chamar função
        board[currentRow][currentCol] = true;
        while(queens < 7){
            setEliminatedSquares();
            fillsEliminationSquaresNumbers();
            placeQueen(findLowestEliminationNumber());
            queens++;
        }
        printBoard();
    }
    public static void placeQueen(int[] rowAndCol){
        currentRow = rowAndCol[0];
        currentCol = rowAndCol[1];
        board[currentRow][currentCol] = true;
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