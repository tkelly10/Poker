package Game;

import java.util.ArrayList;
import java.util.List;

public class PokerGameDriver {

    public static void main(String[] args) {

        List<Card> cards;
        Deck deck = new Deck();

        deck.createDeck();
        cards = new ArrayList();
    

        cards = new ArrayList<>();

        System.out.println("deck size: " + deck.cards.size());

        System.out.println();

        for (int i = 0; i < 5; i++) {
            cards.add(deck.cards.get(i));

        }

        Hand hand = new Hand(cards);

        hand.displayHand(cards);
        hand.isPair(cards);
        hand.isTwoPair(cards);
        hand.isThreeOfAKind(cards);
        hand.isFourOfAKind(cards);
        hand.isFlush(cards);
        hand.isFullHouse(cards);
        hand.isStraight(cards);
        hand.isStraightFlush(cards);
        hand.isRoyalFlush(cards);
        

        System.out.println(hand.displayHandResult());

    }
}
