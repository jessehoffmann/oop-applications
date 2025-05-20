import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class Account {
    private String id;
    private String name;
    private ArrayList<Expense> expenses = new ArrayList<Expense>();

    public Account(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public void addExpense(Expense expense) {
        if (expense.getAccountId() == null || !expense.getAccountId().equals(this.id)) {
            expense.setAccountId(this.id);
        }
        expenses.add(expense);
    }

    public void removeExpense(Expense expense) {
        expenses.remove(expense);
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }

    public double getTotalExpenses() {
        return expenses.stream()
                .mapToDouble(expense -> expense.amount)
                .sum();
    }

    public String getAccountId() {
        return id;
    }

    public String getAccountName() {
        return name;
    }

    public void setAccountName(String name) {
        this.name = name;
    }
}