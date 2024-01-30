import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Quantos números? ");
        int quantity = teclado.nextInt();
        int[] numbers = new int[quantity];
        for(int i = 0; i < numbers.length; i++){
            System.out.print("Digite um número: ");
            numbers[i] = teclado.nextInt();
        }
        int oddQuantity = 0;
        System.out.print("NUMEROS PARES ");
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % 2 == 0){
                oddQuantity++;
                System.out.printf("%d %n", numbers[i]);
            }
        }
        System.out.printf("QUANTIDADE DE PARES %d", oddQuantity);
    }
}