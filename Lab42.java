//CP1340 Lab 4 - Inheritance and Polymorphism
//Student: Cade Molloy - 20175269
//Due Date: November 15th, 2022
//Prof: Branko Cirovic

abstract class Account {
    protected double amount;

    public Account() {
        amount = 0.00;
    }

    public void withdraw(double m) {
        if (m <= amount) {
            amount -= m;
        }
    }

    public void deposit(double m) {
        amount += m;
    }

    public abstract void show();
    public abstract double dailyInterest();
}

class Savings extends Account {
    public void show() {
        System.out.println("Current Balance of Savings is: " + amount);
    }

    public double dailyInterest() {
        return 0.06 * amount;
    }
}

class Chequing extends Account {
    public void show() {
        System.out.println("Current Balance of Chequing is " + amount);
    }

    public double dailyInterest() {
        return 0.03 * amount;
    }
}

class Lab42 {
    public static void main(String[] args) {
        Account[] accounts = new Account[2];

        accounts[0] = new Chequing();
        accounts[1] = new Savings();

        accounts[0].deposit(1500);
        accounts[0].withdraw(495);
        accounts[1].deposit(5000);
        accounts[1].withdraw(2500);

        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Account " + (i + 1));
            accounts[i].show();
            System.out.println("Interest: " + accounts[i].dailyInterest());
            System.out.println();
        }
    }
}