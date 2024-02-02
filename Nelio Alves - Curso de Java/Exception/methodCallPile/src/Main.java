import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A pilha é uma estrutura de dados onde o primeiro a entrar é o último a sair
 * Podemos ver isso a partir da excessão, com o printStackTrace.
 */
public class Main {
    public static void main(String[] args) {
        method2();
        System.out.println("Fim");
    }
    public static void method2(){
        System.out.println("METHOD 2 STARTED");
        method();
        System.out.println("MEHTOD 2 ENEDED");
    }
    public static void method(){
        System.out.println("METHOD STARTED");
        Scanner teclado = new Scanner(System.in);
        try{
            String[] vect = teclado.nextLine().split(" ");
            int position = teclado.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position");
            // toda chamada de método que causou ela
            e.printStackTrace();
            teclado.next();
        }
        catch (InputMismatchException e){
            System.out.println("Digite o indice");
            System.out.println(e);
        }
        teclado.close();
        System.out.println("MEHTOD ENEDED");
    }
}
