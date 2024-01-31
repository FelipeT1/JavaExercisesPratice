package Application;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        // Coleta dados do cliente
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = teclado.nextLine();
        System.out.print("Email: ");
        String email = teclado.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        String birthDate = teclado.nextLine();
        Client cliente = new Client(name, email, birthDate);

        // Coleta dados do pedido
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = teclado.nextLine();
        System.out.print("How many items to this order? ");
        int howMany = teclado.nextInt();
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 1; i <= howMany; i++) {
            System.out.print("Enter #" + i + " item data:\n");
            System.out.print("Product name: ");
            String productName = teclado.nextLine();
            teclado.nextLine();
            System.out.print("Product price: ");
            Double price = teclado.nextDouble();
            Product produto = new Product(productName, price);
            System.out.print("Quantity: ");
            Integer quantity = teclado.nextInt();
            OrderItem orderItem = new OrderItem(quantity, price, produto);
            orderItemList.add(orderItem);
        }

        // Criação do objeto Order e formatação da data
        Order order = new Order(OrderStatus.valueOf(status), cliente, orderItemList);
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter dta = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Exibição do resumo do pedido
        System.out.println("ORDER SUMMARY:");
        System.out.println("Order moment: " + dt.format(order.getDate()));
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + order.getClient().getName() +
                dta.format(order.getClient().getBirthDate()) +
                " - " + order.getClient().getEmail());
        System.out.println("Order items:");

        // Cálculo do preço total e exibição dos itens do pedido
        Double totalPrice = 0.0d;
        for (OrderItem p : order.getItems()) {
            totalPrice += p.subTotal();
            System.out.print(p.getProduct().getName() + ", " +
                    p.getProduct().getPrice() + "Quantity: " +
                    p.getQuantity() + ", " +
                    "Subtotal: R$" + String.format("%.2f", p.subTotal()) + "\n");
        }
        System.out.println("Total price: R$" + String.format("%.2f", totalPrice));
    }

}
