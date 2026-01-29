import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class BankAccount {
    private String accountHolder;
    private BigDecimal balance;

    // Constructor
    public BankAccount(String accountHolder, String initialBalance) {
        this.accountHolder = accountHolder;
        // We use a String constructor for BigDecimal to maintain exact precision
        this.balance = new BigDecimal(initialBalance);
    }

    // Method to deposit money
    public void deposit(String amount) {
        BigDecimal depositAmount = new BigDecimal(amount);
        balance = balance.add(depositAmount);
        System.out.println("Deposited: " + formatCurrency(depositAmount));
    }

    // Method to withdraw money
    public void withdraw(String amount) {
        BigDecimal withdrawAmount = new BigDecimal(amount);
        if (balance.compareTo(withdrawAmount) >= 0) {
            balance = balance.subtract(withdrawAmount);
            System.out.println("Withdrew: " + formatCurrency(withdrawAmount));
        } else {
            System.out.println("Insufficient funds for withdrawal!");
        }
    }

    // Format numbers with commas and currency symbols
    public String formatCurrency(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
    }

    public void displayBalance() {
        System.out.println(accountHolder + "'s Current Balance: " + formatCurrency(balance));
    }

    public static void main(String[] args) {
        // Example with a LOT of numbers
        BankAccount myAccount = new BankAccount("Alex", "1000000000.00"); // 1 Billion

        myAccount.displayBalance();
        myAccount.deposit("53"); // Adding half a billion and 75 cents
        myAccount.withdraw("200");
        
        myAccount.displayBalance();
    }
}
