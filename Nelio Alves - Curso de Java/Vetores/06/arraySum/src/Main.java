import java.util.Scanner;
public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Quantos números? ");
        int quantity = teclado.nextInt();
        int[] A = new int[quantity];
        int[] B = new int[quantity];
        System.out.println("Digite os valores do vetor A:");
        for(int i = 0; i < A.length; i++){
            System.out.print("Digite um número: ");
            A[i] = teclado.nextInt();
        }
        System.out.println("Digite os valores do vetor B:");
        for(int i = 0; i < B.length; i++){
            System.out.print("Digite um número: ");
            B[i] = teclado.nextInt();
        }
        int[] C = new int[quantity];
        System.out.println("VETOR RESULTANTE: ");
        for(int i = 0; i < B.length; i++){
            C[i] = A[i] + B[i];
            System.out.println(C[i]);
        }
    }
}