import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Informe o número de pessoas ");
        int quantidade = teclado.nextInt();
        String[] nomes = new String[quantidade];
        double[] notas = new double[quantidade*2];
        fillArrays(nomes, notas);
        printArrays(nomes, notas);
        average(nomes, notas);
    }
    public static void average(String[] names, double[] notas){
        double sum = 0;
        System.out.println("Alunos aprovados: ");
        for(int i = 0; i < names.length; i++){
            sum = (notas[i]+notas[i+1]) / 2;
            if(sum >= 6){
                System.out.println(names[i]);
            }
        }
    }
    public static void fillArrays(String[] names, double[] nota){
        for(int i = 0; i < names.length; i++){
            System.out.print("Nome e nota do primeiro e segundo semestre ");
            names[i] = teclado.next();
            nota[i] = teclado.nextDouble();
            nota[i+1] = teclado.nextDouble();
        }
        System.out.println();
    }
    public static void printArrays(String[] names, double[] nota){
        for(int i = 0; i < names.length; i++){
            System.out.printf("Dados da %d pessoa%n", i+1);
            System.out.printf("Nome: %s%n", names[i]);
            System.out.printf("Nota1: %.1f%n", nota[i]);
            System.out.printf("Nota2: %.1f%n", nota[i+1]);
            System.out.println();
        }
    }
}