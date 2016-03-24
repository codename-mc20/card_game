package war;

import java.util.ArrayList;
import java.util.Collections;

import cards.Card;
import cards.Deck;
import cards.Hand;

public class War {
	static ArrayList<Card> pile = new ArrayList<Card>();
	static Deck deck;
	
	static Hand hand1, hand2;
	
	public static void main(String[] args) {
		deck = new Deck();
		deck.shuffle();
		
		hand1 = new Hand();
		hand2 = new Hand();
		
		deal();
		
		System.out.println("Hand #1: " + hand1.getSize());
		System.out.println("Hand #2: " + hand2.getSize());
		System.out.println();
		
		int count = 0;
		
		while(hand1.getSize() != 0 && hand2.getSize() != 0) {
			Card a = hand1.getFirst();
			Card b = hand2.getFirst();
			
			addToPile(a,b);
			count++;
			
			System.out.println("Round #" + count);
			System.out.println(a + " vs " + b);
			
			Card winner = duel(a,b);
			System.out.println("Winner : " + winner);
			
			if(hand1.contains(winner)) {
				removeTop();
				for(Card c : pile) { hand1.draw(c); }
				pile.clear();
			} else if(hand2.contains(winner)) {
				removeTop();
				for(Card c : pile) { hand2.draw(c); }
				pile.clear();
			}
			
			System.out.println("Hand #1 : " + hand1.getSize());
			System.out.println("Hand #2 : " + hand2.getSize());
			System.out.println();
		}
		
		if(hand1.getSize() == 0) {
			System.out.println("THE WINNER IS : HAND #2");
		} else {
			System.out.println("THE WINNER IS : HAND #1");
		}
	}
	
	public static Card duel(Card a, Card b) {
		Card winner = null;
		
		if(a.getRank().getVal() > b.getRank().getVal()) {
			winner = a;
		} else if(a.getRank().getVal() < b.getRank().getVal()) {
			winner = b;
		} else if(a.getRank().getVal() == b.getRank().getVal()) {
			winner = war();
		}
		
		return winner;
	}
	
	public static Card war() {
		System.out.println("----- WAR -----");
		int warCountOne = 3;
		int warCountTwo = 3;
		
		if(hand1.getSize() <= 3) {
			warCountOne = hand1.getSize() - 1;
		}
		
		if(hand2.getSize() <= 3) {
			warCountTwo = hand1.getSize() - 1;
		}
		
		for(int i = 0; i < warCountOne; i++) {
			pile.add(hand1.getFirst());
			hand1.discard();
		}
		
		for(int i = 0; i < warCountTwo; i++) {
			pile.add(hand2.getFirst());
			hand2.discard();
		}
		
		return duel(hand1.getFirst(), hand2.getFirst());
	}
	
	private static void addToPile(Card... cards) {
		for(Card c : cards) { pile.add(c); }
		Collections.shuffle(pile);
	}
	
	private static void removeTop() {
		hand1.discard();
		hand2.discard();
	}
	
	private static void deal() {
		for(int i = 0; i < deck.getSize(); i++) {
			if((i%2) == 0) {
				hand1.draw(deck.getDeck().get(i));
			} else {
				hand2.draw(deck.getDeck().get(i));
			}
		}
	}

}
