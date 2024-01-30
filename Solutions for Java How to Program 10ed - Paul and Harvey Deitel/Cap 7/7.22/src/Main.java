//7.22d
import java.util.ArrayList;

public class Main {
    private final static int SIZE = 8;
    private static int[][] board = new int[SIZE][SIZE];
    private static int[] horizontal = {2 , 1, -1, -2, -2, -1, 1, 2};
    private static int[] vertical   = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int currentRow = 0;
    private static int currentColum = 0;
    private static int[][] heuristicAccessibility =

            {
                    {2, 3, 4, 4, 4, 4, 3, 2},
                    {3, 4, 6, 6, 6, 6, 4, 3},
                    {4, 6, 8, 8, 8, 8, 6, 4},
                    {4, 6, 8, 8, 8, 8, 6, 4},
                    {4, 6, 8, 8, 8, 8, 6, 4},
                    {4, 6, 8, 8, 8, 8, 6, 4},
                    {3, 4, 6, 6, 6, 6, 4, 3},
                    {2, 3, 4, 4, 4, 4, 3, 2}
            };

    public static void main(String[] args) {
        int counter = 1;
        int moveNumber = 0;
        do{
            moveNumber = findLowestAccessibility(possibleMovementsInTheCurrentSquare());
            moveKnight(moveNumber, counter);
            counter++;
        }while(counter < 64);
        printBoard(board);
    }
/*
Moves the knight
 */
    public static void moveKnight(int moveNumber, int counter){
        board[currentRow][currentColum] = counter;
        currentRow += vertical[moveNumber];
        currentColum += horizontal[moveNumber];
        lowerTheAccessibility(possibleMovementsInTheCurrentSquare());
    }
/*
Lower the Accessibility because since one square is occupied all the others possible squares have one less accessible square
 */
    public static void lowerTheAccessibility(ArrayList<Integer> possibleMovements){
        for(int i = 0; i < possibleMovements.size(); i++){
            heuristicAccessibility[currentRow+vertical[possibleMovements.get(i)]][currentColum+horizontal[possibleMovements.get(i)]]--;
        }
    }
/*
Given the possible movements find the one that has the lowest accessibility. In case of a draw chooses the one that has a successor with the lower accessibility
 */
    public static int findLowestAccessibility(ArrayList<Integer> possibleMovements){
        //I chose 8 because in failed versions of the code it would trigger an arrayoutofbounds, right now you can choose any number
        int moveNumber = 8;
        //Initialize with a high number so the condition will always be true for the first time. I chose 10 because yes, it could be any number,
        // given number > 8 (because remember Accessibility numbers)
        int lowestAccessibility = 10;
        for(int i = 0; i < possibleMovements.size(); i++){
            int currentAccessibility = heuristicAccessibility[currentRow+vertical[possibleMovements.get(i)]][currentColum+horizontal[possibleMovements.get(i)]];
            if(currentAccessibility < lowestAccessibility){
                lowestAccessibility = currentAccessibility;
                moveNumber = possibleMovements.get(i);
            }
            else if(currentAccessibility == lowestAccessibility){
                int newRow = currentRow + vertical[possibleMovements.get(i)];
                int newColum = currentColum + horizontal[possibleMovements.get(i)];
                int nextAccessibility = heuristicAccessibility[newRow][newColum];
                if(nextAccessibility < heuristicAccessibility[currentRow+vertical[moveNumber]][currentColum+horizontal[moveNumber]]){
                    lowestAccessibility = nextAccessibility;
                    moveNumber = possibleMovements.get(i);
                }
            }
        }
        return moveNumber;
    }
/*
Checks all possible movements in the current position and stores it in a integer list
 */
    public static ArrayList<Integer> possibleMovementsInTheCurrentSquare(){
        ArrayList<Integer> possibleMovements = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            if(isMovementValid(i)){
                possibleMovements.add(i);
            }
        }
        return possibleMovements;
    }
/*
Checks if the movement number has a valid movement in the board.
 */
    public static boolean isMovementValid(int moveNumber){
        if((currentRow + vertical[moveNumber]) < 0
                || (currentColum + horizontal[moveNumber]) < 0
                || (currentRow + vertical[moveNumber]) > 7
                || (currentColum + horizontal[moveNumber]) > 7
                || (board[currentRow+vertical[moveNumber]][currentColum+horizontal[moveNumber]]) != 0){
            return false;
        }
        return true;
    }
/*
Prints the board
 */
    public static void printBoard(int[][] board){
        for(int i = 0; i< board.length; i++){
            for(int c = 0; c < board[i].length; c++){
                System.out.printf("%d\t", board[i][c]);
            }
            System.out.println();
        }
    }
}
