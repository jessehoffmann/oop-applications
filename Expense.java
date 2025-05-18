import java.text.DecimalFormat;

public class Expense {
    String description;
    double amount;
    String category;
    String accountId;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Expense(String description, double amount, String category, String accountId) {
        this.description = description;
        this.amount = Double.parseDouble(df.format(amount));
        this.category = category;
        this.accountId = accountId;
    }

    public void printDetails() {
        System.out.println(description + " | $" + amount + " | " + category + " | Account: " + accountId);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
