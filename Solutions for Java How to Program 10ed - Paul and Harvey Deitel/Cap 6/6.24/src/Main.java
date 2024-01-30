
//6.24
public class Main {
    public static void main(String[] args) {

        for(int n = 1; n<=1000; n++){
            if(isPerfectNumber(n)){
                System.out.println("O NUMERO " + n + " E PERFEITO");
            }
        }
    }

    public static boolean isPerfectNumber(int num){
        int divisor = 2, numero = 0;
        boolean isPerfect = false;
        for(int n = 1; n < num; n++){
            if((num % n) == 0){
                numero+=n;
            }
        }
        if(numero == num){
            isPerfect = true;
        }

        return isPerfect;
    }
}
