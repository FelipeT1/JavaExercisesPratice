//6.29


import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       flipCoin(menu());

    }

    public  enum Moeda{
        CARA, COROA, VAZIO;
    }

    public static int menu(){
        System.out.print("INSIRA QUANTIDADE DE LANÇAMENTOS.\nSE FOR ZERO NÃO HÁ LANÇAMENTOS: ");
        System.out.println();
        Scanner teclado = new Scanner(System.in);
        int opcao = teclado.nextInt();
        return switch (opcao){
            case 0 -> 0;
            default -> opcao;
        };
    }

    public static Moeda flipCoin(int quantidade) {
        SecureRandom random = new SecureRandom();
        int caraCoroa;
        Moeda moeda = Moeda.VAZIO;

        if(quantidade == 0){
            System.out.println("NÃO LANÇO MOEDA");
            return moeda;
        }
        else{
            for(int i = 1; i<=quantidade; i++){
                caraCoroa =  random.nextInt(2) + 1;
                if (caraCoroa == 1){
                    moeda = Moeda.CARA;
                    System.out.println(moeda);
                }
                else{
                    moeda = Moeda.COROA;
                    System.out.println(moeda);

                }
            }
        }
        return moeda;
    }

}