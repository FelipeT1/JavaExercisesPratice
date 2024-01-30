import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("How many rooms will be rented? ");
        int quantidade = teclado.nextInt();
        String[] quartos = new String[10];
        String[] emails = new String[10];
        int quarto = 0;
        for(int i = 0; i < quantidade; i++){
            System.out.printf("RENT #%d%n",i+1);
            System.out.print("Room: ");
            quarto = teclado.nextInt();
            System.out.print("Name: ");
            quartos[quarto-1] = teclado.next();
            System.out.print("Email: ");
            emails[quarto-1] = teclado.next();

        }
        System.out.println("BUSY ROOMS");
        for(int i = 0; i < quartos.length; i++){
            if(quartos[i] != null){
                System.out.printf("%d: %s, %s %n",i+1,quartos[i],emails[i]);
            }
        }
    }
}