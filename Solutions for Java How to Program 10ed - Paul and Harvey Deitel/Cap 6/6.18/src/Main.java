// exercicio 6.18


public class Main {
    public static void main(String[] args) {

        System.out.printf("%.2f", calculateCharges(7));

    }

    public static double calculateCharges(int hora){
        double taxaTotal = 0;


        for(int i =1; i<=hora; i++){
            if( i > 3){
                taxaTotal+=0.5;
            }
            taxaTotal+=2.0;

            if(taxaTotal > 10){
                taxaTotal = 10.0;
                break;
            }
        }
        return taxaTotal;
    }

}