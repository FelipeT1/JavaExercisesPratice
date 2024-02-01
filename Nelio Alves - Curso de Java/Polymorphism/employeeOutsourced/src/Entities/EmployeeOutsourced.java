package Entities;

public class EmployeeOutsourced extends Employee{
    final private Double additionalCost;
    public EmployeeOutsourced(String name, Integer hours, Double valuePerHour, Double additionalCost) {
        super(name, hours, valuePerHour);
        this.additionalCost = additionalCost;
    }
    @Override
    public Double payment(){

        return (super.payment()) + this.additionalCost*1.1;
    }
}
