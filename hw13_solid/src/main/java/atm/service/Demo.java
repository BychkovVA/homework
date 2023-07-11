package atm.service;

import java.util.List;

public class Demo {

    public static void main(String[] args) throws Exception {


        ATM atm = new ATM();
        atm.loadBanknotes(100, 5);
        atm.loadBanknotes(200, 10);
        atm.loadBanknotes(500, 3);
        atm.loadBanknotes(5000, 2);


        atm.displayBalance();

        System.out.println(atm.withdrawAmount(300));
        System.out.println(atm.withdrawAmount(5500));

        atm.displayBalance();

    }
}
