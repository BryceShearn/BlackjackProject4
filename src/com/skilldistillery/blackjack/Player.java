package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;

public class Player {
	private String name;
	private Hand playerHand;
	public Player() {
	playerHand = new Hand();
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hand getPlayerHand(Scanner sc, Dealer webster, Player dealerPlayer, Player player) {
		playerHand.isBlackJack();
		playerHand.keepGoing(sc, webster, dealerPlayer, player);
		return playerHand;
	}
	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}
	public void takeCard(Card card) {
		playerHand.addCard(card);
		setPlayerHand(playerHand);
	}
}