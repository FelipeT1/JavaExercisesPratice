import java.util.Scanner;
public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Quantos números? ");
        int quantity = teclado.nextInt();
        double[] A = new double[quantity];
        double soma = 0;
        System.out.println("Digite os valores do vetor A:");
        for(int i = 0; i < A.length; i++){
            System.out.print("Digite um número: ");
            A[i] = teclado.nextDouble();
            soma+=A[i];
        }
        soma/=A.length;
        System.out.printf("MEDIA DO VETOR = %.2f%n", soma);
        System.out.println("ELEMENTOS ABAIXO DA MEDIA: ");
        for(int i = 0; i < A.length; i++){
            if(A[i] < soma){
                System.out.println(A[i]);
            }
        }
    }
}