package org.example.pokerjavafx;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

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
    public StackPane cardGraphic(PlayingCard card) {StackPane cardPane = new StackPane();
        Rectangle rectangle = new Rectangle(70, 100);
        rectangle.setFill(Color.CORNSILK);
        rectangle.setStroke(Color.DARKGREY);

        String cardValue = cardValueDisplay(card);
        Text text = new Text(cardValue);
        text.setFill(getSuitColor(card));

        cardPane.getChildren().addAll(rectangle, text);
        return cardPane;
                    }
    private Color getSuitColor(PlayingCard card){
         return (card.suit == 'H' || card.suit == 'D') ? Color.RED : Color.BLACK;
    }
    private String cardValueDisplay(PlayingCard card){
        return switch (card.value) {
            case 1 -> "A" + card.suit;
            case 11 -> "J" + card.suit;
            case 12 -> "Q" + card.suit;
            case 13 -> "K" + card.suit;
            default -> card.value + "" + card.suit;
        };
    }

}
