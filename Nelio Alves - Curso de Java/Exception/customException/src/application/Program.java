package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        /*
         * Essa lógica é um pouco melhor pois a classe reservation está responsável por parte da lógica,
         * O que é uma boa demonstração de delegação.
         * Essa solução era usada em linguagens antigas, onde as excessões não existiam
         */

        Scanner teclado = new Scanner(System.in);
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter room number: ");
        Integer roomNumber = teclado.nextInt();

        System.out.print("Enter check in: ");
        LocalDate checkIn =  LocalDate.parse(teclado.next(), dt);

        System.out.print("Enter check out: ");
        LocalDate checkOut = LocalDate.parse(teclado.next(), dt);

        if(!checkOut.isAfter(checkIn)){
            System.out.println("Error in reservation: Check out date must be after check in date!");
        }
        else{
            Reservation reservation = new Reservation(roomNumber,checkIn,checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter the data to update the reservation ");

            System.out.print("Enter check in: ");
            checkIn =  LocalDate.parse(teclado.next(), dt);

            System.out.print("Enter check out: ");
            checkOut = LocalDate.parse(teclado.next(), dt);

            String error = reservation.updateDates(checkIn,checkOut);
            if(error != null){
                System.out.println("Error in Reservation: " + error);
            }
            else{
                System.out.println(reservation);
            }

        }
    }
}
