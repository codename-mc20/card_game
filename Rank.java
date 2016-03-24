package cards;

public enum Rank {
	ACE(14),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(11),
	QUEEN(12),
	KING(13);
	
	private final int rank;
	
	public int getVal() { return this.rank; }
	
	Rank(int rank) {
		this.rank = rank;
	}
}
