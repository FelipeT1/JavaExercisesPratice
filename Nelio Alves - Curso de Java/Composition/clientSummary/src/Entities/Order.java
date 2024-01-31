package Entities;

import Entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime date;
    private OrderStatus status;
    private Client client;
    List<OrderItem> items = new ArrayList<>();
    public Order(OrderStatus status, Client client, List<OrderItem> items) {
        this.date = LocalDateTime.now();
        this.status = status;
        this.client = client;
        this.items = items;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public Client getClient() {
        return client;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }
    public Double total(){
        Double total = 0.0d;
        for(OrderItem item : items){
            total+=item.subTotal();
        }
        return total;
    }
}
