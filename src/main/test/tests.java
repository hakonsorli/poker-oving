import org.example.pokerjavafx.PlayingCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class tests {
    PlayingCard playingCard = new PlayingCard(' ', 0);
    char[] suit ={'S', 'H', 'D', 'H'};
    int[] values={1,2,3,4,5,6,7,8,9,10,11,12,13};
    List<PlayingCard> deck = playingCard.makeDeck(suit, values);
    List<PlayingCard> hand = playingCard.dealHand(deck);

    @Test
    void fillDeckTest() {
        Assertions.assertEquals(52, deck.size());
    }
    @Test
    void giveHandTest(){
        Assertions.assertEquals(5, hand.size());
    }

}
