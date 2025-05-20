import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ExpenseManager {
    private Scanner scanner;
    private Map<String, Account> accounts;
    private Account currentAccount;

    public ExpenseManager() {
        this.scanner = new Scanner(System.in);
        this.accounts = new HashMap<>();
        initializeDefaultAccount();
    }

    private void initializeDefaultAccount() {
        Account defaultAccount = new Account("Default Account");
        accounts.put(defaultAccount.getAccountId(), defaultAccount);
        currentAccount = defaultAccount;

        // Add sample expenses to default account
        currentAccount.addExpense(new Expense("Coffee from Bird Rock", 6.27, "Food and Beverage", currentAccount.getAccountId()));
        currentAccount.addExpense(new Expense("Movie tickets from Cinepolis", 34.99, "Entertainment", currentAccount.getAccountId()));
        currentAccount.addExpense(new Expense("Clothing at Hansen", 85.50, "Shopping", currentAccount.getAccountId()));
    }

    public void start() {
        System.out.println("\nExpense Tracker Started");

        while (true) {
            int choice = displayInputMenu();
            if (!processChoice(choice)) {
                break;
            }
        }
    }

    private int displayInputMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Add new expense");
        System.out.println("2. View all expenses");
        System.out.println("3. Create new account");
        System.out.println("4. Switch account");
        System.out.println("5. View account summary");
        System.out.println("6. Exit");
        System.out.print("Enter number for your choice (1-6): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                addNewExpense();
                return true;
                
            case 2:
                viewAllExpenses();
                return true;
                
            case 3:
                createNewAccount();
                return true;

            case 4:
                switchAccount();
                return true;

            case 5:
                viewAccountSummary();
                return true;
                
            case 6:
                System.out.println("Thank you for using Expense Tracker!");
                scanner.close();
                return false;
                
            default:
                System.out.println("Invalid choice. Please try again.");
                return true;
        }
    }

    private void addNewExpense() {
        if (currentAccount == null) {
            System.out.println("No account selected. Please create or select an account first.");
            return;
        }

        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        
        System.out.print("Enter expense amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();
        
        currentAccount.addExpense(new Expense(description, amount, category, currentAccount.getAccountId()));
        System.out.println("Expense added successfully to account: " + currentAccount.getAccountName());
    }

    private void viewAllExpenses() {
        if (currentAccount == null) {
            System.out.println("\nNo account selected. Please create or select an account first.");
            return;
        }

        List<Expense> expenses = currentAccount.getExpenses();
        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses recorded yet for account: " + currentAccount.getAccountName());
        } else {
            System.out.println("\nAll expenses for account: " + currentAccount.getAccountName());
            System.out.println("\n    Description    |    Amount    |     Category    ");
            System.out.println("————————————————————————————————————————————————————");
            for (Expense e : expenses) {
                e.printDetails();
            }
            System.out.println("\nTotal expenses: $" + currentAccount.getTotalExpenses());
        }
    }

    private void createNewAccount() {
        System.out.print("Enter new account name: ");
        String accountName = scanner.nextLine();
        
        Account newAccount = new Account(accountName);
        accounts.put(newAccount.getAccountId(), newAccount);
        currentAccount = newAccount;
        
        System.out.println("\nNew account created and selected: " + accountName);
    }

    private void switchAccount() {
        if (accounts.size() <= 1) {
            System.out.println("\nNo other accounts available to switch to.");
            return;
        }

        System.out.println("\nAvailable accounts:");
        int index = 1;
        for (Account account : accounts.values()) {
            System.out.println(index + ". " + account.getAccountName());
            index++;
        }

        System.out.print("\nEnter the number of the account to switch to: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= accounts.size()) {
            currentAccount = new ArrayList<>(accounts.values()).get(choice - 1);
            System.out.println("\nSwitched to account: " + currentAccount.getAccountName());
        } else {
            System.out.println("\nInvalid account selection.");
        }
    }

    private void viewAccountSummary() {
        if (currentAccount == null) {
            System.out.println("No account selected.");
            return;
        }

        System.out.println("\nAccount Summary for: " + currentAccount.getAccountName());
        System.out.println("Total Expenses: $" + currentAccount.getTotalExpenses());
        System.out.println("Number of Expenses: " + currentAccount.getExpenses().size());
    }
} 