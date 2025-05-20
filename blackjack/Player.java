abstract class Player {
    private Hand hand;

    public Player(Hand hand) {
        this.hand = hand;
    }

    abstract boolean makeMove();
}
