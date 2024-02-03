package model.entities;

import model.exceptions.LimitWithdrawException;
import model.exceptions.NegativeValueException;
import model.exceptions.NoAmountException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }
    public Double getBalance() {
        return balance;
    }

    private void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount) throws NegativeValueException {
        if(amount < 0){
            throw new NegativeValueException("Valor negativo não pode ser depositado.");
        }
        setBalance(getBalance()+amount);
    }
    public void withdraw(Double amount) throws NoAmountException, LimitWithdrawException {
        if(getBalance()<=0){
            throw new NoAmountException("Saldo zerado ou negativo.");
        }
        else if(amount > getWithdrawLimit()){
            throw new LimitWithdrawException("Saque maior que o limite previsto.");
        }
        setBalance(getBalance()-amount);
    }
}
