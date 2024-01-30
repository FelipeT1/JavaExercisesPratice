import java.security.SecureRandom;
/*
O ALGORITMO DE FORÇA BRUTA CERTAMENTE É MAIS FÁCIL DE SE IMPLEMENTAR,
NO ENTANTO DEPENDER DO PODER COMPUTACIONAL PODE NÃO SER SEMPRE A MELHOR ESCOLHA.

MESMO DEPOIS DE 3K+ TENTATIVAS NENHUMA SOLUÇÃO FOI ENCONTRADA, ENQUANTO COM A HEURÍSTICA O RESULTADO É ENCONTRADO
EM TODAS POSIÇÕES.
 */

public class Main {
    private final static int SIZE = 8;
    private static int[][] board = new int[SIZE][SIZE];
    private static int[] horizontal = {2 , 1, -1, -2, -2, -1, 1, 2};
    private static int[] vertical   = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int currentRow = 0;
    private static int currentColum = 0;
    private final static int A = 64;
    private final static int B = 1000;
    private static int[] result = new int[1000];
    public static void main(String[] args) {
        SecureRandom movimento = new SecureRandom();
        int moveNumber;
        int movimentoAtual = 1;
        int tentativa = 1;
        do{
            for(int i = 0; i < A; i++){
                moveNumber = movimento.nextInt(8);
                if(isMovementValid(moveNumber)){
                    board[currentRow+vertical[moveNumber]]
                            [currentColum+horizontal[moveNumber]] = movimentoAtual;
                    currentRow+=vertical[moveNumber];
                    currentColum+=horizontal[moveNumber];
                    movimentoAtual++;
                }
            }
            if(movimentoAtual != 64){
                currentRow = 0;
                currentColum = 0;
                movimentoAtual = 1;
            }
            tentativa++;
        }while(movimentoAtual != 64);
        System.out.println("PASSEIO COMPLETO NA TENTATIVA " + tentativa);

        //** FOR LETTER B
//**        for(int passeio = 0; passeio < B; passeio++){
//            for(int i = 1; i <= A; i++){
//                moveNumber = movimento.nextInt(8);
//                if(isMovementValid(moveNumber)){
//
//                    //** FOR LETTER B:
//**                  result[passeio]+=movimentoAtual;
//                  FOR LETTER A:
//                    board[currentRow+vertical[moveNumber]]
//                            [currentColum+horizontal[moveNumber]] = movimentoAtual;
//                    currentRow+=vertical[moveNumber];
//                    currentColum+=horizontal[moveNumber];
//                    movimentoAtual++;
//                }
//            }
//        }
        //** FOR LETTER B
//**        for(int i = 0; i < B; i++){
//**            System.out.println(result[i]);
//**        }
        //printBoard(board);
    }
    public static void printBoard(int[][] board){
        for(int i = 0; i< board.length; i++){
            for(int c = 0; c < board[i].length; c++){
                System.out.printf("%d\t", board[i][c]);
            }
            System.out.println();
        }
    }
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
}