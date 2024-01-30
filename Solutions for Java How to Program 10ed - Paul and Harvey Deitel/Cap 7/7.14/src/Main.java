//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//7.14
public class Main {
    public static void main(String[] args) {
        System.out.println(product(2,6));
        System.out.println(product(1,2,5,7,8,0));
    }

    public static int product(int... numero){
        int produto = 1;
        for(int i = 0; i < numero.length; i++){
            produto *= numero[i];
        }
        return produto;
    }
}