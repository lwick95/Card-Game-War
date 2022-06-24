package cardGameWAR;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class App {
	
	List<String> players = new ArrayList<>(List.of("Logan", "James", "Audrey", "Hannah", "Tanner", "Melissa"));

	Random random = new Random();

	public static void main(String[] args) {
		new App().playWar();
	}

	private void playWar() {
		List<String> playerNames = new LinkedList<>(players);
		Player player1 = findPlayers(playerNames);
		Player player2 = findPlayers(playerNames);
		Deck deck = new Deck();
		
		shuffleDeck(deck);
		dealTheCards(player1, player2, deck);
		playTheGame(player1, player2);
		determineWinner(player1, player2);
	}

	private void determineWinner(Player player1, Player player2) {
		Player winner = null;
		Player loser =  null;
		
		if(player1.getScore() > player2.getScore()) {
			winner = player1;
			loser = player2;
		}
		else if(player2.getScore() > player1.getScore()) {
			winner = player2;
			loser = player1;
		}
		if (winner == null) {
			System.out.println("There is no winner for this round! We have a tie!");
		}else {
			System.out.println("The winner is " + winner.getName() + " with a score of " + winner.getScore());
			System.out.println("The loser is " + loser.getName() + " with a score of " + loser.getScore());
		}
	}

	private void playTheGame(Player player1, Player player2) {
		int deckSize = player1.size() + player2.size();
		for(int playnum = 0; playnum < deckSize/2 ; playnum ++) {
			Card c1 = player1.flip();
			Card c2 = player2.flip();
			System.out.println(c1.toString() + " VS  " + c2.toString() );
			if(c1.getRank() > c2.getRank()) {
				player1.increaseScore();
			}
			else if(c2.getRank() > c1.getRank()) {
				player2.increaseScore();
			
			}
		}
		
	}

	private void dealTheCards(Player player1, Player player2, Deck deck) {
		
		int deckSize = deck.size();
		
		for (int pos =0; pos < deckSize; pos ++) {
			if(pos % 2 == 0) {
				player1.draw(deck);
			}
			else {
				player2.draw(deck);
			}
		}
		
	}

	private void shuffleDeck(Deck deck) {
		deck.shuffle();
		
	}

	private Player findPlayers(List<String> Names) {
		int position = random.nextInt(players.size());
		String name = players.remove(position);
		return new Player(name);
	}

}
