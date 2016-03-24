package poker;

public enum PokerHand {
	ROYAL_FLUSH(10),
	STRAIGHT_FLUSH(9),
	FOUR_OF_A_KIND(8),
	FULL_HOUSE(7),
	FLUSH(6),
	STRAIGHT(5),
	THREE_OF_A_KIND(4),
	TWO_PAIRS(3),
	ONE_PAIR(2),
	HIGH_CARD(1);
	
	private final int val;
	
	public int getVal() {
		return this.val;
	}
	
	PokerHand(int val) {
		this.val = val;
	}
}
