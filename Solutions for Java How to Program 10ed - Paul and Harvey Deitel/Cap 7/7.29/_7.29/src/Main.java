import java.util.ArrayList;

// 7.29
// fibonacci
public class Main {
    public static void main(String[] args) {
        fibonacci(1000000);
    }
    public static void fibonacci(int n){
        int[] sequence = new int[3];
        sequence[0] = 0;
        sequence[1] = 1;
        System.out.print(" 0, 1, ");
        for(int i = 0; i < n; i++){
            sequence[2] = sequence[0]+sequence[1];
            sequence[0] = sequence[1];
            sequence[1] = sequence[2];
            System.out.printf(" %d, ", sequence[2]);
        }
    }

//    // array list version
//    public static void fibonacci(int n) {
//        ArrayList<Integer> sequence = new ArrayList<>();
//        sequence.add(0);
//        sequence.add(1);
//
//        System.out.print("0, 1, ");
//
//        for (int i = 2; i < n; i++) {
//            int nextTerm = sequence.get(i - 1) + sequence.get(i - 2);
//            sequence.add(nextTerm);
//            System.out.printf("%d, ", nextTerm);
//        }
//    }
}
