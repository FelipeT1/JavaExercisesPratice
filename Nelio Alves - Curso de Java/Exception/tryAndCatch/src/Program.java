import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try{
            String[] vect = teclado.nextLine().split(" ");
            int position = teclado.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position");
            System.out.println(e);
        }
        catch (InputMismatchException e){
            System.out.println("Digite o indice");
            System.out.println(e);
        }
        teclado.close();
    }
}
