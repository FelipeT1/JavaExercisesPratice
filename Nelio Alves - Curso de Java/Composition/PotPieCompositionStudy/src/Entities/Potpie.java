package Entities;

public class Potpie{
    private int month;
    private int day;
    private int year;

    public Potpie(int x, int y, int z){
        month = x;
        day = y;
        year = z;

        System.out.printf("The const for this is %s%n", this);
    }
    @Override
    public String toString(){
        return String.format("%d/%d/%d", month,day,year);
    }
}