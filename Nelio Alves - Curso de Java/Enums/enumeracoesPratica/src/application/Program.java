package application;

import entities.Order;
import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Order order = new Order(100, dtformat.format(LocalDateTime.now()), OrderStatus.AGUARDANDO_PAGAMENTO);
        System.out.println(order);

        OrderStatus orderStatus =  OrderStatus.ENVIADO;

        // Transforma uma String em um Enum
        OrderStatus orderStatus1 = OrderStatus.valueOf("ENTREGUE");

        System.out.println(orderStatus);
        System.out.println(orderStatus1);
    }
}
