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
    }

    @Override
    public String toString() {
        String valueStr;
        switch (value) {
            case 11: valueStr = "A"; break;
            case 12: valueStr = "J"; break;
            case 13: valueStr = "Q"; break;
            case 14: valueStr = "K"; break;
            default: valueStr = String.valueOf(value);
        }
        return valueStr + suit.toString();
    }
}
