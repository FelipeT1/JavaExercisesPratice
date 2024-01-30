import java.util.Arrays;

public class Main {
    private static boolean[] eratostenesCrivo = new boolean[1000];
    public static void main(String[] args) {
        initializeArray();
        exploreArray();
        printArray();
    }
    // Exercício manda inicializar o array com true.
    public static void initializeArray(){
        Arrays.fill(eratostenesCrivo, true);
    }

    // Explore array comum
    public static void exploreArray(){
        for(int i = 2; i < eratostenesCrivo.length; i++){
            if(eratostenesCrivo[i]){
                for (int c = i+1; c < eratostenesCrivo.length; c++){
                    if(c%i == 0){
                        eratostenesCrivo[c] = false;
                    }
                }
            }
        }
    }
    public static void printArray(){
        for(int i = 2; i < eratostenesCrivo.length; i++){
            if(eratostenesCrivo[i]){
                System.out.println(i);
            }
        }
    }
}