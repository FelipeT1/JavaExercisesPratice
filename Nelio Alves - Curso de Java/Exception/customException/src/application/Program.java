package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
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

            if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())){
                System.out.println("Reservation dates for update must be future dates!");
            }
            else if(checkOut.isBefore(checkIn)){
                System.out.println("Error in reservation: Check out date must be after check in date!");
            }
            else{
                reservation.updateDates(checkIn,checkOut);
                System.out.println(reservation);
            }
        }
    }
}
