import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
        private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    public void add(Card card) {
        this.hand.add(card);
    }
    public void print() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(hand);
    }

    public int compareTo(Hand hand) {
        int thisHandValue = 0;
        for (Card card : this.hand) {
            thisHandValue += card.getValue();
        }
        int thatCardValue = 0;
        for (Card card : hand.getHand()) {
            thatCardValue += card.getValue();
        }
        return thisHandValue - thatCardValue;
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void sortAgainstSuit() {
        Collections.sort(hand, new SortAgainstSuitAndValue());

    }
}
