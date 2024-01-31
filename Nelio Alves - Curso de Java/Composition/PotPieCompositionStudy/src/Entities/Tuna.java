package Entities;

public class Tuna {
    private String name;
    private Potpie birthday;


    public Tuna(String name, Potpie birthday){
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return String.format("My name is %s, my birthday is %s ", this.name, this.birthday);
    }
}
