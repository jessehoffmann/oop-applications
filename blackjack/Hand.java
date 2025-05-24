import java.util.ArrayList;
import java.util.List;

public class Hand {
    private ArrayList<Card> cards;
    private int score;

    public Hand() {
        this.score = 0;
        this.cards = new ArrayList<Card>();
    }

    public boolean isBust() {
        return getTotal() > 21;
    }

    public void dealCard(Card card) {
        cards.add(card);
        updateScore();
    }

    public void clear() {
        cards.clear();
        score = 0;
    }

    private void updateScore() {
        score = 0;
        int aces = 0;
        
        // First count non-ace cards
        for (Card card : cards) {
            int value = card.getValue();
            if (value == 11) { // Ace
                aces++;
            } else if (value > 10) { // Face cards (J, Q, K)
                score += 10;
            } else {
                score += value;
            }
        }
        
        // Then add aces optimally
        for (int i = 0; i < aces; i++) {
            if (score + 11 <= 21) {
                score += 11;
            } else {
                score += 1;
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getTotal() {
        return score;
    }

    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "Empty hand";
        }
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
