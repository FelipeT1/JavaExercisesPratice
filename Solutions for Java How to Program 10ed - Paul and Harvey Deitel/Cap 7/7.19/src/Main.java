import java.security.SecureRandom;
import java.util.Scanner;

//7.19
public class Main{
    private static boolean[] cadeirasDoAviao = new boolean[11];

    public enum Classe{
        PRIMEIRA_CLASSE, SEGUNDA_CLASSE;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        while(escolha != -1){
            System.out.print("ESCOLHA UM ASSENTO\t");
            escolha = escolheClasseVoo(Classe.PRIMEIRA_CLASSE);
            switch (escolha){
                case 1,2,3,4,5:
                    if(checaClasseCheia(cadeirasDoAviao,Classe.PRIMEIRA_CLASSE)){
                        System.out.printf("A PRIMEIRA CLASSE ESTÁ CHEIA. QUER IR NA SEGUNDA?\n0 -SIM\n55 - NAO\t");
                        escolha = teclado.nextInt();
                        if(escolha == 0){
                            escolha = teclado.nextInt();
                        }
                        else {
                            System.out.print("PROXIMA VIAGEM EM 3 HORAS!\n");
                            break;
                        }
                    }
                    else if(checaAssento(escolha)){
                        System.out.printf("ASSENTO %d ATRIBUIDO! BOA VIAGEM\t\n", escolha);
                    }
                    else {
                        System.out.printf("O ASSENTO JÁ ESTÁ RESERVADO %d\t\n", escolha);
                        System.out.printf("ESCOLHA OUTRO ASSENTO\t");
                        escolha = teclado.nextInt();
                    }
                    break;
                case 6,7,8,9,10:
                    if(checaClasseCheia(cadeirasDoAviao,Classe.SEGUNDA_CLASSE)){
                        System.out.printf("A SEGUNDA CLASSE ESTÁ CHEIA. QUER IR NA SEGUNDA?\n0 -SIM\n55 - NAO\t");
                        escolha = teclado.nextInt();
                        if(escolha == 0){
                            escolha = teclado.nextInt();
                        }
                        else {
                            System.out.print("PROXIMA VIAGEM EM 3 HORAS!\n");
                            break;
                        }
                    }
                    else if(checaAssento(escolha)){
                        System.out.printf("ASSENTO %d ATRIBUIDO! BOA VIAGEM\t\n", escolha);
                    }
                    else {
                        System.out.printf("O ASSENTO JÁ ESTÁ RESERVADO %d\t\n", escolha);
                        System.out.printf("ESCOLHA OUTRO ASSENTO\t");
                        escolha = teclado.nextInt();
                    }
                    break;
                default:
                    if(checaClasseCheia(cadeirasDoAviao,Classe.PRIMEIRA_CLASSE)&&checaClasseCheia(cadeirasDoAviao, Classe.SEGUNDA_CLASSE)){
                        System.out.print("O AVIAO ESTÁ LOTADO!");
                        escolha = -1;
                    }
            }
        }
    }
    public static boolean checaClasseCheia(boolean[] assentos, Classe classe){
        boolean classeCheia = false;
        int cadeiras = 0;
        switch (classe){
            case PRIMEIRA_CLASSE: {
                for(int i = 1; i <= cadeirasDoAviao.length/2;i++){
                    if(cadeirasDoAviao[i]){
                        cadeiras++;
                    }
                }
                break;
            }
            case SEGUNDA_CLASSE: {
                for(int i = 6; i <= cadeirasDoAviao.length;i++){
                    if(cadeirasDoAviao[i]){
                        cadeiras++;
                    }
                }
                break;
            }
        }
        if(cadeiras == 5){
            System.out.printf("%s LOTADA\t\n", classe);
            classeCheia=true;
        }
        return classeCheia;
    }
    public static boolean checaAssento(int assento){
        boolean vazio = true;
        if(cadeirasDoAviao[assento]){
            vazio = false;
        }
        else{
            cadeirasDoAviao[assento] = vazio;
        }
        return vazio;
    }
    public static int escolheClasseVoo(Classe classe){
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        return switch (classe){
            case PRIMEIRA_CLASSE -> escolha = teclado.nextInt();
            case SEGUNDA_CLASSE -> escolha = teclado.nextInt();
        };
    }
}