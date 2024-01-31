package Entities;

import Entities.Enums.WorkerLevel;
import Service.HourContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Worker {
    private String name;
    private WorkerLevel workerLevel;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, String workerLevel, Double baseSalary, Department department){
        this.name = name;
        this.workerLevel = WorkerLevel.valueOf(workerLevel);
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Date (DD/MM/YYYY) ");
        String date = teclado.nextLine();
        System.out.print("Value per Hour ");
        Double valuePerHours = teclado.nextDouble();
        System.out.print("Duration(hours) ");
        Integer hoursToWork = teclado.nextInt();
        this.contracts.add(new HourContract(date, valuePerHours, hoursToWork));
    }

    public void removeContract(HourContract contract){
        if(this.contracts.stream()
                .filter(x->x.equals(contract))
                .findAny()
                .orElse(null) != null){
            this.contracts.remove(contract);
        }
        else{
            System.out.println("Contrato não existe!");
        }
    }

    public Double income(Integer year, Integer month){
        Double salarioDoContrato = 0.0d;
//        List<HourContract> contracts = new ArrayList<>();
//
//        contracts = this.contracts
//                .stream()
//                .filter((x->x.getDateTime().getYear() == year))
//                .toList();
//
//
//        contracts =  contracts
//                .stream()
//                .filter(x->x.getDateTime().getMonthValue() == month)
//                .toList();

        for(HourContract c : contracts){
            if(c.getDateTime().getMonthValue() == month
                    && c.getDateTime().getYear() == year){
                salarioDoContrato+=c.totalValue();
            }
        }

        return salarioDoContrato;
    }
}
