package Application;

import Entities.Department;
import Entities.Worker;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Enter department's name ");
        Department department = new Department(teclado.nextLine());
        System.out.println("Enter work data:");
        System.out.print("Name: ");
        String name = teclado.nextLine();
        System.out.print("Level: ");
        String level = teclado.nextLine();
        System.out.print("Base salary: ");
        Double baseSalary = teclado.nextDouble();
        Worker worker = new Worker(name, level, baseSalary,department);
        System.out.print("How many contracts to this worker? ");
        int contracts = teclado.nextInt();

        for(int i = 1; i<=contracts;i++){
            System.out.printf("Enter contract #%d%n", i);
            worker.addContract();
        }

        teclado.nextLine();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String calculateIncome = teclado.nextLine();

        //No substring se deve informar o começo e no final informar 1 a mais
        int month = Integer.parseInt(calculateIncome.substring(0,2));
        //Como aqui queremos o resto podemos omitir o end index
        int year =  Integer.parseInt(calculateIncome.substring(3));

        //DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/yyyy");
        //LocalDate localDate = LocalDate.parse(calculateIncome, dateTimeFormatter);
        baseSalary += worker.income(year, month);

        System.out.printf("Name: %s%n", name);
        System.out.printf("Department: %s%n", department.getDepartment());
        System.out.printf("Income for %s: %.2f",calculateIncome, baseSalary);

        teclado.close();
    }
}
