//6.28

public class Main {
    public static void main(String[] args) {
        System.out.println(qualityPoints(100));
        System.out.println(qualityPoints2(100));
        System.out.println(qualityPoints3(10));
    }

    public static int qualityPoints(int average){
        int points = 0;
        switch (average/10){
            case 10:
            case 9:
                points = 4;
                break;
            case 8:
                points = 3;
                break;
            case 7:
                points = 2;
                break;
            case 6:
                points = 1;
                break;
        }

        return points;
    }
    public static int qualityPoints2(int average){
        int points = switch (average / 10) {
            case 10, 9 -> 4;
            case 8 -> 3;
            case 7 -> 2;
            case 6 -> 1;
            default -> 0;
        };

        return points;
    }
    public static int qualityPoints3(int average){

        return switch (average / 10) {
            case 10, 9 -> 4;
            case 8 -> 3;
            case 7 -> 2;
            case 6 -> 1;
            default -> 0;
        };
    }
}