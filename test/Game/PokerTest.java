
package Game;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PokerTest {

    private List<Card> cards ;
    private Hand h ;
    
    @Before
    public void setUp() {
       cards = new ArrayList();
       h = new Hand(cards);
    }

    @After
    public void tearDown() {
    }

 
        @Test
        public void straightTest() { 
            cards.add(new Card("Ace", "Spades"));
            cards.add(new Card("King", "Spades"));
            cards.add(new Card("Queen", "Clubs"));
            cards.add(new Card("Jack", "Spades"));
            cards.add(new Card("10", "Spades"));
            
            assertTrue(new Hand(cards).isStraight(cards));
    }
        
        @Test
        public void RoyalTest(){
           
           cards.add(new Card("Ace", "Spades"));
            cards.add(new Card("King", "Spades"));
            cards.add(new Card("Queen", "Spades"));
            cards.add(new Card("Jack", "Spades"));
            cards.add(new Card("10", "Spades"));
         
             
            assertTrue(new Hand(cards).isRoyalFlush(cards));
        }
        
        @Test
        public void FlushTest()
        {
            cards.add(new Card("4", "Spades"));
            cards.add(new Card("King", "Spades"));
            cards.add(new Card("Queen", "Spades"));
            cards.add(new Card("Jack", "Spades"));
            cards.add(new Card("10", "Spades"));
            
            assertTrue(new Hand(cards).isFlush(cards));
        }
        
       @Test
       public void StraightFlushTest()
       {
           cards.add(new Card("4", "Hearts"));
            cards.add(new Card("5", "Hearts"));
            cards.add(new Card("6", "Hearts"));
            cards.add(new Card("7", "Hearts"));
            cards.add(new Card("8", "Hearts"));
            
            assertTrue(new Hand(cards).isStraightFlush(cards));
       }
       
       @Test
       public void TwoOfAKindTest()
       {
           cards.add(new Card("4", "Hearts"));
            cards.add(new Card("4", "Hearts"));
            cards.add(new Card("6", "Clubs"));
            cards.add(new Card("7", "Hearts"));
            cards.add(new Card("8", "Hearts"));
            
            assertTrue(new Hand(cards).isPair(cards));
       }
       
      @Test
      public void ThreeOfAKindTest()
      {
          cards.add(new Card("4", "Hearts"));
            cards.add(new Card("4", "Clubs"));
            cards.add(new Card("4", "Diamonds"));
            cards.add(new Card("7", "Hearts"));
            cards.add(new Card("8", "Hearts"));
            
            assertTrue(new Hand(cards).isThreeOfAKind(cards));
      }
      
      @Test
      public void FourOfAKindTest()
      {
          cards.add(new Card("4", "Hearts"));
            cards.add(new Card("4", "Clubs"));
            cards.add(new Card("4", "Diamonds"));
            cards.add(new Card("4", "Spades"));
            cards.add(new Card("8", "Hearts"));
            
            assertTrue(new Hand(cards).isFourOfAKind(cards));
      }
        
      @Test
      public void TwoPairTest()
      {
          cards.add(new Card("4", "Hearts"));
            cards.add(new Card("4", "Clubs"));
            cards.add(new Card("5", "Diamonds"));
            cards.add(new Card("5", "Hearts"));
            cards.add(new Card("8", "Hearts"));
            
            assertTrue(new Hand(cards).isTwoPair(cards));
      }
      
      @Test
      public void FullHouseTest()
      {
          cards.add(new Card("4", "Hearts"));
            cards.add(new Card("4", "Clubs"));
            cards.add(new Card("4", "Diamonds"));
            cards.add(new Card("5", "Hearts"));
            cards.add(new Card("5", "Clubs"));
            
            assertTrue(new Hand(cards).isFullHouse(cards));
      }
}
