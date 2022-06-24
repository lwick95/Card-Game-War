package cardGameWAR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	
	private List<String> cardNum = new ArrayList<>( List.of("2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" ,
			"10" , "Jack" , "Queen" , "King" , "Ace"));
	
	private List<String> suits = new  ArrayList<> (List.of("Spades" , "Hearts" , "Diamonds" , "Clubs"));
	
	public List<Card> cards = new ArrayList<>();
	

	public Deck() {
		createDeck();
	}
	

	private void createDeck() {
		

		
		for(int position = 0; position < cardNum.size(); position ++) {
			int rank = position + 1;
			
			String num = cardNum.get(position);
			for(String suit : suits) {
				cards.add(new Card(num, suit, rank));
				
			}
		}

	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Deck:\n");
		for(Card card : cards) {
			builder.append(" ").append(card).append("\n");
		}
		return builder.toString();
	}



	public void shuffle() {
		Collections.shuffle(cards);
		
	}
	
	 public int size() {
		 return cards.size();
	 }



	public Card draw() {
		
		return cards.remove(0);
	}
}
