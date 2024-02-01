package Application;

import Entities.Account;
import Entities.BusinessAccount;

public class Program {
    public static void main(String[] args) {
        Account account = new Account();
        BusinessAccount businessAccount = new BusinessAccount(100);
        System.out.println(account);
        //System.out.println(businessAccount);


        // UPCASTING
        Account acc = new BusinessAccount(100);
        System.out.println(acc);

        //DOWNCASTING
        BusinessAccount bacc = (BusinessAccount) new Account();
        System.out.println(bacc);
    }
}
