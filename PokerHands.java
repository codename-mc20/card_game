package poker;

import java.util.ArrayList;

import cards.Hand;

public class PokerHands {
	private Hand hand;
	
	PokerHands(Hand hand) {
		this.hand = hand;
	}
	
	public PokerHand returnRanking() {
		PokerHand winning = null;
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
		
		this.hand.sort();
		ArrayList<Integer> ranks = this.hand.countRank();
		
		for(int i = 2; i < ranks.size(); i++) {
			if(ranks.get(i) == 1) { count1++; }
			else if(ranks.get(i) == 2) { count2++; }
			else if(ranks.get(i) == 3) { count3++; }
			else if(ranks.get(i) == 4) { count4++; }
		}
		
		if(royal_flush(count1, hand)) {
			winning = PokerHand.ROYAL_FLUSH;
		} else if(straight_flush(count1, hand)) {
			winning = PokerHand.STRAIGHT_FLUSH;
		} else if(straight(count1, hand)) {
			winning = PokerHand.STRAIGHT;
		} else if(high_card(count1)) {
			winning = PokerHand.HIGH_CARD;
		} else if(one_pair(count2, count3)) {
			winning = PokerHand.ONE_PAIR;
		} else if(two_pairs(count2)) {
			winning = PokerHand.TWO_PAIRS;
		} else if(three_of_a_kind(count3)) {
			winning = PokerHand.THREE_OF_A_KIND;
		} else if(flush(hand)) {
			winning = PokerHand.FLUSH;
		} else if(full_house(count2, count3)) {
			winning = PokerHand.FULL_HOUSE;
		} else if(four_of_a_kind(count4)) {
			winning = PokerHand.FOUR_OF_A_KIND;
		}
		
		return winning;
	}

	private boolean four_of_a_kind(int i) {
		return (i == 1);
	}

	private boolean full_house(int i, int j) {
		return (i == 1 && j == 1);
	}

	private boolean flush(Hand hand) {
		ArrayList<Integer> suits = hand.countSuit();
		for(int i = 0; i < suits.size(); i++) {
			if(suits.get(i) == 5) { return true; }
		}
		return false;
	}

	private boolean three_of_a_kind(int i) {
		return (i == 1);
	}

	private boolean two_pairs(int i) {
		return (i == 2);
	}

	private boolean one_pair(int i, int j) {
		return (i == 1 && j == 0);
	}

	private boolean high_card(int i) {
		return (i == 5);
	}

	private boolean straight(int i, Hand hand) {
		if(high_card(i)) {
			hand.sort();
			int c1 = hand.getHand().get(0).getRank().getVal();
			int c2 = hand.getHand().get(1).getRank().getVal();
			int c3 = hand.getHand().get(2).getRank().getVal();
			int c4 = hand.getHand().get(3).getRank().getVal();
			int c5 = hand.getHand().get(4).getRank().getVal();
			
			if((c5-c4) == 1 && (c4-c3) == 1 && (c3-c2) == 1 && (c2-c1) == 1) {
				return true;
			}
			return false;
		}		
		return false;
	}

	private boolean royal_straight(int i, Hand hand) {
		if(high_card(i)) {
			hand.sort();
			int c1 = hand.getHand().get(0).getRank().getVal();
			int c2 = hand.getHand().get(1).getRank().getVal();
			int c3 = hand.getHand().get(2).getRank().getVal();
			int c4 = hand.getHand().get(3).getRank().getVal();
			int c5 = hand.getHand().get(4).getRank().getVal();
			
			if(c5 == 14 && c4 == 13 && c3 == 12 && c2 == 11 && c1 == 10) {
				return true;
			}
			return false;
		}		
		return false;
	}
	
	private boolean straight_flush(int i, Hand hand) {
		return (straight(i, hand) && flush(hand));
	}

	private boolean royal_flush(int i, Hand hand) {
		return (royal_straight(i, hand) && flush(hand));
	}

}
