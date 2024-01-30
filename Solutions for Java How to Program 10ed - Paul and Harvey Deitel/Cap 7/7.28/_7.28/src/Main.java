// 7.28

import java.security.SecureRandom;

public class Main {

    private static String[] pistaDeCorrida = new String[70];
    private static int harePosition = 0;
    private static int turtlePosition = 0;

    public static void main(String[] args) {
        SecureRandom movement = new SecureRandom();
        String turtle = "T";
        String hare = "H";
        String draw = "AI!!!";
        boolean turtleWins = false;
        boolean hareWins = false;
        for(int time = 0; time < pistaDeCorrida.length; time++){
            int action = 1+movement.nextInt(10);
            if(harePosition < 0){
                harePosition = 0;
            }
            if(turtlePosition < 0){
                turtlePosition = 0;
            }
            if(harePosition >= pistaDeCorrida.length){
                System.out.println("LEBRE GANHOU!!!!!!!!!!");
                hareWins = true;
                break;
            }
            else if(turtlePosition >= pistaDeCorrida.length){
                System.out.print("TARTARUGA GANHOU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                turtleWins = true;
                break;
            }
            if(harePosition == turtlePosition){
                pistaDeCorrida[turtlePosition] = draw;
                printRace();
                pistaDeCorrida[turtlePosition] = null;
            }
            else{
                pistaDeCorrida[turtlePosition] = turtle;
                pistaDeCorrida[harePosition] = hare;
                printRace();
                pistaDeCorrida[turtlePosition] = null;
                pistaDeCorrida[harePosition] = null;
            }
            harePosition+=hareAction(action);
            turtlePosition+=turtleAction(action);
        }
        if(!turtleWins && !hareWins){
            System.out.println(" OS DOIS GANHARAM OU OS DOIS PERDERAM!!!!!!");
        }
    }
    public static void printRace(){
        for(int position = 0; position < pistaDeCorrida.length; position++){
            if(pistaDeCorrida[position] == null){
                System.out.print(" ");
            }
            else{
                System.out.print(pistaDeCorrida[position]);
            }
        }
        System.out.println();
        }
    public static int turtleAction(int action){
        int squaresMoved = 0;
        switch (action){
            //50% de chance
            case 1,2,3,4,5:
                squaresMoved+=3;
                break;
            // 20% de chance
            case 6,7:
                squaresMoved-=6;
                break;
            // 30% de chance
            case 8,9,10:
                squaresMoved+=1;
                break;
        }
        return squaresMoved;
    }
    public static int hareAction(int action){
        int squaresMoved = 0;
        switch (action){
            //20%
            case 1,2:
                break;
            //20%
            case 3,4:
                squaresMoved+=9;
                break;
            //10%
            case 5:
                squaresMoved-=12;
                break;
            //30%
            case 6,7,8:
                squaresMoved+=1;
                break;
            //20%
            case 9,10:
                squaresMoved-=2;
                break;
        }
        return squaresMoved;
    }
}