package cards;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	private ArrayList<Integer> rankList;
	private ArrayList<Integer> suitList;
	
	public Hand() {
		hand = new ArrayList<Card>();
		rankList = new ArrayList<Integer>();
		suitList = new ArrayList<Integer>();
	}
	
	public ArrayList<Card> getHand() { return this.hand; }
	
	public int getSize() { return this.hand.size(); }
	
	public void draw(Card c) { this.hand.add(c); }
	
	public void discard() {
		if(!this.hand.isEmpty()) {
			this.hand.remove(0);
		}
	}
	
	public void displayhand() {
		System.out.println(this.hand);
	}
	
	public boolean contains(Card c) {
		if(this.hand.contains(c)) {
			return true;
		}
		return false;
	}
	
	public void sort() {
		Card l;
		for(int i = 0; i < this.hand.size(); i++) {
			for(int j = 0; j < this.hand.size(); j++) {
				if(this.getHand().get(i).getRank().getVal() < this.getHand().get(j).getRank().getVal()) {
					l = this.getHand().get(j);
					this.getHand().set(j, this.getHand().get(i));
					this.getHand().set(i, l);
				}
			}
		}
	}
	
	public Card getFirst() {
		return this.hand.get(0);
	}
	
	public ArrayList<Integer> countRank() {
		for(int i = 0; i < 15; i++) { this.rankList.add(i, 0); }
		
		for(int i = 0; i < this.getSize(); i++) {
			this.rankList.set(this.getHand().get(i).getRank().getVal(), this.rankList.get(this.getHand().get(i).getRank().getVal())+1);
		}
		return this.rankList;
	}
	
	public ArrayList<Integer> countSuit() {
		for(int i = 0; i < 4; i++) { this.suitList.add(i, 0); }
		
		for(int i = 0; i < this.getSize(); i++) {
			this.suitList.set(this.getHand().get(i).getSuit().getVal(), this.suitList.get(this.getHand().get(i).getSuit().getVal())+1);
		}
		return this.suitList;
	}
	
	public Card getHighCard() {
		Card highest = this.getHand().get(0);
		
		for(int i = 1; i < this.getSize(); i++) {
			if(highest.getRank().getVal() < this.getHand().get(i).getRank().getVal()) {
				highest = this.getHand().get(i);
			}
		}
		
		return highest;
	}
	
	public int getIndex(int value) {
		return this.countRank().indexOf(value);
	}
}
