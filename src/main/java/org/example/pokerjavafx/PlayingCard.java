package org.example.pokerjavafx;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayingCard {
    public final char suit;
    public int value;
    public PlayingCard(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }
    public List<PlayingCard> makeDeck(char[] suits, int[] values) {
        return IntStream.range(0, suits.length)
                .boxed()
                .flatMap(suitIndex ->
                        IntStream.range(0, values.length)
                                .mapToObj(valueIndex -> new PlayingCard(suits[suitIndex], values[valueIndex]))
                )
                .collect(Collectors.toList());
    }
    public List<PlayingCard> dealHand(List<PlayingCard> pickCard){
        return new Random().ints(0, pickCard.size())
                .distinct()
                .limit(5)
                .mapToObj(pickCard::get)
                .collect(Collectors.toList());
    }

    public boolean isFlush(List<PlayingCard> dealtHand){
        char c = dealtHand.getFirst().suit;
        return dealtHand.stream().allMatch(card -> card.suit == c);
    }
    public int getValue(List<PlayingCard> dealtHand) {
        return dealtHand.stream().mapToInt(card -> card.value).sum();
    }

    public String getHearts(List<PlayingCard> dealtHand){
        return dealtHand.stream()
                .filter(card -> card.suit == 'H')
                .map(PlayingCard::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
    public boolean containsSpadeQueen(List<PlayingCard> dealtHand){
        return dealtHand.stream()
                .anyMatch(card -> card.suit == 'S' && card.value == 12);
    }
    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "Card: " + suit + value;
    }
}
