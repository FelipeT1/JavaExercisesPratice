//7.22
// RESOLVE LETRA A E B

import java.util.ArrayList;

public class Main {
    private final static int LADO = 8;
    private static int[][] board = new int[LADO][LADO];
    private static int[] horizontal = {2 , 1, -1, -2, -2, -1, 1, 2};
    private static int[] vertical   = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static int currentRow = 0;
    private static int currentColum = 0;
    private static int[][] accessibilidadeHeuristica =

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
        //SecureRandom movement = new SecureRandom();
        int contador = 1;
        //Scanner teclado = new Scanner(System.in);
        int moveNumber;
        do{
            atualizaTabuleiro(contador);
            moveNumber = identificaMenorAcessibilidadeComCriterioDesempate(movimentosPossiveisDoQuadradoAtual());
            moveCavalo(moveNumber);
            contador++;
            //printBoard(board);
            //System.out.println();
        }while(contador < 64);
        atualizaTabuleiro(64);
//        do{
//            //System.out.print("ENTRE O TIPO DO MOVIMENTO 0-7 ");
//            //moveNumber = teclado.nextInt();
//            if(moveNumber==-1){
//                break;
//            }
//            System.out.printf("POS ATUAL\t %d COL ATUAL\t %d%n ", currentRow, currentColum);
//            if(checaMovimento(moveNumber)){
//                moveCavalo(moveNumber, contador);
//                contador++;
//            }
//            else{
//                System.out.print("MOVIMENTO INVÁLIDO, TENTE OUTRO. ");
//            }
//        }while(true);
        printBoard(board);
        System.out.println("FIM!");
    }

    public static void atualizaAcessibilidade(){
        ArrayList<Integer> movimentos = new ArrayList<>();
        movimentos = movimentosPossiveisDoQuadradoAtual();
        for(int i = 0; i < movimentos.size(); i++){
            accessibilidadeHeuristica[currentRow+vertical[movimentos.get(i)]]
                    [currentColum+horizontal[movimentos.get(i)]]--;
        }

    }

    public static int identificaMenorAcessibilidadeSemCriterioDesempate(ArrayList<Integer> movimentosPossiveis) {
        int moveNumber = 8;
        int menorAcessibilidade = 10;
        for (int i = 0; i < movimentosPossiveis.size(); i++) {
            int movimento = movimentosPossiveis.get(i);
            int acessibilidade = accessibilidadeHeuristica[currentRow + vertical[movimento]]
                    [currentColum + horizontal[movimento]];
            if (acessibilidade < menorAcessibilidade) {
                menorAcessibilidade = acessibilidade;
                moveNumber = movimento;
            }
        }
        return moveNumber;
    }
    public static int identificaMenorAcessibilidadeComCriterioDesempate(ArrayList<Integer> movimentosPossiveis) {
        int moveNumber = 8;
        int menorAcessibilidade = 10;
        for (int i = 0; i < movimentosPossiveis.size(); i++) {
            int movimento = movimentosPossiveis.get(i);
            int acessibilidade = accessibilidadeHeuristica[currentRow + vertical[movimento]][currentColum + horizontal[movimento]];
            if (acessibilidade < menorAcessibilidade) {
                menorAcessibilidade = acessibilidade;
                moveNumber = movimento;
            }
            else if (acessibilidade == menorAcessibilidade) {
                // Em caso de empate, escolher o movimento cujo próximo quadrado tem menor acessibilidade
                int proximaRow = currentRow + vertical[movimento];
                int proximaCol = currentColum + horizontal[movimento];

                int acessibilidadeProximo = accessibilidadeHeuristica[proximaRow][proximaCol];

                if (acessibilidadeProximo < accessibilidadeHeuristica[currentRow + vertical[moveNumber]][currentColum + horizontal[moveNumber]]) {
                    moveNumber = movimento;
                }
//            else if(acessibilidade == menorAcessibilidade){
//                int novaLinha = currentRow + vertical[movimento];
//                int novaColuna = currentColum + horizontal[movimento];
//                int acessibilidadeDepoisDoMovimentoAtual = accessibilidadeHeuristica[novaLinha + vertical[movimento]][novaColuna + horizontal[movimento]];
//                int c = movimentosPossiveis.indexOf(menorAcessibilidade);
//                if(antigo < acessibilidade){
//                    menorAcessibilidade = antigo;
//                    moveNumber = movimentosPossiveis.get(c);
//                }
//                else{
//                    menorAcessibilidade = novo;
//                    moveNumber = movimento;
//                }
//            }
        }
        }
        return moveNumber;
    }
    public static ArrayList<Integer> movimentosPossiveisDoQuadradoAtual(){
        ArrayList<Integer> movimentosPossiveisDoQuadradoAtual = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            if(checaMovimentoValido(i)){
                movimentosPossiveisDoQuadradoAtual.add(i);
            }
        }
        return movimentosPossiveisDoQuadradoAtual;
    }

    public static void printBoard(int[][] board){
        for(int i = 0; i< board.length; i++){
            for(int c = 0; c < board[i].length; c++){
                System.out.printf("%d\t", board[i][c]);
            }
            System.out.println();
        }
    }
    public static void atualizaTabuleiro(int contador){
        board[currentRow][currentColum] = contador;
    }

    public static void moveCavalo(int moveNumber){
        currentColum += horizontal[moveNumber];
        currentRow += vertical[moveNumber];
        accessibilidadeHeuristica[currentRow][currentColum] = -1;
        atualizaAcessibilidade();
//        System.out.printf("========================    %d   ================================\n", contador);
//        System.out.printf("LINHA ATUAL\t%d%nCOLUN ATUAL\t%d%n", currentRow, currentColum);
//        System.out.printf("========================    %d   ================================\n", contador);
    }

    public static boolean checaMovimentoValido(int moveNumber){
        if(currentColum + horizontal[moveNumber] < 0 || currentRow + vertical[moveNumber] < 0){
            return false;
        }
        else if(currentColum + horizontal[moveNumber] > 7 || currentRow + vertical[moveNumber] > 7){
            return false;
        }
        else if(board[currentRow+vertical[moveNumber]][currentColum+horizontal[moveNumber]] != 0){
            return false;
        }
        return true;
    }

}
