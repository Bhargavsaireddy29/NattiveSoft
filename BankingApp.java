import java.util.ArrayList;  // Import ArrayList class
import java.util.Scanner;    // Import Scanner class

public class BankingApp {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Main menu for banking application
    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display the menu options
    public static void showMenu() {
        System.out.println("\n=== Banking Application ===");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Create a new bank account
    public static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter a unique account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        BankAccount newAccount = new BankAccount(name, accountNumber);
        accounts.add(newAccount);
        System.out.println("Account created successfully for " + name + " with account number " + accountNumber);
    }

    // Deposit money into an account
    public static void depositMoney() {
        System.out.print("Enter account number to deposit money: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();

        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Withdraw money from an account
    public static void withdrawMoney() {
        System.out.print("Enter account number to withdraw from: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();

        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Check the balance of an account
    public static void checkBalance() {
        System.out.print("Enter account number to check balance: ");
        int accountNumber = scanner.nextInt();

        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("The balance of account " + accountNumber + " is $" + account.checkBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    // Find an account by account number
    public static BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;  // Account not found
    }
}
