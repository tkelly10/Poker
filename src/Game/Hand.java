package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements HandChecker {

    protected List<Card> cards;
    private boolean isPair;
    private boolean isThreeOfAKind;
    private boolean isFourOfAKind;
    private boolean isTwoPair;
    private boolean isFlush;
    private boolean isFullHouse;
    private boolean isStraight;
    private boolean isStraightFlush;
    private boolean isRoyalFlush;
    int pairCount;


    public Hand(List<Card> cards){
        cards = new ArrayList();
        this.cards = cards;
    }
    
        public void displayHand(List<Card> cards){
            this.cards = cards;
            for (Card card : cards){
                System.out.println(card.toString());
            }

            System.out.println("\n----------------------");
        }


            @Override
            public boolean isPair(List<Card> cards) {
                this.cards = cards;
                this.isPair = false;
                this.pairCount = 0;

                int matches;
                List<String> cardList = new ArrayList();

                for (Card card : cards) {
                    cardList.add(card.getRank());
                }

                for (int i = 0; i < Card.RANKS.length; i++) {
                    matches = Collections.frequency(cardList, Card.RANKS[i]);

                    if (matches == 2) {
                        isPair = true;
                        pairCount++;
                    }


                }

                
                return this.isPair;
            }

                @Override
                public boolean isThreeOfAKind(List<Card> cards) {

                    this.cards = cards;
                    this.isThreeOfAKind = false;

                    int matches;
                    List<String> cardList = new ArrayList();

                    for (Card card : cards) {
                        cardList.add(card.getRank());
                    }

                    for (int i = 0; i < Card.RANKS.length; i++) {
                        matches = Collections.frequency(cardList, Card.RANKS[i]);

                        if (matches == 3) {
                            this.isThreeOfAKind = true;
                        }


                    }
                    return this.isThreeOfAKind;
                }

                @Override
                public boolean isFourOfAKind(List<Card> cards){

                    this.cards = cards;
                    this.isFourOfAKind = false;

                    int matches = 0;
                    List<String> cardList = new ArrayList();

                    for (Card card : cards) {
                        cardList.add(card.getRank());
                    }

                    for (int i = 0; i < Card.RANKS.length; i++) {
                        matches = Collections.frequency(cardList, Card.RANKS[i]);

                        if (matches == 4) {
                            this.isFourOfAKind = true;
                        }

                    }

                    return this.isFourOfAKind;

            }
                
            @Override
            public boolean isStraight(List<Card> cards)
            {
                this.cards = cards;
                this.isStraight = false;
                int matches = 0;


                List<Integer> newCardList = new ArrayList();
                for(Card card : cards)
                {
                    int value = convertCardsToInteger(card);
                    newCardList.add(value);
                }

                Collections.sort(newCardList);

                for(int i = 0; i < newCardList.size()-1; i++)
                {
                    if(newCardList.get(i)+1 == newCardList.get(i+1))
                    {
                        matches++;
                    }
                    
                    if(matches == 4)
                    {
                        this.isStraight = true;
                    }
                }


               return this.isStraight;
            }

            @Override
            public boolean isStraightFlush(List<Card> cards){
                this.isStraightFlush = false;

                if(this.isStraight && this.isFlush)
                {
                    this.isStraightFlush = true;
                }
                return this.isStraightFlush;
            }

            @Override
            public boolean isRoyalFlush(List<Card> cards){
                this.isRoyalFlush = false;
                isFlush(cards);
                if(this.isFlush && containsHighCard(cards))
                {
                    isRoyalFlush = true;
                }
                
                return this.isRoyalFlush;
            }

            @Override
            public boolean isFlush(List<Card> cards){
                this.cards = cards;
                this.isFlush = false;

                int matches = 0;
                List<String> cardList = new ArrayList();

                for (Card card : cards) {
                    cardList.add(card.getSuit());
                }

                for (int i = 0; i < Card.SUITS.length; i++) {
                    matches = Collections.frequency(cardList, Card.SUITS[i]);

                    if (matches == 5) {
                        this.isFlush = true;
                    }

                }
                return this.isFlush;
            }

            @Override
            public boolean isFullHouse(List<Card> cards){

                    if(this.isPair && this.isThreeOfAKind){
                        this.isFullHouse= true;
                    }

                return this.isFullHouse;
            }

            @Override
            public boolean isTwoPair(List<Card> cards){

                this.isTwoPair = false;


                    if(this.pairCount == 2){
                        this.isTwoPair= true;
                    }

                return this.isTwoPair;
            }



            public String displayHandResult(){
                String result;
                
                if(this.isRoyalFlush){
                    result = "Royal Flush";
                }else if(this.isStraightFlush){
                    result = "Straight Flush";
                }else if(this.isStraight){
                    result = "Straight";
                }else if(this.isFlush){
                   result = "Flush";
               }else if(this.isFullHouse){
                   result = "Full House";
               }else if(this.isTwoPair){
                   result = "Two Pair";
               }else if(this.isFourOfAKind){
                   result = "Four of a Kind";
               }else if(this.isThreeOfAKind){
                   result = "Three of a Kind";
               }else if(this.isPair){
                   result = "Pair";
               }else{
                   result = "High Card " + displayHighCard();
               }
             
               return result;
            }
            
            
       public int convertCardsToInteger(Card card)
       {
           this.cards = cards;
           int value = 0;
          
          
               switch(card.getRank())
               {
                   case "Jack":
                       value = 11;
                       break;
                   case "Queen":
                       value = 12;
                       break;
                   case "King":
                       value = 13;
                       break;
                    case"Ace":
                        value = 14;
                        break;
                    default:
                        value = Integer.parseInt(card.getRank());
               
           }
       
            return value;
       }
       
       public String displayHighCard()
       {
          this.cards = cards;
         int flag = 0;
            List<Integer> newCardList = new ArrayList();
            
                for(Card c : cards)
                {
                    int value = convertCardsToInteger(c);
                    newCardList.add(value);
                }
                
                Collections.sort(newCardList);
            
                
                    String s = "";
                   flag = newCardList.get(4);
                   
                    switch(flag)
                        {
                      case 11:
                          s = "Jack";
                          break;
                      case 12:
                          s = "Queen";
                          break;
                      case 13:
                          s = "King";
                          break;
                      case 14:
                           s = "Ace";
                           break;
                      default:
                          s = Integer.toString(flag);
                          }
                  
                  
              
                
                return s;
                
                
       }
       
       public boolean containsHighCard(List<Card> cards)
       {
           List<Integer>highCard = new ArrayList();
           this.cards = cards;
           
           boolean isRoyal = false;
           for(Card card : this.cards)
           {
               int value = convertCardsToInteger(card);
               highCard.add(value);
               
           }
            if(highCard.contains(10) && highCard.contains(11) && highCard.contains(12) && highCard.contains(13)
                        && highCard.contains(14))
                {
                   isRoyal = true;
                }
            
            return isRoyal;
       }
       
        
    }




