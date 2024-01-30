

// 6.19
public class Main {
    public static void main(String[] args) {
        square(6,'a');
    }

    public static void square(int side, char fillCharacter){
        for(int i = 1; i <= side; i++){
            for(int line = 1; line <= side; line++){
                System.out.print(fillCharacter);
            }
            System.out.println();
        }
    }
}