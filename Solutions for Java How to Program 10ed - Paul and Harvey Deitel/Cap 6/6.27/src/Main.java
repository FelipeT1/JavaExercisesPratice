//6.27

public class Main {
    public static void main(String[] args) {

       // System.out.println(gCdEuclidesMethod(252,105));
        System.out.println(calcularMDC(7,2));

    }

    public static int calcularMDC(int a, int b) {
        int maiorNumero, menorNumero;

        if (a > b) {
            maiorNumero = a;
            menorNumero = b;
        } else {
            maiorNumero = b;
            menorNumero = a;
        }

        while (menorNumero != 0) {
            int resto = maiorNumero % menorNumero;
            maiorNumero = menorNumero;
            menorNumero = resto;
        }

        return maiorNumero;
    }


    public static int gCdEuclidesMethod(int a, int b){
        int maior, meio, menor;

        if(a>b){
            maior = a;
            menor = b;
        }
        else{
            maior = b;
            menor = a;
        }
        do{
            if((maior-menor) < menor){
                meio = menor;
                menor = (maior-menor);
                maior = meio;
            }
            else{
                maior = (maior-menor);
            }
        } while(maior != menor);


        return maior;
    }
}