import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Informe a quantidade de números ");
        int quantidade = teclado.nextInt();
        double[] reais = new double[quantidade];
        fillElements(reais);
        printElements(reais);
        sumElements(reais);
        averageElements(reais);
    }
    public static  void fillElements(double[] array){
        for(int i =0; i < array.length; i++){
            array[i] = teclado.nextInt();
        }
    }
    public static void printElements(double[] array){
        System.out.print("VALORES ");
        for(int i = 0; i < array.length; i++){
            System.out.printf("%.1f ", array[i]);
        }
        System.out.println();
    }
    public static void sumElements(double[] array){
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        System.out.printf("SOMA = %.2f", sum);
        System.out.println();
    }
    public static void averageElements(double[] array){
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        sum /= array.length;
        System.out.printf("MEDIA = %.2f", sum);
    }
}