import java.util.Scanner;
public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Quantos números? ");
        int quantity = teclado.nextInt();
        double[] A = new double[quantity];
        double soma = 0;
        boolean temPar = false;
        int qauntidadeDePares = 0;
        System.out.println("Digite os valores do vetor A:");
        for(int i = 0; i < A.length; i++){
            System.out.print("Digite um número: ");
            A[i] = teclado.nextDouble();
            if(A[i]%2==0){
                soma+=A[i];
                temPar = true;
                qauntidadeDePares++;
            }
        }
        if(temPar){
            soma/=qauntidadeDePares;
            System.out.printf("MEDIA DOS PARES = %.1f%n", soma);
        }
        else{
            System.out.println("NENHUM NUMERO PAR");
        }


    }
}