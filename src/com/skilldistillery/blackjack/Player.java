package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public class Player {
	private String name;
	private Hand playerHand;
	public Player(String name) {
	this.name = name;
		playerHand = new Hand();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hand getPlayerHand() {
		return playerHand;
	}
	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}
	public void takeCard(Card card) {
		playerHand.addCard(card);
		//setPlayerHand(playerHand);
	}
}