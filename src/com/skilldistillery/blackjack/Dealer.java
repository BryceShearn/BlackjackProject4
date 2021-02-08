package com.skilldistillery.blackjack;
import com.skilldistillery.cards.Deck;

public class Dealer extends Player {
	private Deck deck;
	
// dealer can shuffle the cards
	public void shuffle() {
		deck.shuffle();
	}
	// draw cards from the deck
	public Dealer(Deck deck,String name) {
		this.deck = deck;
	}
	

	// card is dealt to the player
	// take the card from the deck and give it to the player
	public void dealCard(Player player) {
	player.takeCard(deck.dealCard());
	
		
	}
	public void removeCard() {
		
}
}