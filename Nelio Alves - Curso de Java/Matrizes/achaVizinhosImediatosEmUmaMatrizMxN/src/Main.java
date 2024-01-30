import java.util.Scanner;

/***
 * Leia uma matriz MxN e leia um valor X.
 * Depois mostre todos os valores contidos na vertical(cima e baixo)
 * e horizontal(esquerda e direita) de X.
 ***/


public class Main {
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o número de linhas da matriz ");
        int linha = teclado.nextInt();
        System.out.print("Digite o número de colunas da matriz ");
        int coluna = teclado.nextInt();

        matrix = new int[linha][coluna];
        fillMatrix(teclado);
        forEachOcurrenceOfValue(teclado);
        teclado.close();
    }
    public static void fillMatrix(Scanner teclado){
        for(int i = 0; i < matrix.length; i++){
            //matrix[i].length pq queremos o tamanho do array dentro do array.
            for(int c = 0; c < matrix[i].length; c++){
                System.out.printf("Digite o valor da linha %d coluna %d ", i,c);
                matrix[i][c] = teclado.nextInt();
            }
        }
    }
    public static void forEachOcurrenceOfValue(Scanner teclado){
        System.out.print("Digite o valor a ser procurado ");
        int value = teclado.nextInt();
        for(int i = 0; i < matrix.length; i++){
            for(int c = 0; c < matrix[i].length; c++){
                if(matrix[i][c] == value){
                    System.out.printf("Position %d, %d Value %d:%n",
                            i, c, value);
                    imprimeDirecoesValidas(i,c);
                }
            }
        }
    }
    public static void imprimeDirecoesValidas(int i, int c){
        achaPosicoesVizinhas(i+1,c,"Down");
        achaPosicoesVizinhas(i-1,c,"Up");
        achaPosicoesVizinhas(i,c+1,"Right");
        achaPosicoesVizinhas(i,c-1,"Left");
    }
    public static void achaPosicoesVizinhas(int i, int c, String direcao){
        if(isMovementValid(i,c)){
            System.out.printf(" %s: %d%n", direcao, matrix[i][c]);
        }
    }
    public static boolean isMovementValid(int i, int c){
        return i>=0 && c>=0 && i < matrix.length && c < matrix[i].length;
    }
}