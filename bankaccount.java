import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class bankaccount {
    private String owner;
    private BigDecimal balance;

    // Constructor using String to prevent precision loss
    public bankaccount(String owner, String startingBalance) {
        this.owner = owner;
        this.balance = new BigDecimal(startingBalance);
    }

    // Add money
    public void deposit(String amount) {
        BigDecimal toAdd = new BigDecimal(amount);
        this.balance = this.balance.add(toAdd);
        System.out.println("Success! Deposited: " + formatMoney(toAdd));
    }

    // Remove money
    public void withdraw(String amount) {
        BigDecimal toSubtract = new BigDecimal(amount);
        if (this.balance.compareTo(toSubtract) >= 0) {
            this.balance = this.balance.subtract(toSubtract);
            System.out.println("Success! Withdrew: " + formatMoney(toSubtract));
        } else {
            System.out.println("Transaction Denied: Insufficient funds.");
        }
    }

    // Helper to make huge numbers readable (adds commas and $)
    private String formatMoney(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
    }

    public void showStatus() {
        System.out.println("------------------------------------");
        System.out.println("Account Owner: " + owner);
        System.out.println("Current Balance: " + formatMoney(balance));
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        // Initializing with 10 Billion dollars
        bankaccount myAccount = new bankaccount("Elon Musk", "10000000000.00");

        myAccount.showStatus();
        
        // Depositing a massive amount with specific cents
        myAccount.deposit("5000000000.85"); 
        
        myAccount.withdraw("1200.50");

        myAccount.showStatus();
    }
}
