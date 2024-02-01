package Entities;
public class Product {
    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    public String priceTag(){
        return String.format("%s R$ %.2f%n", getName(),getPrice());
    }
    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
