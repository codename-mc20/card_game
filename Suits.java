package cards;

public enum Suits {
	SPADES(0),
	DIAMONDS(1),
	CLUBS(2),
	HEARTS(3);
	
	private int val;
	
	public int getVal() { return this.val; }
	
	Suits(int val) {
		this.val = val;
	}
}
