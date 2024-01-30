//7.10

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int vendas = -1;
        ArrayList<Integer> salarios = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        while((vendas = teclado.nextInt()) != -1){
            salarios.add((int)(vendas * 0.09) + 200);
        }
        teclado.close();
        imprimeFrequencia(salarios);
    }
    public static void imprimeFrequencia(ArrayList<Integer> salario){
        int[] frequencia = new int[11];
        int indice = 0;
        for(int i = 1; i < salario.size(); i++){
            indice = salario.get(i) / 100;
            ++frequencia[indice > 10 ? 10 : indice];
        }

        for(int i = 2; i < frequencia.length; i++){
            System.out.printf("%d    %d  = " , i*100, i*100 + 99);
            System.out.println(frequencia[i]);
        }
    }
}