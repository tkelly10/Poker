package Game;


import java.util.List;

public interface HandChecker {


   
   boolean isPair(List<Card> cards);
   boolean isThreeOfAKind(List<Card> cards);
   boolean isFourOfAKind(List<Card> cards);
   boolean isTwoPair(List<Card> cards);
   boolean isFlush(List<Card> cards);
   boolean isFullHouse(List<Card> cards);
   boolean isStraight(List<Card> cards);
   boolean isStraightFlush(List<Card> cards);
   boolean isRoyalFlush(List<Card> cards);




}