package org.example.pokerjavafx;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayingCard {
    public final char suit;
    public int value;

    public static void main(String[] args) {
        PlayingCard deck = new PlayingCard(' ', 0);
        char[] suit ={'S', 'H', 'D', 'H'};
        int[] values={1,2,3,4,5,6,7,8,9,10,11,12,13};
        List<PlayingCard> usableDeck = deck.makeDeck(suit, values);
        List<PlayingCard> dealtHand = deck.dealHand(usableDeck);
        System.out.println(dealtHand.toString());
        deck.checkAll(dealtHand);

    }

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
    public String checkAll(List<PlayingCard> dealtHand){
        System.out.println(isFlush(dealtHand));
        System.out.println(getValue(dealtHand));
        System.out.println(getHearts(dealtHand));
        System.out.println(containsSpadeQueen(dealtHand));
        return " ";

    }

    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "PlayingCard{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}
