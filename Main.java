import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Expense Tracker Started");

        // Create an array to track multiple expenses
        ArrayList<Expense> expenses = new ArrayList<>();

        // Adding some basic expenses with unique categories
        // Will update this to allow user to input their own expenses
        expenses.add(new Expense("Coffee from Bird Rock", 6.27, "Food and Beverage"));
        expenses.add(new Expense("Movie tickets from Cinepolis", 34.99, "Entertainment"));
        expenses.add(new Expense("Clothing at Hansen", 85.50, "Shopping"));

        // Print all expenses
        System.out.println("\nAll expenses:");
        for (Expense e : expenses) {
            e.printDetails();
        }
    }
}