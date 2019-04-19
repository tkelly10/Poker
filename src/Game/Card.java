package Game;


import java.util.Random;

public class Card {


    private String suit;
    private String rank;


    protected static final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades"
    };

    protected static final String[] RANKS = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };

    public Card(){

      this.suit = SUITS[getRandomArrayElement(SUITS)];
      this.rank = RANKS[getRandomArrayElement(RANKS)];
    }

    public Card(String card, String suit){
        
        this.rank = card;
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        
        return rank;
    }

    public void setRank(String rank) {
        
        this.rank = rank;
    }


    public final int getRandomArrayElement(String[] array)
    {
        Random rand = new Random();
        int index = rand.nextInt(array.length);
        return index;
    }

    @Override
    public String toString(){
//         switch(String.valueOf(this.rank))
//        {
//            case "11":
//                rank = "Jack";
//                break;
//            case "12":
//                rank = "Queen";
//                break;
//            case "13":
//                rank = "King";
//                break;
//            case "14":
//                rank = "Ace";
//                break;
//            default:
//               rank = this.rank;
//        }
       return this.rank + " of " + this.suit;
    }






}

