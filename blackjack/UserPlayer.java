public class UserPlayer extends Player {
    private int balance;

    public UserPlayer(int balance, Hand hand) {
        super(hand);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void updateBalance(int amount) {
        this.balance += amount;
    }

    @Override
    public boolean makeMove() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("\nYour current hand: " + getHand());
        System.out.println("Current total: " + getHand().getTotal());
        System.out.println("Would you like to hit? (y/n)");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("y");
    }
} 