import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    private Random random = new Random();

    public Deck() { 
        for (int i = 2; i < 15; i++) {
            for (CardSuit suit : CardSuit.values()) {
                cards.add(new Card(i, suit));
            }
        }
    }
    
    public Card dealCard() {
        return cards.remove(0);
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int j = random.nextInt(51);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }
}
