package entities;

import entities.enums.OrderStatus;


public class Order {
    private Integer id;
    private OrderStatus status;
    private String requestMoment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Order(){}
    public Order(Integer id, String requestMoment, OrderStatus status){
        this.id = id;
        this.requestMoment = requestMoment;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "requestMoment=" + requestMoment +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
