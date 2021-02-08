package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Deck;

public class BlackjackApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);    //  Creating Scanner
		Deck deck = new Deck();					//  Dealer gets a new deck of cards 
		Dealer webster = new Dealer(deck,"Webster"); // Creating new dealer passing in 
		webster.shuffle();					   //   Dealer shuffles the deck
		
		//	Dealer Greets the player
		System.out.println("Welcome to Blackjack! ");
		System.out.println("May the odds be in your favor!");
		System.out.println("Please enter your name below!");
		//	Dealer deals a visible card to the player face down
	
		Player player = new Player();
		String playerName = sc.nextLine();
		player.setName(playerName);
		Player dealerPlayer = new Player();
		dealerPlayer.setName("Webster");
		player.setPlayerHand(player.getPlayerHand(sc, webster, dealerPlayer, player));
	}
	}

