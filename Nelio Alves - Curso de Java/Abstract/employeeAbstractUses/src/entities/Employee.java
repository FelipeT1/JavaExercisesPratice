package entities;

abstract public class Employee {
    private String name;
    private Double annualBilling;
    public Employee(String name, Double annualBilling){
        this.name = name;
        this.annualBilling = annualBilling;
    }

    public String getName() {
        return name;
    }

    public Double getAnnualBilling() {
        return annualBilling;
    }
    abstract public Double calculateTax();
}
