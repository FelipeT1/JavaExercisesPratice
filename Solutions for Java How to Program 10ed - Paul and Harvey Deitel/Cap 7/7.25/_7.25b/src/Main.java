// 8 queen problem trying every position brute force

public class Main {
    private static final int SIZE = 8;
    private static boolean[][] board = new boolean[SIZE][SIZE];
    private static int solution = 0;
    public static void main(String[] args) {
        placeQueen(0);
        System.out.println(solution);
    }
    // recursive function
    // backtracking place queen
    public static boolean placeQueen(int row){
        if(row == SIZE){
            return true;
        }
        for(int col = 0; col < SIZE; col++){
            if(!isQueenBeingAttacked(row, col)){
                board[row][col] = true;
                if(placeQueen(row+1)){
                    if(row == SIZE-1){
                        printBoard();
                        System.out.println();
                        board[row][col] = false;
                    }
                    else return true;
                }
                board[row][col] = false;
            }
        }
        return false;
    }
    public static boolean isQueenBeingAttacked(int row, int col){
        if(row==0){
            return false;
        }
        //check for vertical (colum) and horizontal (row)
        for(int x = 0; x < SIZE; x++){
            if(board[row][x] || board[x][col]){
                return true;
            }
        }
        //checks diagonals
        for(int r = row, c = col; c < SIZE && r >= 0; r--, c++){
            if(board[r][c]){
                return true;
            }
        }
        for(int r = row, c = col; r >= 0 && c >= 0 ; r--, c--){
            if(board[r][c]){
                return true;
            }
        }
        return false;
    }
    // Esse método não funciona muito bem para oq estamos tentando fazer por isso vou remodelar ele.
//    public static void setEliminatedSquares(int currentRow, int currentCol, boolean clearBoard){
//        if(!clearBoard){
//            // Checks both vertical and horizontal and eliminates the attacked squares
//            for(int row = 0; row < SIZE; row++){
//                for(int col = 0; col < SIZE; col++){
//                    if(row == currentRow || col == currentCol){
//                        eliminatedSquares[row][col] = true;
//                    }
//                }
//            }
//            // Checks both diagonals
//            for(int diagonal = 1; diagonal < SIZE; diagonal++){
//                // These are all the combinations needed to find both diagonals
//                // that is (r+1,c+1), (r-1,c-1), (r+1,c-1), (r-1,c+1)
//                int rowEqual = currentRow + diagonal;
//                int colEqual = currentCol + diagonal;
//                int rowDiff = currentRow -  diagonal;
//                int colDiff = currentCol -  diagonal;
//                if(rowEqual < SIZE && colEqual < SIZE) eliminatedSquares[rowEqual][colEqual] = true;
//                if(rowDiff >= 0 && colDiff >= 0  )     eliminatedSquares[rowDiff][colDiff] = true;
//                if(rowEqual < SIZE && colDiff >= 0   ) eliminatedSquares[rowEqual][colDiff] = true;
//                if(rowDiff >= 0 && colEqual < SIZE   ) eliminatedSquares[rowDiff][colEqual] = true;
//            }
//        }
//        else{
//            for(int row = 0; row < SIZE; row++){
//                for(int col = 0; col < SIZE; col++){
//                    if(row == currentRow || col == currentCol){
//                        eliminatedSquares[row][col] = false;
//                    }
//                }
//            }
//            for(int diagonal = 1; diagonal < SIZE; diagonal++){
//                int rowEqual = currentRow + diagonal;
//                int colEqual = currentCol + diagonal;
//                int rowDiff = currentRow -  diagonal;
//                int colDiff = currentCol -  diagonal;
//                if(rowEqual < SIZE && colEqual < SIZE) eliminatedSquares[rowEqual][colEqual] = false;
//                if(rowDiff >= 0 && colDiff >= 0  )     eliminatedSquares[rowDiff][colDiff] = false;
//                if(rowEqual < SIZE && colDiff >= 0   ) eliminatedSquares[rowEqual][colDiff] = false;
//                if(rowDiff >= 0 && colEqual < SIZE   ) eliminatedSquares[rowDiff][colEqual] = false;
//            }
//        }
//    }
    public static void printBoard(){
        solution++;
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