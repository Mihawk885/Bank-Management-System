import java.util.ArrayList;

public class BankService {

    private ArrayList<BankAccount> accounts = new ArrayList<>();

    // Create Account
    public void createAccount(String name, String accountNumber, double balance, int pin){

        if(findAccount(accountNumber) != null){
            System.out.println("Account number already exists!");
            return;
        }

        BankAccount newAccount = new BankAccount(name, accountNumber, balance, pin);
        accounts.add(newAccount);

        System.out.println("Account created successfully!");
    }

    // Find Account (Private Helper)
    private BankAccount findAccount(String accountNumber){
        for(BankAccount acc : accounts){
            if(acc.getAccountNumber().equals(accountNumber)){
                return acc;
            }
        }
        return null;
    }

    // Deposit
    public void deposit(String accountNumber, double amount){
        BankAccount acc = findAccount(accountNumber);

        if(acc != null){
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw
    public void withdraw(String accountNumber, double amount, int pin){
        BankAccount acc = findAccount(accountNumber);

        if(acc != null){
            acc.withdraw(amount, pin);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Transfer
    public void transfer(String senderAccount, String receiverAccount, double amount, int pin){

        BankAccount sender = findAccount(senderAccount);
        BankAccount receiver = findAccount(receiverAccount);

        if(sender == null || receiver == null){
            System.out.println("Invalid sender or receiver account.");
            return;
        }

        if(!sender.validatePin(pin)){
            System.out.println("Incorrect PIN.");
            return;
        }

        if(sender.getBalance() < amount){
            System.out.println("Insufficient balance.");
            return;
        }

        sender.withdraw(amount, pin);
        receiver.deposit(amount);

        System.out.println("Transfer successful!");
    }

    // View All Accounts
    public void viewAllAccounts(){
        if(accounts.isEmpty()){
            System.out.println("No accounts available.");
            return;
        }

        for(BankAccount acc : accounts){
            System.out.println(acc);
        }
    }
}