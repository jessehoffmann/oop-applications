import java.util.ArrayList;
import java.util.List;

public class Hand {
    private ArrayList<Card> cards;
    private Integer score;

    public Hand() {
        this.score = 0;
        this.cards = new ArrayList<Card>();
    }

    public boolean isBust() {
        if (score > 21) {
            return true;
        }
        return false;
    }

    public void dealCard(Card card) {
        if (!isBust()) {
            this.score += card.getValue();
            cards.add(card);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotal() {
        return score;
    }
}
