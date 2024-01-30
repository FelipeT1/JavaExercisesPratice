//7.17
import java.util.ArrayList;
import java.util.Random;
public class Main{
    public static void main(String[] args) {
        final int CONSTANTE = 36000;
        ArrayList<Integer> numeros = new ArrayList<>();
        int resultadoDado1, resultadoDado2;
        for(int i = 1; i <= CONSTANTE; i++){
            resultadoDado1 = rollDice();
            resultadoDado2 = rollDice();
            numeros.add(resultadoDado1+resultadoDado2);
        }
        int[] copia = frequencia(numeros);
        for(int i = 2; i < copia.length; i++){
            System.out.printf(" numero %d - %d vezes \n" ,i, copia[i]);
        }
    }
    public static int rollDice(){
        int result;
        Random numeroAleatorio = new Random();
        result = 1+numeroAleatorio.nextInt(6);
        return result;
    }
    public static int[] frequencia(ArrayList<Integer> numeros){
        int[] frequenciaDeSoma = new int[13];
        for(int i = 2; i<= frequenciaDeSoma.length; i++){
            for (Integer numero : numeros) {
                if (i == numero) {
                    frequenciaDeSoma[i]++;
                }
            }
        }
        return frequenciaDeSoma;
    }
}