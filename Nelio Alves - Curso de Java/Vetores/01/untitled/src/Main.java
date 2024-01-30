
import java.util.Scanner;
public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Quantos números serão inseridos? ");
        int quantidade = teclado.nextInt();
        int[] numerosInseridos = new int[quantidade];
        printsTheNegativeNumbers(
                fillsTheNumbersInArray(numerosInseridos)
        );
    }
    public static int[] fillsTheNumbersInArray(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = teclado.nextInt();
        }
        return numbers;
    }
    public static void printsTheNegativeNumbers(int[] numbers){
        int quantity = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < 0){
                quantity++;
                System.out.printf("Neg number %d\n", numbers[i]);
            }
        }
        System.out.printf("Neg number quantity = %d", quantity);
    }
}