import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.printf("New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Decline: Insufficient funds.");
            return;
        }
        balance -= amount;
        System.out.printf("Remaining balance:" + balance);
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccount() {
        System.out.println("       ACCOUNT SUMMARY       ");
        System.out.println("=============================");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name   : " + holderName);
        System.out.printf("Total Balance :" + balance);
    }
}

public class AccountManagement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Open New Bank Account ---");
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(accNum, name, initialBalance);
        userAccount.displayAccount();

        handleDepositTransaction(userAccount, scanner);
        handleWithdrawalTransaction(userAccount, scanner);

        System.out.println("--- Transactions complete. Printing final statement ---");
        userAccount.displayAccount();

        scanner.close();
    }

    private static void handleDepositTransaction(BankAccount account, Scanner scanner) {
        System.out.print("\n Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private static void handleWithdrawalTransaction(BankAccount account, Scanner scanner) {
        System.out.print("\n Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}
