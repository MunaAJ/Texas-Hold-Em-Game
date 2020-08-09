package poker;

/*******************************************************************************
*This class is responsible for evaluating all the poker hands possible in the  *
*Texas Hold 'Em card game. The hands that will be evaluated include: hasPair,  *
*hasTwoPair, hasThreeOfAKind, hasStriaght, hasFlush, hasFullHouse,             *
*hasFourOfAkind and hasStraightFlush. This class also contains one private     *
*method used to sort the cards in an ascending order.                          *
*******************************************************************************/

public class PokerHandEvaluator {

/*******************************************************************************
*This method checks if the cards contain a pair. i.e two cards of the same     *
*value.                                                                        *
*******************************************************************************/
	
	public static boolean hasPair(Card[] cards) {
		boolean result = false;
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue() && 
						!cards[i].equals(cards[j])) {
					result = true;
					break;
				}	else {
					result = false;
				}
			}
			if (result == true) {
				i = cards.length;
			}
		}	
		return result;
	}
/*******************************************************************************
*This method checks if the cards contains two pairs. i.e two cards of the same * 
*value and two other cards of the same value.                             *
*******************************************************************************/

	public static boolean hasTwoPair(Card[] cards) {
		boolean result = false;
		PokerHandEvaluator.sortCards(cards);
		if (hasFourOfAKind(cards) == true) {
			return false;
		} else {
			if (cards[1].getValue() - cards[0].getValue() != 0) {
				if (cards[2].getValue() - cards[1].getValue() == 0 &&
						cards[4].getValue() - cards[3].getValue() == 0 &&
						!cards[2].equals(cards[4])) {
					result = true;
				}
			}
			if (cards[1].getValue() - cards[0].getValue() == 0) {
				if ((cards[4].getValue() - cards[3].getValue() == 0 &&
						!cards[0].equals(cards[4])) || cards[3].getValue() - 
						cards[2].getValue() == 0 &&	!cards[0].equals
						(cards[3])) {
					result = true;
				}
			}
			return result;
		}
	}
/*******************************************************************************
*This method checks if the cards contains three of a kind.i.e three cards of   * 
*the same.                                                                     *
*******************************************************************************/

	public static boolean hasThreeOfAKind(Card[] cards) {
		PokerHandEvaluator.sortCards(cards);
		if (hasTwoPair(cards) == true && hasFullHouse(cards) != true) {
			return false;
		} else {
			int counter = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = i; j < 3 + i; j++) {
					if (cards[i].getValue() == cards[j].getValue() && 
							!cards[i].equals(cards[j])) {
						counter += 1;
					}
					if (counter == 2) {
						break;
					}
				}
			}
			if (counter == 2) {
				return true;
			} else {
				return false;
			}
		}
	}
	
/*******************************************************************************
*This method sorts the cards in a deck in an ascending order.                  *
*******************************************************************************/

	private static void sortCards(Card [] cards) {
		for (int i = 0; i < cards.length - 1; i++)  {
			int index = i;  
			for (int j = i + 1; j < cards.length; j++){  
				if (cards[j].getValue() < cards[index].getValue()){  
					index = j;
				}  
			}  
			Card smallerCards = cards[index];   
			cards[index] = cards[i];  
			cards[i] = smallerCards;  
		}  
	}
	
/*******************************************************************************
*This method checks if the all cards are in a consecutive. i.e 1,2,3,4,5 e.tc. *
*However, if there is an ace and all the other cards are in a consecutive order*
*it would still be considered a straight.i.e 10,11,12,13,ace(is a straight).   *
*******************************************************************************/

	public static boolean hasStraight(Card [] cards) {
		PokerHandEvaluator.sortCards(cards);
		boolean result = false;
		int numberOfAces = 0;
		int counter = 0;
		for (int i = 0; i < cards.length; i++) { // finds number of aces.
			if (cards[i].getValue() == 1) {
				numberOfAces += 1;
			}
		}
		for (int i = 0; i < 1; i++) { //checks if the values are increasing by 1
			for (int j = 0; j < cards.length; j++) {
				if (cards[i].getValue() + j == cards[j].getValue()) {
					counter += 1;
				}
			}
		}
		if (numberOfAces == 1) {
			if ((cards[1].getValue() - cards[0].getValue()) == 1 && 
					counter == 5) {
				result = true;
			}
			if (cards[0].getValue() == 1 && cards[1].getValue() == 10 && 
				cards[2].getValue() == 11 && cards[3].getValue() == 12 &&
				cards[4].getValue() == 13) {
				return true;
			}
		} 
		if (numberOfAces == 0 && counter == 5) {
			result = true;
		}
		return result;
	}
	
