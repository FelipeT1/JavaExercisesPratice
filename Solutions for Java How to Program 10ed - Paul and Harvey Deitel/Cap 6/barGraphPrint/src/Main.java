import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        for(int i = 1; i<=5; i++){

            int numero = teclado.nextInt();
            System.out.printf(" %d = ", numero);
            printAster(numero);
        }
        teclado.close();
    }

    public static void printAster(int numero){
        for(int i = 1; i <= numero; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}

