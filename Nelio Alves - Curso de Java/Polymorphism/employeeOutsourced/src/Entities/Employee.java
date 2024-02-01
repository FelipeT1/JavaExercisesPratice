package Entities;

public class Employee {
    final private String name;
    final private Integer hours;
    final private Double valuePerHour;

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public String getName() {
        return name;
    }

    public Integer getHours() {
        return hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Double payment(){
        return getHours()*getValuePerHour();
    }
}
