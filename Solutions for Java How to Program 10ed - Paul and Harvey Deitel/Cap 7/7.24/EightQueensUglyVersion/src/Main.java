public class Main {
    private static final int SIZE = 8;
    private static int[][] board = new int[SIZE][SIZE];
    private static int[][] heuristic = new int[SIZE][SIZE];

    public static void main(String[] args) {
        int queens = 1;
        boolean isPlaceQueen = false;
        int[] rowAndColum = {0,5};
        placeQueen(rowAndColum,board);
        fillsHeuristicTable(isPlaceQueen, board);
        while(queens < SIZE){
            placeQueen(findsLowestHeuristicPosition(board), board);
            clearHeuristic();
            fillsHeuristicTable(false, board);
            queens++;
        }
        printBoard();
    }
    public static void placeQueen(int[] rowAndColum, int[][] board){
        // Place queen at the lowest heuristic number
        int row = rowAndColum[0];
        int col = rowAndColum[1];
        quantidadeDeQuadradosOcupados(row, col, true, board);
        board[row][col] = 90;
    }
    // acha o primeiro menor valor de quadrados eliminados dada uma posição na  matriz
    public static int[] findsLowestHeuristicPosition(int[][] board){
        int[] rowAndCol = new int[3];
        int lowestvalue = 22;
        //Find lowest in row
        for(int row = 0; row < heuristic.length; row++ ){
            for(int col = 0; col < heuristic[row].length; col++){
                if(isQueenMovementValid(row, col, board)){
                    //Acha o menor valor da linha
                    if(heuristic[row][col] != 0){
                        if(heuristic[row][col] < lowestvalue){
                            lowestvalue = heuristic[row][col];
                            rowAndCol[0] = row;
                            rowAndCol[1] = col;
                        }
                    }
                }
            }
        }
        return rowAndCol;
    }

    // inicializa a matriz com os valores de quantas casas cada posição ameaça
    private static void fillsHeuristicTable(boolean isPlaceQueen, int[][] board) {
        //Fills heuristic table
        for(int row = 0; row < heuristic.length; row++ ){
            for(int colum = 0; colum < heuristic[row].length; colum++){
                if(isQueenMovementValid(row, colum, board)){
                    heuristic[row][colum] = quantidadeDeQuadradosOcupados(row, colum, isPlaceQueen, board);
                }
            }
        }
    }
    public static void printBoard(){
        for(int i = 0; i< board.length; i++){
            for(int c = 0; c< board.length; c++){
                System.out.printf("%d\t", board[i][c]);
            }
            System.out.println();
        }
    }
    public static int quantidadeDeQuadradosOcupados(int currentRow, int currentColum, boolean isPlaceQueen, int[][] board){
        int quantidadeDeQuadrados = 0;
        quantidadeDeQuadrados += checkVertical(currentColum, isPlaceQueen, board);
        quantidadeDeQuadrados += checkHorizontal(currentRow, isPlaceQueen, board);
        quantidadeDeQuadrados += checkUpperDiagonal(currentRow, currentColum, isPlaceQueen, board);
        quantidadeDeQuadrados += checkLowerDiagonal(currentRow, currentColum, isPlaceQueen, board);
        // -3 porque devido a como as funções foram feitas o mesmo quadrado será contado 3 vezes a mais do que deveria
        return quantidadeDeQuadrados-3;
    }
    public static boolean isQueenMovementValid(int currentRow, int currentColum, int[][] board){
        return board[currentRow][currentColum] == 0;
    }
    public static void printHeuristic(){
        for(int i = 0; i< heuristic.length; i++){
            for(int c = 0; c< heuristic[i].length; c++){
                System.out.printf("%d\t", heuristic[i][c]);
            }
            System.out.println();
        }
    }
    private static void clearHeuristic() {
        for(int row = 0; row < board.length; row++ ){
            for(int colum = 0; colum < board[row].length; colum++){
                heuristic[row][colum] = 0;
            }
        }
    }
    private static int checkVertical(int currentColum, boolean isPlaceQueen, int[][] board) {
        int quantidadeDeQuadrados = 0;
        //Vertical check
        for(int i = 0; i < board.length; i++){
            if(isQueenMovementValid(i, currentColum, board)){
                quantidadeDeQuadrados++;
                if(isPlaceQueen){
                    board[i][currentColum] = 1;
                }
            }
        }
        return quantidadeDeQuadrados;
    }
    private static int checkHorizontal(int currentRow, boolean isPlaceQueen, int[][] board) {
        int quantidadeDeQuadrados = 0;
        //Horizontal check
        for(int i = 0; i < board.length; i++){
            if(isQueenMovementValid(currentRow,i,board)){
                quantidadeDeQuadrados++;
                if(isPlaceQueen){
                board[currentRow][i] = 1;
                }
            }
        }
        return quantidadeDeQuadrados;
    }
    private static int checkUpperDiagonal(int currentRow, int currentColum, boolean isPlaceQueen, int[][] board) {
        int quantidadeDeQuadrados = 0;
        if(currentRow > currentColum){
            int cRow = currentRow - currentColum;
            int cColum = 0;
            for(int i = cRow; i < board.length; i++){
                if(isQueenMovementValid(i, cColum, board)){
                    quantidadeDeQuadrados++;
                    if(isPlaceQueen){
                        board[i][cColum] = 1;
                    }
                }
                cColum++;
                if(cColum > SIZE-1){
                    break;
                }
            }
        }
        else{
            int cRow = 0;
            int cColum = currentColum - currentRow;
            for(int i = cRow; i < board.length; i++){
                if(isQueenMovementValid(i, cColum,board)){
                    quantidadeDeQuadrados++;
                    if(isPlaceQueen){
                        board[i][cColum] = 1;
                    }
                }
                cColum++;
                if(cColum > SIZE-1){
                    break;
                }
            }
        }
        return quantidadeDeQuadrados;
    }

    private static int checkLowerDiagonal(int currentRow, int currentColum, boolean isPlaceQueen, int[][] board) {
        int quantidadeDeQuadrados = 0;
        int cRow = currentRow;
        int cColum = currentColum;
        while(true){
            if(cColum == 0 || cRow == (SIZE - 1)){
                break;
            }
            cColum--;
            cRow++;

        }
        for(int i = cRow; i >= 0; i--){
            if(isQueenMovementValid(i,cColum,board)){
                quantidadeDeQuadrados++;
                if(isPlaceQueen){
                    board[i][cColum] = 1;
                }
            }
            cColum++;
            if(cColum > SIZE-1){
                break;
            }
        }
        return quantidadeDeQuadrados;
    }
}