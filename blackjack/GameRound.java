public class GameRound {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private int betAmount;

    public GameRound(Player player, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
    }

    private void dealInitialCards() {
        // Clear previous hands
        player.getHand().clear();
        dealer.getHand().clear();
        
        // Deal initial cards
        for (int i = 0; i < 2; i++) {
            player.dealCard(deck.drawCard());
            dealer.dealCard(deck.drawCard());
        }
        
        // Show initial state
        System.out.println("\n=== New Round ===");
        System.out.println("Dealer's visible card: " + dealer.getHand().getCards().get(0));
        System.out.println("Your hand: " + player.getHand());
        System.out.println("Your total: " + player.getHand().getTotal());
    }

    public void play() {
        this.dealInitialCards();
        
        // Player's turn
        while (player.makeMove()) {
            player.dealCard(deck.drawCard());
            System.out.println("\nYour new card: " + player.getHand().getCards().get(player.getHand().getCards().size() - 1));
            System.out.println("Your total: " + player.getHand().getTotal());
            
            if (player.getHand().isBust()) {
                System.out.println("\nPlayer busts! Dealer wins.");
                ((UserPlayer)player).updateBalance(-betAmount);
                return;
            }
        }

        // Dealer's turn
        System.out.println("\nDealer's turn");
        System.out.println("Dealer's full hand: " + dealer.getHand());
        while (dealer.makeMove()) {
            dealer.dealCard(deck.drawCard());
            System.out.println("Dealer draws: " + dealer.getHand().getCards().get(dealer.getHand().getCards().size() - 1));
            System.out.println("Dealer's total: " + dealer.getHand().getTotal());
            
            if (dealer.getHand().isBust()) {
                System.out.println("\nDealer busts! Player wins!");
                ((UserPlayer)player).updateBalance(betAmount);
                return;
            }
        }

        checkWinner();
    }

    private void checkWinner() {
        int playerScore = player.getHand().getTotal();
        int dealerScore = dealer.getHand().getTotal();
        
        System.out.println("\n=== Round Results ===");
        System.out.println("Player's final hand: " + player.getHand());
        System.out.println("Player's total: " + playerScore);
        System.out.println("Dealer's final hand: " + dealer.getHand());
        System.out.println("Dealer's total: " + dealerScore);

        if (playerScore > dealerScore) {
            System.out.println("Player wins!");
            ((UserPlayer)player).updateBalance(betAmount);
        } else if (dealerScore > playerScore) {
            System.out.println("Dealer wins!");
            ((UserPlayer)player).updateBalance(-betAmount);
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void setBetAmount(int amount) {
        this.betAmount = amount;
    }
}
