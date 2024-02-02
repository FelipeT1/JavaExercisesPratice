package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        /*
         * Essa lógica implementa as excessões e delega as determinadas classes suas responsabilidades
         */
        try{
            Scanner teclado = new Scanner(System.in);
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("Enter room number: ");
            Integer roomNumber = teclado.nextInt();

            System.out.print("Enter check in: ");
            LocalDate checkIn =  LocalDate.parse(teclado.next(), dt);

            System.out.print("Enter check out: ");
            LocalDate checkOut = LocalDate.parse(teclado.next(), dt);

            Reservation reservation = new Reservation(roomNumber,checkIn,checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter the data to update the reservation ");

            System.out.print("Enter check in: ");
            checkIn =  LocalDate.parse(teclado.next(), dt);

            System.out.print("Enter check out: ");
            checkOut = LocalDate.parse(teclado.next(), dt);

            reservation.updateDates(checkIn,checkOut);

            System.out.println(reservation);
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: "+e.getMessage());
        }
        //Upcasting para pegar qualquer excessão RuntimeException
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

    }
}
