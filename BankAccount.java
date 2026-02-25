public class BankAccount {
    private String name;
    private String accountNumber;
    private double balance;
    private int pin;

    // Constructor
    public BankAccount(String name, String accountNumber, double balance, int pin){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    // Deposit Method
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public boolean withdraw(double amount, int enteredPin){
        if(enteredPin != pin){
            System.out.println("Incorrect PIN.");
            return false;
        }

        if(amount > balance){
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;
        System.out.println(amount + " withdrawn successfully.");
        return true;
    }

    // PIN Validation
    public boolean validatePin(int enteredPin){
        return pin == enteredPin;
    }

    // Getters
    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    @Override
    public String toString(){
        return accountNumber + " | " + name + " | Balance: " + balance;
    }
}