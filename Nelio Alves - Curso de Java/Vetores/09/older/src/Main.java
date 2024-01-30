import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Informe o número de pessoas ");
        int quantidade = teclado.nextInt();
        String[] nomes = new String[quantidade];
        int[] idades = new int[quantidade];
        fillArrays(nomes, idades);
        printArrays(nomes, idades);
        findOldestPerson(idades, nomes);
    }
    public static void findOldestPerson(int[] age, String[] names){
        int oldest = 0;
        String name = "alo";
        for(int i = 0; i < age.length; i++){
            if(age[i] > oldest){
                oldest = age[i];
                name = names[i];
            }
        }
        System.out.println("idade "+ oldest);
        System.out.println("PESSOA MAIS VELHA: "+ name);
    }
    public static void fillArrays(String[] names, int[] age){
        for(int i = 0; i < names.length; i++){
            System.out.print("Nome ");
            names[i] = teclado.next();
            System.out.print("Idade ");
            age[i] = teclado.nextInt();
        }
        System.out.println();
    }
    public static void printArrays(String[] names, int[] age){
        for(int i = 0; i < names.length; i++){
            System.out.printf("Dados da %d pessoa%n", i+1);
            System.out.printf("Nome: %s%n", names[i]);
            System.out.printf("Idade: %d%n", age[i]);
            System.out.println();
        }
    }
}