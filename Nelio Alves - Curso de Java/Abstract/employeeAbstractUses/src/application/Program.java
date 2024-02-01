package application;

import entities.Employee;
import entities.EmployeeF;
import entities.EmployeeJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of taxpayers: ");
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            System.out.println("Taxpayer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();
            if (type == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                list.add(new EmployeeF(name, anualIncome, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                Integer numberOfEmployees = sc.nextInt();
                list.add(new EmployeeJ(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        for (Employee tp : list) {
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tp.calculateTax()));
        }

        System.out.println();
        double sum = 0.0;
        for (Employee tp : list) {
            sum += tp.calculateTax();
        }
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

        sc.close();
    }

}