package cardGameWAR;

public class Card {
	
	private String num;
	private String suit;
	private int rank;
	
	public Card(String num, String suit, int rank) {
		this.num = num;
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return num + " of " + suit;
	}

	public int getRank() {
		return rank;
	}
	
	
	
}
