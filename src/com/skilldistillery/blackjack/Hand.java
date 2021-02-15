package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;
public class Hand {
	// these are the cards in your hand
	private List<Card> cards = new ArrayList<>();
	public boolean isBlackJack() {
		// add up cards to determine if they equal 21
		int sum = 0;
		for (Card card : cards) {
			sum += card.getValue();
		}
		//if the total equals 21 return true
		if (sum == 21) {
			System.out.println("Blackjack!");
			return true;
		}
		else {
			return false;
		}
	}
			public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public void addCard(Card card) {
			cards.add(card);
		if (cards.indexOf(card) == 1) {
			return;
		}
		else if (cards.indexOf(card) != 1) {
			System.out.println(toString());
	}	
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" currently has : ");
		builder.append(cards);
		builder.append(".");
		return builder.toString();
	}
}