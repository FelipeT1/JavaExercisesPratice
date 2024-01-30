import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Informe o número de pessoas ");
        int quantidade = teclado.nextInt();
        char[] nomes = new char[quantidade];
        double[] altura = new double[quantidade];
        fillArrays(nomes, altura);
        printArrays(nomes, altura);
        averageMinAndMaxHeight(nomes, altura);
    }
    public static void averageMinAndMaxHeight(char[] names, double[] altura){
        double sum = 0;
        int feminino = 0;
        int masculino = 0;
        double menor = 10000;
        double maior = 0;

        System.out.println("Alunos aprovados: ");
        for(int i = 0; i < names.length; i++){
            if(names[i] == 'F'){
                feminino++;
                sum += altura[i];
            }
            else{
                masculino++;
            }
            if(altura[i] > maior){
                maior = altura[i];
            }
            if(altura[i] < menor){
                menor = altura[i];
            }
        }
        sum/=feminino;
        System.out.printf("Menor altura = %.2f", menor);
        System.out.printf("Menor altura = %.2f", maior);
        System.out.printf("Media das alturas das mulheres = %.2f", sum);
        System.out.printf("Numero de homi = %d", masculino);

        System.out.println();
    }
    public static void fillArrays(char[] names, double[] altura){
        for(int i = 0; i < names.length; i++){
            System.out.print("Nome e nota do primeiro e segundo semestre ");
            names[i] = teclado.next().charAt(0);
            altura[i] = teclado.nextDouble();
        }
        System.out.println();
    }
    public static void printArrays(char[] names, double[] altura){
        for(int i = 0; i < names.length; i++){
            System.out.printf("Dados da %d pessoa%n", i+1);
            System.out.printf("Sexo: %c%n", names[i]);
            System.out.printf("Altura: %.1f%n", altura[i]);
            System.out.println();
        }
    }
}