import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("QUANTAS MATRIZES GOSTARIA DE SABER A DIAGONAL E VALORES NEGATIVOS? ");
        int quantidadeDeMatrizes = teclado.nextInt();
        List<Matriz> lista = new ArrayList<>();

        for(int i = 0; i < quantidadeDeMatrizes; i++){
            System.out.printf("DIGITE O TAMANHO DA MATRIZ #%d ", i+1);
            int tamanho = teclado.nextInt();
            Matriz matriz = new Matriz(tamanho);
            lista.add(matriz);

            int[][] matrix = preencheMatriz(teclado,lista,i,tamanho);
            diagonalPrincipal(matrix);
            quantidadeNegativoNaMatrix(matrix);
        }
        teclado.close();
    }
    public static void quantidadeNegativoNaMatrix(int[][] matrix){
        int quantidade = 0;
        for(int[] matriz : matrix){
            for(int m : matriz){
                if(m < 0){
                    quantidade++;
                }
            }
        }
        System.out.print("NÚMEROS NEGATIVOS = ");
        System.out.printf("%d%n", quantidade);
    }
    public static void diagonalPrincipal(int[][] matrix){
        List<Integer> diagonalprincipal = new ArrayList<>();
        int c = 0;
        for(int i = 0; i < matrix.length; i++){
            diagonalprincipal.add(matrix[i][c]);
            c++;
        }
        System.out.println("DIAGONAL PRINCIPAL: ");
        for(Integer i : diagonalprincipal){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static int[][] preencheMatriz(Scanner teclado, List<Matriz> lista, int qualMatriz, int tamanho){
        int[][] matrix = new int[tamanho][tamanho];
        for(int i = 0; i < tamanho; i++){
            for(int c = 0; c < tamanho; c++){
                matrix[i][c] = teclado.nextInt();
            }
        }
        lista.get(qualMatriz).setMatriz(matrix);
        return matrix;
    }
}