package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	@Test
	public void testConstructor() { 
		Deck x = new Deck();
		Card y = new Card(1,0);
		Card b = new Card(13,3);
		assertTrue(x.getCardAt(0).getValue() == y.getValue());
		assertTrue(x.getCardAt(51).getValue() == b.getValue());
		assertTrue(x.getCardAt(0).getSuit() == y.getSuit());
		assertTrue(x.getCardAt(51).getSuit() == b.getSuit());
	}
	
	@Test
	public void testCopyConstructor() { 
		Deck x = new Deck();
		Deck a = new Deck(x);
		assertTrue(x.getCardAt(0).getValue() == a.getCardAt(0).getValue());
		assertTrue(x.getCardAt(51).getValue() == a.getCardAt(51).getValue());
		assertTrue(x.getCardAt(0).getSuit() == a.getCardAt(0).getSuit());
		assertTrue(x.getCardAt(51).getSuit() == a.getCardAt(51).getSuit());
	}
	
	@Test
	public void testGetCardAt() {  
		Deck x = new Deck();
		Deck a = new Deck();
		assertTrue(x.getCardAt(0).getValue() == a.getCardAt(0).getValue()
				&& x.getCardAt(0).getSuit() == a.getCardAt(0).getSuit());
		assertTrue(x.getCardAt(51).getValue() == a.getCardAt(51).getValue()
				&& x.getCardAt(51).getSuit() == a.getCardAt(51).getSuit());
	}
	
	@Test
	public void testGetNumCards() {
		Deck x = new Deck();
		assertTrue(x.getNumCards() == 52);
	}
	
	@Test
	public void testShuffle() {  
		Deck x = new Deck();
		x.shuffle();
		Card a = new Card(1,0);
		Card b = new Card(1,2);
		Card c = new Card(2,0);
		Card d = new Card(2,2);
		Card a1 = new Card(13,3);
		Card b1 = new Card(13,1);
		Card c1 = new Card(12,3);
		Card d1 = new Card(12,1);	
		Card e = new Card(13,2);
		Card e1 = new Card(1,1);
		assertTrue(x.getCardAt(0).getValue() == a.getValue()
				&& x.getCardAt(0).getSuit() == a.getSuit());
		assertTrue(x.getCardAt(1).getValue() == b.getValue()
				&& x.getCardAt(1).getSuit() == b.getSuit());
		assertTrue(x.getCardAt(2).getValue() == c.getValue()
				&& x.getCardAt(2).getSuit() == c.getSuit());
		assertTrue(x.getCardAt(3).getValue() == d.getValue()
				&& x.getCardAt(3).getSuit() == d.getSuit());
		assertTrue(x.getCardAt(51).getValue() == a1.getValue()
				&& x.getCardAt(51).getSuit() == a1.getSuit());
		assertTrue(x.getCardAt(50).getValue() == b1.getValue()
				&& x.getCardAt(50).getSuit() == b1.getSuit());
		assertTrue(x.getCardAt(49).getValue() == c1.getValue()
				&& x.getCardAt(49).getSuit() == c1.getSuit());
		assertTrue(x.getCardAt(48).getValue() == d1.getValue()
				&& x.getCardAt(48).getSuit() == d1.getSuit());
		assertTrue(x.getCardAt(25).getValue() == e.getValue()
				&& x.getCardAt(25).getSuit() == e.getSuit());
		assertTrue(x.getCardAt(26).getValue() == e1.getValue()
				&& x.getCardAt(26).getSuit() == e1.getSuit());
	}
	
	@Test
	public void testCut() { 
		Deck x = new Deck();
		x.cut(4);
		Card a = new Card(5,0);
		Card b = new Card(6,0);
		Card c = new Card(7,0);
		Card d = new Card(8,0);
		assertTrue(x.getCardAt(0).getValue() == a.getValue()
				&& x.getCardAt(0).getSuit() == a.getSuit());
		assertTrue(x.getCardAt(1).getValue() == b.getValue()
				&& x.getCardAt(1).getSuit() == b.getSuit());
		assertTrue(x.getCardAt(2).getValue() == c.getValue()
				&& x.getCardAt(2).getSuit() == c.getSuit());
		assertTrue(x.getCardAt(3).getValue() == d.getValue()
				&& x.getCardAt(3).getSuit() == d.getSuit());
	}
	
	@Test
	public void testDeal() {
		Deck x = new Deck();
		Card[] dealtCards = new Card[4];
		dealtCards = x.deal(4);
		Card a = new Card(1, 0);
		Card b = new Card(2, 0);
		Card c = new Card(3, 0);
		Card d = new Card(4, 0);
		assertTrue(x.getNumCards() == 48);
		assertTrue(dealtCards[0].getValue() == a.getValue()
				&& dealtCards[0].getSuit() == a.getSuit());
		assertTrue(dealtCards[1].getValue() == b.getValue()
				&& dealtCards[1].getSuit() == b.getSuit());
		assertTrue(dealtCards[2].getValue() == c.getValue()
				&& dealtCards[2].getSuit() == c.getSuit());
		assertTrue(dealtCards[3].getValue() == d.getValue()
				&& dealtCards[3].getSuit() == d.getSuit());
	}
	
	@Test
	public void testHasPair() { 
		Card[] inHand = new Card[5];
		inHand[0] = new Card(5, 0);
		inHand[1] = new Card(7, 3);
		inHand[2] = new Card(7, 1);
		inHand[3] = new Card(12, 1);
		inHand[4] = new Card(9, 2);
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(5, 0);
		inHand2[1] = new Card(7, 3);
		inHand2[2] = new Card(2, 1);
		inHand2[3] = new Card(12, 1);
		inHand2[4] = new Card(9, 2);
		Card[] inHand3 = new Card[5];
		inHand3[0] = new Card(13, 0);
		inHand3[1] = new Card(7, 3);
		inHand3[2] = new Card(7, 1);
		inHand3[3] = new Card(13, 1);
		inHand3[4] = new Card(9, 2);
		Card[] inHand4 = new Card[5];
		inHand4[0] = new Card(1, 0);
		inHand4[1] = new Card(7, 3);
		inHand4[2] = new Card(2, 1);
		inHand4[3] = new Card(13, 1);
		inHand4[4] = new Card(9, 2);
		assertTrue(PokerHandEvaluator.hasPair(inHand) == true);
		assertTrue(PokerHandEvaluator.hasPair(inHand2) == false);
		assertTrue(PokerHandEvaluator.hasPair(inHand3) == true);
		assertTrue(PokerHandEvaluator.hasPair(inHand4) == false);
	}
	
	@Test
	public void testHasTwoPair() { 
		Card[] inHand = new Card[5];
		inHand[0] = new Card(5, 0);
		inHand[1] = new Card(7, 3);
		inHand[2] = new Card(7, 1);
		inHand[3] = new Card(12, 1);
		inHand[4] = new Card(5, 2);
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(5, 0);
		inHand2[1] = new Card(7, 3);
		inHand2[2] = new Card(2, 1);
		inHand2[3] = new Card(12, 1);
		inHand2[4] = new Card(9, 2);
		Card[] inHand3 = new Card[5];
		inHand3[0] = new Card(13, 0);
		inHand3[1] = new Card(12, 3);
		inHand3[2] = new Card(7, 1);
		inHand3[3] = new Card(12, 1);
		inHand3[4] = new Card(13, 2);
		Card[] inHand4 = new Card[5];
		inHand4[0] = new Card(7, 0);
		inHand4[1] = new Card(7, 3);
		inHand4[2] = new Card(7, 1);
		inHand4[3] = new Card(12, 1);
		inHand4[4] = new Card(7, 2);
		assertTrue(PokerHandEvaluator.hasTwoPair(inHand) == true);
		assertTrue(PokerHandEvaluator.hasTwoPair(inHand3) == true);
		assertTrue(PokerHandEvaluator.hasTwoPair(inHand2) == false);
		assertTrue(PokerHandEvaluator.hasTwoPair(inHand4) == false);
	}
	
	@Test
	public void testHasStraightFlush() {  
		Card[] inHand = new Card[5];
		inHand[0] = new Card(3, 0);
		inHand[1] = new Card(2, 0);
		inHand[2] = new Card(1, 0);
		inHand[3] = new Card(4, 0);
		inHand[4] = new Card(5, 0);
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(5, 0);
		inHand2[1] = new Card(5, 3);
		inHand2[2] = new Card(5, 1);
		inHand2[3] = new Card(5, 1);
		inHand2[4] = new Card(5, 2);
		Card[] inHand3 = new Card[5];
		inHand3[0] = new Card(10, 3);
		inHand3[1] = new Card(1, 3);
		inHand3[2] = new Card(13, 3);
		inHand3[3] = new Card(12, 3);
		inHand3[4] = new Card(11, 3);
		Card[] inHand4 = new Card[5];
		inHand4[0] = new Card(4, 2);
		inHand4[1] = new Card(5, 2);
		inHand4[2] = new Card(7, 2);
		inHand4[3] = new Card(6, 2);
		inHand4[4] = new Card(9, 2);
		assertTrue(PokerHandEvaluator.hasStraightFlush(inHand) == true);
		assertTrue(PokerHandEvaluator.hasStraightFlush(inHand2) == false);
		assertTrue(PokerHandEvaluator.hasStraightFlush(inHand3) == true);
		assertTrue(PokerHandEvaluator.hasStraightFlush(inHand4) == false);
	}
	
	@Test
	public void testHasThreeOfAKind() { 
		Card[] inHand = new Card[5];
		inHand[0] = new Card(5, 3);
		inHand[1] = new Card(6, 2);
		inHand[2] = new Card(2, 1);
		inHand[3] = new Card(5, 3);
		inHand[4] = new Card(5, 0);
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(5, 0);
		inHand2[1] = new Card(7, 3);
		inHand2[2] = new Card(2, 1);
		inHand2[3] = new Card(12, 1);
		inHand2[4] = new Card(9, 2);
		Card[] inHand3 = new Card[5];
		inHand3[0] = new Card(2, 3);
		inHand3[1] = new Card(6, 2);
		inHand3[2] = new Card(1, 1);
		inHand3[3] = new Card(6, 3);
		inHand3[4] = new Card(6, 0);
		Card[] inHand4 = new Card[5];
		inHand4[0] = new Card(2, 3);
		inHand4[1] = new Card(5, 2);
		inHand4[2] = new Card(7, 1);
		inHand4[3] = new Card(1, 3);
		inHand4[4] = new Card(8, 0);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(inHand) == true);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(inHand2) == false);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(inHand3) == true);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(inHand4) == false);
	}
	
	@Test
	public void testHasFourOfAKind() { 
		Card[] inHand = new Card[5];
		inHand[0] = new Card(4, 3);
		inHand[1] = new Card(7, 2);
		inHand[2] = new Card(7, 1);
		inHand[3] = new Card(7, 3);
		inHand[4] = new Card(7, 0);
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(5, 0);
		inHand2[1] = new Card(7, 3);
		inHand2[2] = new Card(2, 1);
		inHand2[3] = new Card(12, 1);
		inHand2[4] = new Card(9, 2);
		Card[] inHand3 = new Card[5];
		inHand3[0] = new Card(6, 3);
		inHand3[1] = new Card(6, 2);
		inHand3[2] = new Card(13, 1);
		inHand3[3] = new Card(6, 3);
		inHand3[4] = new Card(6, 0);
		Card[] inHand4 = new Card[5];
		inHand4[0] = new Card(13, 3);
		inHand4[1] = new Card(2, 2);
		inHand4[2] = new Card(13, 1);
		inHand4[3] = new Card(13, 3);
		inHand4[4] = new Card(5, 0);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(inHand) == true);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(inHand2) == false);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(inHand3) == true);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(inHand4) == false);
	}
	
	@Test
	public void testHasFlush() { 
		Card[] inHand = new Card[5];
		inHand[0] = new Card(4, 0);
		inHand[1] = new Card(6, 0);
		inHand[2] = new Card(3, 0);
		inHand[3] = new Card(2, 0);
		inHand[4] = new Card(7, 0);
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(5, 0);
		inHand2[1] = new Card(7, 3);
		inHand2[2] = new Card(2, 1);
		inHand2[3] = new Card(12, 1);
		inHand2[4] = new Card(9, 2);
		Card[] inHand3 = new Card[5];
		inHand3[0] = new Card(5, 2);
		inHand3[1] = new Card(7, 2);
		inHand3[2] = new Card(1, 2);
		inHand3[3] = new Card(12, 2);
		inHand3[4] = new Card(9, 2);
		Card[] inHand4 = new Card[5];
		inHand4[0] = new Card(5, 3);
		inHand4[1] = new Card(7, 1);
		inHand4[2] = new Card(1, 2);
		inHand4[3] = new Card(12, 3);
		inHand4[4] = new Card(9, 1);
		assertTrue(PokerHandEvaluator.hasFlush(inHand) == true);
		assertTrue(PokerHandEvaluator.hasFlush(inHand2) == false);
		assertTrue(PokerHandEvaluator.hasFlush(inHand3) == true);
		assertTrue(PokerHandEvaluator.hasFlush(inHand4) == false);
	}
	
	@Test
	public void testHasStraight() {  
		Card[] inHand = new Card[5];
		inHand[0] = new Card(3, 3);
		inHand[1] = new Card(2, 2);
		inHand[2] = new Card(1, 1);
		inHand[3] = new Card(5, 0);
		inHand[4] = new Card(4, 2);
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(10, 3);
		inHand2[1] = new Card(1, 2);
		inHand2[2] = new Card(13, 1);
		inHand2[3] = new Card(12, 0);
		inHand2[4] = new Card(11, 2);
		Card[] inHand3 = new Card[5];
		inHand3[0] = new Card(1, 0);
		inHand3[1] = new Card(2, 3);
		inHand3[2] = new Card(3, 1);
		inHand3[3] = new Card(4, 1);
		inHand3[4] = new Card(13, 2);
		Card[] inHand4 = new Card[5];
		inHand4[0] = new Card(1, 0);
		inHand4[1] = new Card(7, 3);
		inHand4[2] = new Card(1, 1);
		inHand4[3] = new Card(12, 1);
		inHand4[4] = new Card(9, 2);
		Card[] inHand5 = new Card[5];
		inHand5[0] = new Card(8, 3);
		inHand5[1] = new Card(7, 2);
		inHand5[2] = new Card(6, 1);
		inHand5[3] = new Card(9, 0);
		inHand5[4] = new Card(10, 2);
		Card[] inHand6 = new Card[5];
		inHand6[0] = new Card(10, 3);
		inHand6[1] = new Card(11, 2);
		inHand6[2] = new Card(12, 1);
		inHand6[3] = new Card(13, 0);
		inHand6[4] = new Card(9, 2);
		assertTrue(PokerHandEvaluator.hasStraight(inHand) == true);
		assertTrue(PokerHandEvaluator.hasStraight(inHand2) == true);
		assertTrue(PokerHandEvaluator.hasStraight(inHand3) == false);
		assertTrue(PokerHandEvaluator.hasStraight(inHand4) == false);
		assertTrue(PokerHandEvaluator.hasStraight(inHand5) == true);
		assertTrue(PokerHandEvaluator.hasStraight(inHand6) == true);
	}
	
	@Test
	public void testHasFullHouse() {  
		Card[] inHand = new Card[5];
		inHand[0] = new Card(3, 3);
		inHand[1] = new Card(3, 2);
		inHand[2] = new Card(6, 1);
		inHand[3] = new Card(6, 0);
		inHand[4] = new Card(6, 2);
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(10, 3);
		inHand2[1] = new Card(9, 2);
		inHand2[2] = new Card(10, 1);
		inHand2[3] = new Card(9, 0);
		inHand2[4] = new Card(9, 2);
		Card[] inHand3 = new Card[5];
		inHand3[0] = new Card(5, 0);
		inHand3[1] = new Card(7, 3);
		inHand3[2] = new Card(2, 1);
		inHand3[3] = new Card(12, 1);
		inHand3[4] = new Card(9, 2);
		Card[] inHand4 = new Card[5];
		inHand4[0] = new Card(1, 0);
		inHand4[1] = new Card(7, 3);
		inHand4[2] = new Card(1, 1);
		inHand4[3] = new Card(12, 1);
		inHand4[4] = new Card(9, 2);
		assertTrue(PokerHandEvaluator.hasFullHouse(inHand) == true);
		assertTrue(PokerHandEvaluator.hasFullHouse(inHand2) == true);
		assertTrue(PokerHandEvaluator.hasFullHouse(inHand3) == false);
		assertTrue(PokerHandEvaluator.hasFullHouse(inHand4) == false);
	}
	
	@Test
	public void testCombinedHands() {
		Card[] inHand = new Card[5];
		inHand[0] = new Card(1, 3);
		inHand[1] = new Card(1, 0);
		inHand[2] = new Card(1, 1);
		inHand[3] = new Card(11, 0);
		inHand[4] = new Card(11, 3);
		System.out.println(PokerHandEvaluator.hasPair(inHand));
		System.out.println(PokerHandEvaluator.hasTwoPair(inHand));
		System.out.println(PokerHandEvaluator.hasThreeOfAKind(inHand));
		System.out.println(PokerHandEvaluator.hasStraight(inHand));
		System.out.println(PokerHandEvaluator.hasFlush(inHand));
		System.out.println(PokerHandEvaluator.hasFullHouse(inHand));
		System.out.println(PokerHandEvaluator.hasFourOfAKind(inHand));
		System.out.println(PokerHandEvaluator.hasStraightFlush(inHand));	
		Card[] inHand2 = new Card[5];
		inHand2[0] = new Card(2, 3);
		inHand2[1] = new Card(2, 0);
		inHand2[2] = new Card(2, 1);
		inHand2[3] = new Card(2, 2);
		inHand2[4] = new Card(9, 0);
		System.out.println();
		System.out.println();
		System.out.println(PokerHandEvaluator.hasPair(inHand2));
		System.out.println(PokerHandEvaluator.hasTwoPair(inHand2));
		System.out.println(PokerHandEvaluator.hasThreeOfAKind(inHand2));
		System.out.println(PokerHandEvaluator.hasStraight(inHand2));
		System.out.println(PokerHandEvaluator.hasFlush(inHand2));
		System.out.println(PokerHandEvaluator.hasFullHouse(inHand2));
		System.out.println(PokerHandEvaluator.hasFourOfAKind(inHand2));
		System.out.println(PokerHandEvaluator.hasStraightFlush(inHand2));
		
		/*This test was used to check the results of all my hand 
		evaluators simultaneously.*/
		
	}
	
}
