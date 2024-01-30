
// 6.25

public class Main {
    public static void main(String[] args) {
        int contador = 0;

        System.out.println(isPrimo(181));
        System.out.println(isPrimeNumber(181));

//        for(int i =1; i<=10000; i++){
//            if(isPrimeNumber(i)){
//                contador++;
//                System.out.print("NUMERO PRIMO "+ i);
//                System.out.println();
//            }
//        }
//        System.out.println("QUANTIDADE DE PRIMOS " + contador);

    }

    public static boolean isPrimo(int n) {
        int numerosTestados = 0;
        if (n <= 1) {
            return false;
        }

        // Loop até a raiz quadrada de n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            numerosTestados++;
            if (n % i == 0) {
                System.out.println("NUMEROS TESTADOS " + numerosTestados);
                // Encontrou um divisor, não é primo
                return false;
            }
        }
        System.out.println("NUMEROS TESTADOS " + numerosTestados);
        // Se nenhum divisor foi encontrado, é primo
        return true;
    }

    public static boolean isPrimeNumber(int number){
        boolean isPrimeNum = false;
        int contador = 0,
        numerosTestados = 0;

        for(int n = 1; n <= number; n++){
            if((number % n) == 0){
                numerosTestados++;

               if(n != number || n == number){
                   contador++;
               }
            }
        }
        System.out.println("NUMEROS TESTADOS " + numerosTestados);
        if(contador == 2){
            isPrimeNum = true;
        }
        return isPrimeNum;
    }
}