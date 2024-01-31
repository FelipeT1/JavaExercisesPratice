package Application;

import Entities.Potpie;
import Entities.Tuna;

public class Program {
    public static void main(String[] args) {
        Potpie potpie = new Potpie(1,2,3);

        System.out.println(potpie);

        // potpie não é uma String. É um objeto
        Tuna tuna = new Tuna("Felipe", potpie);

        // Por isso, quando chamamos o print com o objeto,
        // Ele chamará o toString da classe Entities.Tuna e verificará
        // Que o atributo birthday do tipo Entities.Tuna não é, de fato, uma String
        // Mas um objeto, então ele pedirá para que a classe Entities.Potpie
        // Forneça o seu método toString para o format.
        System.out.println(tuna);
    }
}
