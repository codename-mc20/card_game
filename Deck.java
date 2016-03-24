package cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck;
	
	public Deck() {
		this.deck = new ArrayList<Card>();
		
		for(Suits s : Suits.values()){
			for(Rank r : Rank.values()) {
				deck.add(new Card(r,s));
			}
		}
	}
	
	public ArrayList<Card> getDeck() {
		return this.deck;
	}

	public int getSize() {
		return this.deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(this.deck);
	}
	
	public Card draw() {
		if(!this.deck.isEmpty()) {
			Card c = this.deck.get(0);
			this.deck.remove(0);
			return c;
		}
		return null;
	}
	
	public Hand deal(int size) {
		if(size <= this.deck.size()) {
			Hand hand = new Hand();
			
			for(int i = 0; i < size; i++) {
				hand.draw(this.draw());
			}
			return hand;
		}
		return null;
	}
	
	public boolean contains(Card c) {
		if(this.deck.contains(c)) {
			return true;
		}
		return false;
	}
	
	public void printDeck() {
		System.out.println(deck);
	}
}
