import java.util.Scanner;

/**
 * A simple BankAccount class with deposit, withdraw, and balance display functionality.
 */
class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.printf("Successfully deposited ₹%.2f%n", amount);
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.printf("Successfully withdrew ₹%.2f%n", amount);
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: ₹%.2f%n", balance);
    }
}

/**
 * Main class to run the BankAccount program.
 */
public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Create account
            System.out.print("Enter account holder name: ");
            String name = sc.nextLine();

            System.out.print("Enter account number: ");
            String accNumber = sc.nextLine();

            System.out.print("Enter initial balance: ");
            double initialBalance = sc.nextDouble();

            BankAccount account = new BankAccount(name, accNumber, initialBalance);

            // Menu-driven banking operations
            int choice;
            do {
                System.out.println("\n--- Banking Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Account Details");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                }
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.displayAccountDetails();
                        break;
                    case 4:
                        System.out.println("Thank you for banking with us!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
