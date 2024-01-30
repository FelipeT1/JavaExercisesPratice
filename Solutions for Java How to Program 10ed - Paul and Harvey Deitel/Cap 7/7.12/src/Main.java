import java.util.Scanner;
//7.12
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            System.out.println();
            System.out.print("Enter an integer between 10 and 100: ");
            array[i] = scanner.nextInt();

            displayEliminatingDuplicates(array, i);
        }

        scanner.close();
    }

    public static void displayEliminatingDuplicates(int[] array, int indice) {

        for(int i = 0; i <= indice; i++){
            boolean duplicado = true;
            for(int j = i+1; j <= indice; j++){

                if(array[i] == array[j]){

                    duplicado = false;
                }
            }
            if(duplicado){
                System.out.printf("%d ", array[i]);
            }
        }

    }
}