package poker;

/*******************************************************************************
*This class is responsible for creating a deck of Cards, getting the position  *
*of the cards in the deck(geCardAt), getting the number of cards in the deck   *
*(getNumCards), shuffling the cards in the deck(shuffle), cutting the cards    *
*at a particular position in the deck(cut)and dealing the cards in the deck.   *
*******************************************************************************/

public class Deck {

	private Card[] cards;
	
/*******************************************************************************
*This constructor initializes the 52 cards in a deck, with the suits and values*
*arranged in a particular order i.e from 1 - 13 for its values and spades,     *
*hearts, clubs and diamonds in this order for its suits                        *          
*******************************************************************************/
	public Deck() {
		cards = new Card[52];
		for (int i = 0; i < 13; i++) {
			cards[i] = new Card((i + 1),0);
		}
		for (int i = 13; i < 26; i++) {
			cards[i] = new Card((i - 12),1);
		}
		for (int i = 26; i < 39; i++) {
			cards[i] = new Card((i - 25),2);
		}
		for (int i = 39; i < cards.length; i++) {
			cards[i] = new Card((i - 38),3);
		}
	}
/*******************************************************************************
*This is a copy constructor which is used to create a copy of another existing * 
*Deck of Cards.    														       *
*******************************************************************************/

	public Deck(Deck other) {
		cards = other.cards;
	}

/*******************************************************************************
*This is method returns the card in a particular position in the deck .        *
*These positions start with an index of zero. i.e the first card in the deck   *
*has a position of zero.  													   *
*******************************************************************************/
	
	public Card getCardAt(int position) {
		return cards[position];
	}
	
/*******************************************************************************
*This is method returns the number of cards in the deck of Cards at any point  *
*in time.   													               *
*******************************************************************************/

	public int getNumCards() {
		int counter = 0;
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] != null) {
				counter += 1;
			}
		}
		return counter;
	}
	
/*******************************************************************************
*This is method shuffles the cards in the deck. This is done by dividing the   *
*cards in the deck into two equal parts and taking one card from each part and *
*rearranging them together.  												   *
*******************************************************************************/

	public void shuffle() {
		int counter = 0;
		Card[] shuffled = new Card[getNumCards()];
		if (getNumCards() % 2 == 0) { // used if the number of cards are even.
			for (int i = 0; i < (getNumCards()/2); i++) {
				shuffled[counter] = cards[i];
				shuffled[counter + 1] = cards[(getNumCards()/2 + i)];
				counter += 2;
			}
		} 
		if (getNumCards() % 2 != 0) { // used if the number of cards are odd.
			for (int i = 0; i < (getNumCards()/2 + 1); i++) {
				shuffled[counter] =  cards[i];
				if ((getNumCards()/2) != i) {
					shuffled[counter + 1] = cards[((getNumCards()/2) + i + 1)];
				}
				counter += 2;
			}
		} 	
		for (int i = 0; i < shuffled.length; i++) {
			cards[i] = shuffled[i];
		}
	}

/*******************************************************************************
*This method divides the deck into two subpackets: The part above the specified* 
*position, and the part that is at the specified position or below. The two    *
*subpackets are reversed (the top packet is placed on the bottom and the bottom* 
*packet is placed on the top.)												   *
*******************************************************************************/
	public void cut(int position) {
		int counter = 0;
		Card[] cutCards = new Card[cards.length];
		for (int i = 0; i < (getNumCards() - position); i++) {
			cutCards[i] = cards[position + i];
		}
		for (int i = (getNumCards() - position); i < getNumCards(); i++) {
			cutCards[i] = cards[counter];
			counter += 1;
		}
		cards = cutCards;
	}
/*******************************************************************************
*This is method returns the specified number of cards from the top of the deck *
*i.e it deals the number of cards requested from the top of the deck.  		   *
*******************************************************************************/

	public Card[] deal(int numCards) {
		Card[] dealtCards = new Card[numCards];
		for (int i = 0; i < dealtCards.length; i++) {
			dealtCards[i] = cards[i];
		}
		Card[] smaller = new Card[getNumCards() - numCards];
		for (int i = 0; i < smaller.length; i++) {
			smaller[i] = cards[numCards + i];
		}
		cards = smaller;
		return dealtCards;
	}
		
}
