package uk.co.sammy.classes;

/**
 * Created by smlif on 05/01/2016.
 */
public class Account {
    private String name;
    private double amount;

    public Account(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public double remainingAmount() {
        return 2000.00;
    }
}
