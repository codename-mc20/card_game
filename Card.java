package cards;

public class Card {
	private final Rank rank;
	private final Suits suit;
	
	public Card(Rank rank, Suits suit) {
		this.suit = suit;
		this.rank = rank;
	}

	public Rank getRank() {
		return rank;
	}

	public Suits getSuit() {
		return suit;
	}

	public String toString() {
		return this.rank + " of " + this.suit;
	}
	
	public boolean sameSuit(Card c) {
		if(this.getSuit().getVal() == c.getSuit().getVal()) {
			return true;
		}
		return false;
	}
	
	public boolean sameRank(Card c) {
		if(this.getRank().getVal() == c.getRank().getVal()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Card) {
			Card other = (Card) o;
			return this.sameRank(other) && this.sameSuit(other);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.rank.hashCode() + this.suit.hashCode();
	}
}
