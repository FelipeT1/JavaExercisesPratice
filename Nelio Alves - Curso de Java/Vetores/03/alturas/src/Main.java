import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Informe o número de pessoas ");
        int quantidade = teclado.nextInt();
        String[] nomes = new String[quantidade];
        int[] idades = new int[quantidade];
        double[] alturas = new double[quantidade];
        fillArrays(nomes, idades, alturas);
        printArrays(nomes, idades, alturas);
        averageHeight(alturas);
        percentageBelowSixteen(idades, nomes);
    }
    public static void fillArrays(String[] names, int[] age, double[] height){
        for(int i = 0; i < names.length; i++){
            System.out.print("Nome ");
            names[i] = teclado.next();
            System.out.print("Idade ");
            age[i] = teclado.nextInt();
            System.out.print("Altura ");
            height[i] = teclado.nextDouble();
        }
        System.out.println();
    }
    public static void printArrays(String[] names, int[] age, double[] height){
        for(int i = 0; i < names.length; i++){
            System.out.printf("Dados da %d pessoa%n", i+1);
            System.out.printf("Nome: %s%n", names[i]);
            System.out.printf("Idade: %d%n", age[i]);
            System.out.printf("Altura(metros): %.2f", height[i]);
            System.out.println();
        }
    }
    public static void averageHeight(double[] height){
        double average = 0;
        for(int i = 0; i < height.length; i++){
            average+=height[i];
        }
        average/= height.length;
        System.out.printf("Altura média %.2f%n", average);
        System.out.println();
    }
    public static void percentageBelowSixteen(int[] age, String[] names){
        int belowSixteenQuantity = 0;
        for(int i = 0; i < age.length; i++){
            if(age[i] < 16){
                belowSixteenQuantity++;

            }
        }
        double percentage = (double) belowSixteenQuantity /age.length;
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", percentage*100);
        for(int i = 0; i < age.length; i++){
            if(age[i] < 16){
                System.out.println(names[i]);
            }
        }
        System.out.println();
    }

}