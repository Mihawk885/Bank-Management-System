import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();
        int choice;

        do{
            System.out.println("\n==== Bank Management System ====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Money");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice){

                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Account Number: ");
                    String accountNumber = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter 4-Digit PIN: ");
                    int pin = sc.nextInt();
                    sc.nextLine();

                    bank.createAccount(name, accountNumber, balance, pin);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositAcc = sc.nextLine();

                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = sc.nextDouble();
                    sc.nextLine();

                    bank.deposit(depositAcc, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withdrawAcc = sc.nextLine();

                    System.out.print("Enter Amount to Withdraw: ");
                    double withdrawAmount = sc.nextDouble();

                    System.out.print("Enter PIN: ");
                    int withdrawPin = sc.nextInt();
                    sc.nextLine();

                    bank.withdraw(withdrawAcc, withdrawAmount, withdrawPin);
                    break;

                case 4:
                    System.out.print("Enter From Account Number: ");
                    String fromAcc = sc.nextLine();

                    System.out.print("Enter To Account Number: ");
                    String toAcc = sc.nextLine();

                    System.out.print("Enter Amount to Transfer: ");
                    double transferAmount = sc.nextDouble();

                    System.out.print("Enter PIN: ");
                    int transferPin = sc.nextInt();
                    sc.nextLine();

                    bank.transfer(fromAcc, toAcc, transferAmount, transferPin);
                    break;

                case 5:
                    bank.viewAllAccounts();
                    break;

                case 6:
                    System.out.println("Thank you for using Bank Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while(choice != 6);

        sc.close();
    }
}