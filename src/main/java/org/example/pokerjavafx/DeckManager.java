package org.example.pokerjavafx;

import java.util.List;

public class DeckManager {
    private PlayingCard p = new PlayingCard(' ', 0);
    private List<PlayingCard> deck;
    private List<PlayingCard> hand;
    char[] suit ={'S', 'H', 'D', 'C'};
    int[] values={1,2,3,4,5,6,7,8,9,10,11,12,13};
     public DeckManager(){
         deck = p.makeDeck(suit, values);
    }
    List<PlayingCard> dealHand(){
         hand = p.dealHand(deck);
         return hand;
    }
    boolean checkFlush(){
         return p.isFlush(hand);
    }
    String checkHearts(){
         return p.getHearts(hand);
    }
    boolean spadeQueen(){
         return p.containsSpadeQueen(hand);
    }
    int getSum(){
         return p.getValue(hand);
    }
}
