package poker;

import java.util.ArrayList;

import cards.Card;
import cards.Deck;
import cards.Hand;

public class Poker {
	static Deck deck;
	static Hand hand1, hand2;
	static ArrayList<Card> pile = new ArrayList<Card>();
	
	public static void main(String[] args) {
		deck = new Deck();
		deck.shuffle();
		
		hand1 = new Hand();	hand2 = new Hand();
		
		deal(10);
		
		hand1.sort(); hand2.sort();
		hand1.displayhand(); hand2.displayhand();
		
		System.out.println();
		
		PokerHands phand1 = new PokerHands(hand1);
		PokerHands phand2 = new PokerHands(hand2);
		
		PokerHand ph1 = phand1.returnRanking();
		PokerHand ph2 = phand2.returnRanking();
		
		System.out.println("Hand #1 - " + ph1);
		System.out.println("Hand #2 - " + ph2);
		
		System.out.println();
		System.out.println("The winner is " + winner(ph1, ph2));
	}
	
	private static PokerHand winner(PokerHand h1, PokerHand h2) {
		PokerHand winner = null;
		int winningHand = 0;
		
		if(h1.getVal() > h2.getVal()) {
			winner = h1;
		} else if(h1.getVal() < h2.getVal()) {
			winner = h2;
		} else if(h1.getVal() == h2.getVal()) {
			winningHand = matched(hand1, hand2, h1);
			
			if(winningHand == 1) {
				winner = h1;
			} else {
				winner = h2;
			}
		}
		return winner;
	}

	private static int matched(Hand hand12, Hand hand22, PokerHand h1) {
		return 0;
	}

	public static void deal(int n) {
		for(int i = 0; i < n; i++) {
			if((i%2) == 0) {
				hand1.draw(deck.getDeck().get(i));
			} else {
				hand2.draw(deck.getDeck().get(i));
			}
		}
	}

}
