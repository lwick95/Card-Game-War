package cardGameWAR;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand = new ArrayList<>();
	private int score;

	

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	

	@Override
	public String toString() {
		return "Player [name=" + name + ", hand=" + hand + ", score=" + score + "]";
	}

	public void draw(Deck deck) {
		hand.add(deck.draw());
		
	}
	
	public int size() {
		return hand.size();
	}

	public Card flip() {
		
		return hand.remove(0);
	}

	public void increaseScore() {
		score = getScore() + 1;
	}
	
	public int getScore() {
		return score;
	}

}