/*******************************************************************************
*This method checks if all cards have the same suits. i.e all spades, hearts,  * 
*clubs, or diamonds.                                                           *
*******************************************************************************/

	public static boolean hasFlush(Card[] cards) {
		int counter = 0;
		Card firstCard = new Card(cards[0].getValue(), cards[0].getSuit());
		for (int i = 1; i < cards.length; i++) {
			if (firstCard.getSuit() == cards[i].getSuit()) {
				counter += 1;
			}	
		}
		if (counter == (cards.length - 1)) {
			return true;
		} else {
			return false;
		}

	}
	
/*******************************************************************************
*This method checks if two cards have the same values and another set of three * 
*cards have the same value.i.e 3,7,7,3,7 or 4,6,4,6,4.(this is a Fullhouse)    *
*******************************************************************************/

	public static boolean hasFullHouse(Card[] cards) {
		PokerHandEvaluator.sortCards(cards);
		int counter = 0;
		int counter1 = 0;
		for (int i = 0; i < 1; i++) {
			for (int j = 1; j < 2; j++) {
				for (int k = 2; k < 3; k++) {
					if (cards[i].getValue() == cards[j].getValue() && 
							cards[j].getValue() == cards[k].getValue()) {
						counter += 1;
					}
				}
			}
		}

		for (int i = 3; i < 4; i++) {
			for (int j = 4; j < cards.length; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					counter += 1;
				}
			}
		}

		for (int i = 0; i < 1; i++) {
			for (int j = 1; j < 2; j++) {
				if (cards[i].getValue() == cards[j].getValue()) {
					counter1 += 1;
				}
			}
		}

		for (int i = 2; i < 3; i++) {
			for (int j = 3; j < 4; j++) {
				for (int k = 4; k < cards.length; k++) {
					if (cards[i].getValue() == cards[j].getValue() && 
							cards[j].getValue() == cards[k].getValue()) {
						counter1 += 1;
					}
				}
			}
		}

		if (counter == 2 || counter1 == 2) {
			return true;
		} else {
			return false;
		}	
	}
	
/*******************************************************************************
*This method checks if the cards contains four of a kind.i.e four cards of     * 
*the same.                                                                     *
*******************************************************************************/

	public static boolean hasFourOfAKind(Card[] cards) {
		PokerHandEvaluator.sortCards(cards);
		int counter = 0;
		if (cards[0].getValue() < cards[1].getValue()) {
			for (int i = 1; i < 2; i++) {
				for (int j = 1; j < cards.length; j++) {
					if (cards[i].getValue() == cards[j].getValue() ) {
						counter += 1;
					}
				}
			}
		}
		if (cards[0].getValue() == cards[1].getValue()) {
			for (int i = 0; i < 1; i++) {
				for (int j = 0; j < 4; j++) {
					if (cards[i].getValue() == cards[j].getValue() ) {
						counter += 1;
					}
				}
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}
	
/*******************************************************************************
*This method checks if the cards contain both a straight and a flush at the    *
*same time.i.e consecutive values and the same suits simultaneously.           *
*******************************************************************************/

	public static boolean hasStraightFlush(Card[] cards) {
		if (PokerHandEvaluator.hasFlush(cards) == true && 
				PokerHandEvaluator.hasStraight(cards) == true) {
			return true;
		} else {
			return false;
		}
	}
}

