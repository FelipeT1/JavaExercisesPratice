package Entities;

public class Account {
    private String name;
    private Double salary;
    public Account(){

    }
    public Account(String name, Double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
