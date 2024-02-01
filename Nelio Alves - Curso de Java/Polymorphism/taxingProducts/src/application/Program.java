package application;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Entre com o numero de produtos: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Datos do produto #" + i + ":");
            System.out.print("Comum, usado, importado (c/u/i)? ");
            char type = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preco: ");
            double price = sc.nextDouble();
            if (type == 'c') {
                list.add(new Product(name, price));
            }
            else if (type == 'u') {
                System.out.print("Data de fabricacao (DD/MM/YYYY): ");
                sc.nextLine();
                String date = sc.nextLine();
                list.add(new UsedProduct(name, price, date));
            }
            else {
                System.out.print("Taxa de importacao: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
        }

        System.out.println();
        System.out.println("ETIQUETAS DE PRECO:");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}