import org.example.pokerjavafx.PlayingCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckTests {
    PlayingCard p = new PlayingCard(' ', 0);
    char[] flushSuit = {'H'}; char[] spades = {'S'};
    int [] flushValues = {1,2,3,4,5}; int[] spadeValues = {12,1,3,6,8};
    List<PlayingCard> flushDeck = p.makeDeck(flushSuit, flushValues);
    List<PlayingCard> flushHand = p.dealHand(flushDeck);

    List<PlayingCard> spadeDeck = p.makeDeck(spades, spadeValues);
    List<PlayingCard> spadeQHand = p.dealHand(spadeDeck);

    @Test
    void flushTest() {
        Assertions.assertTrue(p.isFlush(flushHand));
    }

    @Test
    void valueTest() {
        Assertions.assertEquals(15, p.getValue(flushHand));
        Assertions.assertEquals(24, p.getValue(spadeQHand));
    }

    @Test
    void spadeQueenTest() {
        Assertions.assertTrue(p.containsSpadeQueen(spadeQHand));
        Assertions.assertFalse(p.containsSpadeQueen(flushHand));
    }
}
