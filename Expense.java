import java.text.DecimalFormat;

public class Expense {
    String description;
    double amount;
    String category;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = Double.parseDouble(df.format(amount));
        this.category = category;
    }

    public void printDetails() {
        System.out.println(description + " | $" + amount + " | " + category);
    }
}
