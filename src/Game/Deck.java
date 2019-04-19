package Game;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    List<Card> cards;

    public Deck() {
        cards = new ArrayList();

    }

    public void createDeck() {

        int count = 0;

        while (count <= 51) {
            Card card = new Card();
            if (!cardExistsInDeck(card)) {
                cards.add(card);
                count++;
            }

        }
    }

    public boolean cardExistsInDeck(Card card) {
        boolean cardExists = false;

        for (Card c : cards) {
            if (c.getRank().equals(card.getRank()) && c.getSuit().equals(card.getSuit())) {
                cardExists = true;
            }

        }

        return cardExists;
    }
}
