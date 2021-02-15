package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Deck;

public class Dealer extends Player {
	private Deck deck;
	
	public void shuffle() {
		deck.shuffle();
	}
	public Dealer(String name) {
		super(name);
		deck = new Deck();
	}
	public void dealCard(Player player) {
	player.takeCard(deck.dealCard());
	}
}
