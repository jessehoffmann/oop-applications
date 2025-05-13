import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\nExpense Tracker Started");

        // Add sample expenses
        expenses.add(new Expense("Coffee from Bird Rock", 6.27, "Food and Beverage"));
        expenses.add(new Expense("Movie tickets from Cinepolis", 34.99, "Entertainment"));
        expenses.add(new Expense("Clothing at Hansen", 85.50, "Shopping"));

        // Keep prompting for user input
        while (true) {
            int choice = displayInputMenu();
            if (!processChoice(choice)) {
                break;
            }
        }
    }

    private static int displayInputMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Add new expense");
        System.out.println("2. View all expenses");
        System.out.println("3. Exit");
        System.out.print("Enter number for your choice (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                addNewExpense();
                return true;
                
            case 2:
                viewAllExpenses();
                return true;
                
            case 3:
                System.out.println("Thank you for using Expense Tracker!");
                scanner.close();
                return false;
                
            default:
                System.out.println("Invalid choice. Please try again.");
                return true;
        }
    }

    private static void addNewExpense() {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        
        System.out.print("Enter expense amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();
        
        expenses.add(new Expense(description, amount, category));
        System.out.println("Expense added successfully!");
    }

    private static void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("\nAll expenses:");
            System.out.println("\n    Description    |    Amount    |     Category    ");
            System.out.println("————————————————————————————————————————————————————");
            // Use for each loop to list all expenses
            for (Expense e : expenses) {
                e.printDetails();
            }
        }
    }
} 