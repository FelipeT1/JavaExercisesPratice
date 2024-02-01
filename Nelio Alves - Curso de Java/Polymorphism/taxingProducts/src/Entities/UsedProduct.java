package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
    final private LocalDate date;
    public UsedProduct(String name, Double price, String date) {
        super(name, price);
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date = LocalDate.parse(date,dt);
    }
    public String isoToString(){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dt.format(getDate());
    }
    public LocalDate getDate() {
        return date;
    }
    @Override
    public String priceTag(){
        return String.format("%s (used) R$ %.2f (Manufactured Date: %s)%n", getName(), super.getPrice(), isoToString());
    }
}
