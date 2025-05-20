public class GameRound {
    private Player player;
    private Dealer dealer;
    private Deck deck;

    public GameRound(Player players, Dealer dealer, Deck deck) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.startRound();
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            player.dealCard();
            dealer.dealCard();
        }

        

    }

    private void startRound() {
        this.dealInitialCards()
    }
}
