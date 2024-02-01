package entities;

public class EmployeeJ extends Employee{
    private Integer numOfEmployees;
    public EmployeeJ(String name, Double annualBilling, Integer numOfEmployees) {
        super(name, annualBilling);
        this.numOfEmployees = numOfEmployees;
    }
    public Integer getNumOfEmployees() {
        return numOfEmployees;
    }
    @Override
    public Double calculateTax() {
        if(getNumOfEmployees() > 10){
            return (super.getAnnualBilling()*0.14);
        }
        else{
            return (super.getAnnualBilling()*0.16);
        }
    }
}
