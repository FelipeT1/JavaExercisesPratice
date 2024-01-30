import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Quantos números? ");
        int quantity = teclado.nextInt();
        int[] numbers = new int[quantity];
        int greaterNumber = 0;
        int greaterNumberIndex = 0;
        for(int i = 0; i < numbers.length; i++){
            System.out.print("Digite um número: ");
            numbers[i] = teclado.nextInt();
            if(numbers[i] > greaterNumber){
                greaterNumber = numbers[i];
                greaterNumberIndex = i;
            }
        }
        System.out.printf("MAIOR VALOR %d%n", greaterNumber);
        System.out.printf("POSICAO DO MAIOR VALOR %d%n", greaterNumberIndex);
    }
}