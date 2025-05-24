abstract class Player {
    private Hand hand;

    public Player(Hand hand) {
        this.hand = hand;
    }

    abstract boolean makeMove();

    public Hand getHand() {
        return hand;
    }

    public void dealCard(Card card) {
        hand.dealCard(card);
    }
}
