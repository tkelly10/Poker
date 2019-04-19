
package Game;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
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
}
//    @Test
//    public void fourOfAKind() {
//        h.addCard("A", "S");
//        h.addCard("A", "C");
//        h.addCard("A", "D");
//        h.addCard("A", "H");
//        h.addCard("5", "C");
//
//        assertEquals("Four of a Kind", h.getHandName());
//    }
//
//    @Test
//    public void threeOfAKind() {
//        h.addCard("A", "S");
//        h.addCard("A", "C");
//        h.addCard("A", "D");
//        h.addCard("8", "H");
//        h.addCard("5", "C");
//
//        assertEquals("Three of a Kind", h.getHandName());
//    }
//
//    @Test
//    public void fullHouse() {
//        h.addCard("A", "S");
//        h.addCard("A", "C");
//        h.addCard("A", "D");
//        h.addCard("8", "H");
//        h.addCard("8", "C");
//
//        assertEquals("Full House", h.getHandName());
//    }
//}
