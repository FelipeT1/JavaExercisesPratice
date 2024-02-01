package Application;

import Entities.Employee;
import Entities.EmployeeOutsourced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int quantity = teclado.nextInt();
        List<Employee> employeeList = new ArrayList<>();
        Employee employee;
        for(int i = 1; i <= quantity; i++){
            System.out.print("Outsourced (y/n)? ");
            boolean isOutsourced = teclado.next().charAt(0) == 'y';
            teclado.nextLine();
            System.out.print("Name: ");
            String name = teclado.nextLine();
            System.out.print("Hours: ");
            Integer hours = teclado.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = teclado.nextDouble();
            if(isOutsourced){
                System.out.print("Additional charge: ");
                Double additionalCharge = teclado.nextDouble();
                employee = new EmployeeOutsourced(name, hours, valuePerHour, additionalCharge);
            }
            else{
                employee = new Employee(name, hours, valuePerHour);
            }
            employeeList.add(employee);
        }
        System.out.println("PAYMENTS:");
        for(Employee e : employeeList){
            System.out.printf("%s - R$ %.2f%n", e.getName(),e.payment());
        }
        teclado.close();

    }
}
