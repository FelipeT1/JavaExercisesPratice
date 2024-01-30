//6.26

public class Main {
    public static void main(String[] args) {
        System.out.println(invertNumber(7531812));
    }

    public static int lenghtNumber(int number){
        int numberLength = 0;
        int divisor = 10;
        while(true){

            if((number / divisor) != 0){
                number = (number/divisor);
                numberLength++;
            }
            else{
                break;
            }
        }
        return numberLength;
    }
    public static int invertNumber(int number){
        int divisor = 10;
        int numeroInvertido = 0;
        int tamanhoNumero = lenghtNumber(number);


        for(int i = 0; i<=tamanhoNumero;i++){
            numeroInvertido += (int) Math.pow(10,lenghtNumber(number)) * (number%divisor);
            number = number/divisor;
        }

        return numeroInvertido;
    }

}