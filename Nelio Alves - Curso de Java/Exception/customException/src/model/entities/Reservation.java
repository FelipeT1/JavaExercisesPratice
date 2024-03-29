package model.entities;

import model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if(checkOut.isBefore(checkIn)){
            throw new DomainException("Check out date must be after check in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    public long duration(){
        Duration duration = Duration.between(checkIn.atStartOfDay(),checkOut.atStartOfDay());
        return duration.toDays();
    }
    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())){
            throw new DomainException("Reservation dates for update must be future dates!");
        }
        if(checkOut.isBefore(checkIn)){
            throw new DomainException("Check out date must be after check in date!");
        }
        setCheckIn(checkIn);
        setCheckOut(checkOut);
    }
    private void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
    private void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation "
                + "roomNumber= " + roomNumber +
                ", checkIn= " + dt.format(checkIn) +
                ", checkOut= " + dt.format(checkOut) +
                " " + duration() + " nights.";
    }
}
