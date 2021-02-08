package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	public void keepGoing(Scanner sc, Dealer webster, Player dealerPlayer, Player player) {
		boolean result = true;
		System.out.println(player.getName() + " has been dealt one card!" );
		webster.dealCard(player);
		System.out.println("Dealer " + dealerPlayer.getName() + " has been dealt one card! ");
		webster.dealCard(dealerPlayer);
		System.out.println("Dealer " + dealerPlayer.getName() + " has been dealt a face-down card!");
		System.out.println(player.getName() + " has been dealt another card!" );
		webster.dealCard(player);
		webster.dealCard(dealerPlayer);
		System.out.println(player.getName() + " currently has : " + cards.toString());
		isBlackJack();
		while (result) {
		int sum = 0;
		for(Card card:cards) {
			sum += card.getValue();
		}
		if (sum < 21) {
			System.out.println("Would you like to HIT or STAND?");
			System.out.println("Press [1] - HIT   [2] - STAND");
			int userResponse = sc.nextInt();
			if (userResponse == 1) {
				webster.dealCard(player);
				//System.out.println(player.getName());
				if (isBlackJack() == true) {
					System.out.println("Congratulations! " + player.getName() + ", WINNER!!!");
					break;
				}
			}
			if (userResponse == 2) {
				System.out.println(player.getName() + " has chosen to STAND!" + dealerPlayer.getName() + " 's turn!");
				dealerPlayerTurn(sc,webster,dealerPlayer,player, sum);
			}
		}
		else if (sum > 21){
			System.out.println(player.getName() + " has BUST! Dealer wins!");
		break;	
		}
		else if (sum == 21) { 
			System.out.println("Congratulations! " + player.getName() + ", WINNER!!!");
			break;
		}
		}
		result = false;
	}
	public void dealerPlayerTurn(Scanner sc,Dealer webster,Player dealerPlayer, Player player, int sum) {
		System.out.println(sum);
		System.out.println("Dealer " + dealerPlayer.getName() + " reveals their hidden card!");
	//	System.out.println("Test Point 1");
	//		System.out.println("Test Point 2");
	//	System.out.println("Test Point 3");
		boolean result1 = true;
		while (result1) {
			int total = 0;
		for (Card card : cards) {
			total += card.getValue();
		}
	//		System.out.println("Test Point 4");
		if (total <= 17) {
			webster.dealCard(dealerPlayer);
	//		System.out.println("Test Point 5");
			if (total < 21) {
				if (total < sum) {
					System.out.println(player.getName() + " Wins!");
					result1 = false;
					if (total > sum) {
						System.out.println(dealerPlayer.getName() + " Wins!");
						result1 = false;
						if (total == sum) {
							System.out.println("Tie!");
						}
					}
				}
			}
		}
		else if (total >= 18 && total <= 20) {
	//		System.out.println("Test Point 6");
				if (sum > total) {
		//			System.out.println("Test Point 7");
					System.out.println(player.getName() + " Wins!");
					result1 = false;
					if (total > sum) {
			//			 System.out.println("Test Point 8");
						System.out.println(dealerPlayer.getName() + " Wins!");
						result1 = false;
						if (total == sum) {
							System.out.println("Tie!");
							if (total > 21) {
								System.out.println(dealerPlayer.getName() + " has BUST! " + player.getName() + " wins!");
								result1 = false;
								if (total == 21) { 
									isBlackJack();
									System.out.println("Congratulations! " + dealerPlayer.getName() + ", WINNER!!!");
									result1 = false;
								}
							}
						}
					}
				}
			}
	}
			System.exit(0);
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
