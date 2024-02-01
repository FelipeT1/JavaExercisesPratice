package Entities;

public class BusinessAccount extends Account{
    private Integer percentage;

    public BusinessAccount(String name, Double salary, Integer percentage) {
        super(name, salary);
        this.percentage = percentage;
    }

    public BusinessAccount(Integer percentage) {
        this.percentage = percentage;
    }

    public Integer getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return "BusinessAccount{" +
                "percentage=" + percentage +
                '}';
    }
}
