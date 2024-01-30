//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//6.13

import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        SecureRandom numeroAleatorio = new SecureRandom();
        int numero;
        double n = 3;
        for(int i = 1; i <= 20; i++){
            numero = numeroAleatorio.nextInt(19) + 4;
            while(true){
                if(numero % 2 == 0){
                    if((numero / n) == 2){
                        System.out.print(numero +" " );
                        n = 3;
                        break;
                    }
                    else {
                        if(n >= 11){
                            i-=1;
                            n = 3;
                            break;
                        }
                        n+=2;
                    }
                }
                else{
                    i-=1;
                    break;
                }
            }
        }
    }
}