package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourContract {
    private LocalDate date;
    private Double valuePerHours;
    private Integer hoursToWork;

    public HourContract(String date, Double valuePerHours, Integer hoursToWork){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.date = LocalDate.parse(date, dateTimeFormatter);
        this.valuePerHours = valuePerHours;
        this.hoursToWork = hoursToWork;
    }

    public Double totalValue(){
        return getValuePerHours()*getHoursToWork();
    }

    public LocalDate getDateTime() {
        return date;
    }

    public void setDateTime(LocalDate date) {
        this.date = date;
    }

    public Double getValuePerHours() {
        return valuePerHours;
    }

    public void setValuePerHours(Double valuePerHours) {
        this.valuePerHours = valuePerHours;
    }

    public Integer getHoursToWork() {
        return hoursToWork;
    }

    public void setHoursToWork(Integer hoursToWork) {
        this.hoursToWork = hoursToWork;
    }
}
