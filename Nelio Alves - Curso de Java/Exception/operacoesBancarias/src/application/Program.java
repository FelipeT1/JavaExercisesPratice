package application;

import model.entities.Account;
import model.exceptions.LimitWithdrawException;
import model.exceptions.NegativeValueException;
import model.exceptions.NoAmountException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);
        try{
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Holder: ");
            String holder = teclado.nextLine();
            System.out.print("Initial balance: ");
            double balance = teclado.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = teclado.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            double withdraw = teclado.nextDouble();

            account.withdraw(withdraw);

            System.out.print("Enter amount for deposit: ");
            double deposit = teclado.nextDouble();

            account.deposit(deposit);

            System.out.printf("New balance: %.2f", account.getBalance());

        }
        catch (NoAmountException | LimitWithdrawException e){
            System.out.print("Withdraw Exception: " + e.getMessage());
        }
        catch (NegativeValueException e){
            System.out.print("Deposit Exception: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error.");
        }

    }
}
