public class Card {
    private final CardSuit suit;
    private final int value;
    
    public Card(int value, CardSuit suit) {
        this.suit = suit;
        this.value = value;
    }
    
    public CardSuit getSuit() {
        return suit;
    }
    
    public int getValue() {
        return value;
    };
}
