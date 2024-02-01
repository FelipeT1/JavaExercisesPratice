package entities;

public class EmployeeF extends Employee{
    private Double healthExpanses;
    public EmployeeF(String name, Double annualBilling, Double healthExpanses) {
        super(name, annualBilling);
        this.healthExpanses = healthExpanses;
    }

    public Double getHealthExpanses() {
        return healthExpanses;
    }

    @Override
    public Double calculateTax() {
        if(super.getAnnualBilling() > 20000){
            return (super.getAnnualBilling()*0.25) - (getHealthExpanses()/2);
        }
        else{
            return (super.getAnnualBilling()*0.15) - (getHealthExpanses()/2);
        }
    }
}
