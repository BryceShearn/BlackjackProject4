package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;


public class BlackjackApplication {

	public static void main(String[] args) {					//*----------------------------------*
		BlackjackApplication app = new BlackjackApplication(); // |*New BlackJackApplication object  |
		app.beginGame(); 									  //  |*Created in order to escape static|
	} 														 //	  *----------------------------------*

	public void beginGame() {						 //*-------------------------*
		Scanner sc = new Scanner(System.in); 		// |*Creating Scanner        |
		Dealer webster = new Dealer("Webster");    //  |*Creating new dealer     |
		webster.shuffle(); 						  //   |*Dealer shuffles the deck|
												 //	   *-------------------------*
		System.out.println("*-----------------------------------*");	  //*----------------------*
		System.out.println("|   ** Welcome to Blackjack! **     |");     // |Player is greeted and |
		System.out.println("|  May the odds be in your favor!   |");    //  |prompted to enter name|
		System.out.println("| Please enter your username below! |");   //   *----------------------*
		System.out.println("*-----------------------------------*"); 
		System.out.print("Username:");
		String playerName = sc.nextLine();  						 //*------------------------------------*
		//String playerName = sc.nextLine(); 		  			   	// |*Keyboard prompted for name input   |
		Player player = new Player(playerName);  			  	   //  |*Creating new player with name input|
		playerTurn(sc, webster, player); 					 	  //   |*Method called to begin the game	|
	}										   					 //	   *------------------------------------*
	public void playerTurn(Scanner sc, Dealer webster, Player player) {
																									  		 //*------------------------------------------------------------*
		System.out.println(player.getName() + " has been dealt one card!");					         	    // |*Deal a card to the player									|
		System.out.print(player.getName()); webster.dealCard(player);									   //  | |															|
																										  //   | |															|
		System.out.println();																		     //	   | |															|
																									    //	   | |															|
		System.out.println("Dealer " + webster.getName() + " has been dealt one card! ");              //	   |*Deal a card to the dealer									|
		System.out.print("Dealer " + webster.getName());webster.dealCard(webster);					  //	   | |															|
																									 //		   | |															|
		System.out.println();																	    //		   | |															|
																								   //		   | |															|
		System.out.println("Dealer " + webster.getName() + " has been dealt a "					  //     	   |*Printing deal a card to dealer due to requirements of--	|
						   + "face-down card!" + " \uD83C\uDCA0");								 //			   | player not seeing card(ref.line 52)						|
		System.out.println("Dealer " + webster.getName() + webster.getPlayerHand() 				//			   | |															|
						   + " And a face-down card!" + " \uD83C\uDCA0");					   //			   | |															|
																							  //			   | |															|
		System.out.println();																 //				   | |															|
																							//				   | |															|
		System.out.println(player.getName() + " has been dealt another card!");			   //	    		   |*Deal a card to the player--card is not printed as AddCard--|
		System.out.print(player.getName()); webster.dealCard(player);					  //    		       | method in Hand.java prevents array index == 1 from printing|
																						 //					   |*Deal a card to the dealer--card is not printed as AddCard--|
		webster.dealCard(webster);														//       			   | method in Hand prevents arrayIndex==1 from printing 		|
		System.out.println(player.getPlayerHand().toString());			 			   //		    		   |*Printing player hand >> as players last card print was--	|
																					  //					   | prevented by AddCard in Hand								|
		System.out.println();														 //		   				   *------------------------------------------------------------*
		
		boolean playerTurnLoop = true;								  //*----------------------------------------------*
		while (playerTurnLoop) {									 // |*Loop to keeps players turn running		   |
			int playerTotal = 0;									//  |*declaring and initializing playerTotal to 0  | 
			for (Card card : player.getPlayerHand().getCards()) {  //   |*array to hold player's cards and loop to--   |
				playerTotal += card.getValue();					  //    | find the total the value of the players cards|
			}													 //     *----------------------------------------------*
																   //*--------------------------------------------------------------------*
			if (player.getPlayerHand().isBlackJack() == true) {	  // |*Run the isBlackJack method in Hand to check if player has blackjack|
				System.out.println(player.getName() + " Wins!"); //	 |*If the player now has blackjack tell the player they have won	  |
				playerTurnLoop = false;							//   |stop the player turn loop if the player has won					  |
				break;										   //    ||				  													  |
			}												  //	 *--------------------------------------------------------------------*
															 //									//*--------------------------------------------------------------------*
			if (playerTotal < 21) {															   // |**If the playerTotal from the players card array is less than 21	   |
				System.out.println("Would you like to HIT or STAND?");						  //  |*Ask the user if they would--									   |
				System.out.println("Press [1] - HIT   [2] - STAND");						 //   |like to hit or stand												   |
				int userResponse = sc.nextInt();											//	  |*Keyboard input for user's choice to hit or stand				   |
				if (userResponse == 1) {												   // 	  |*------------------------------------------------------------------*|
					webster.dealCard(player);											  //	  |**If player responds with [1] - hit, then- deal the player one card |
					if (player.getPlayerHand().isBlackJack() == true) {					 // 	  |*Run the isBlackJack method in Hand to check if player has blackjack|
						System.out.println(player.getName() + " WINS!"); 				//		  |*If the player now has blackjack tell the player they have won	   |
						playerTurnLoop = false;										   // 		  |*Stop the player turn loop if the player has won					   |
						break;														  //		  |	|																   |
					}																 //			  |	|																   |
					else { continue; }												//			  |*If the players total does not equal blackjack continue through loop|
				}																   // 			  *--------------------------------------------------------------------*
				if (userResponse == 2) {										  //			  |**If the user responds with [2] - call dealerTurn method on Line. 98|
					System.out.println(player.getName() + " has chosen"			 //				  |	|																   |
					+ " to STAND! Dealer " + webster.getName() + "'s turn!"); 	//				  |	|																   |
					dealerTurn(sc, webster, player, playerTotal);			   //				  |	|																   |
					break;													  //				  |*if return from dealerTurn method, break;						   |
				}															 // 				  |	|																   |
			}														  		//					  *--------------------------------------------------------------------*
			if (playerTotal > 21) {											  //*--------------------------------------*
				System.out.println(player.getName() + " has BUST with :"     // |*If the playerTotal from the players--|
				+ playerTotal +" Points! " + webster.getName() + " WINS!"); // 	| card array is greater than 21 after--|
				playerTurnLoop = false;									   //	| user selects [1] - hit, tell the--   | 
				break;													  //	| player they have BUST and break;	   |					
			}															 //		| |									   |
		}																//		| |									   |
	}																   //		*--------------------------------------*
	public void dealerTurn(Scanner sc, Dealer webster, Player player, int playerTotal) {					   //*---------------------------------*
		System.out.println();																				  // |*telling the user the dealer is--|
		System.out.println("Dealer " + webster.getName() + " reveals their hidden card!" + " \uD83C\uDCA0"); //  | now displaying their hidden card|
		System.out.println();																				//   |*print all cards in dealers hand |
		System.out.println(webster.getName() + " " + webster.getPlayerHand());							   //    |								   |
																										  //	 *---------------------------------*
		boolean dealerTurnLoop = true;									 //*----------------------------------------------*
		while (dealerTurnLoop) {										// |*Loop to keeps dealers turn running		      |
			int dealerTotal = 0;									   //  |*declaring and initializing dealerTotal to 0  |
			for (Card card : webster.getPlayerHand().getCards()) {	  //   |*array to hold dealer's cards and loop to--   |
				dealerTotal += card.getValue();						 //    | find the total the value of the dealers cards|
			}														//	   *----------------------------------------------*
			if (dealerTotal <= 17) {													   //*-----------------------------------------------------------*
				System.out.println();													  // |*If the dealerTotal hand value is less than or equal to 17 |
				System.out.println(webster.getName() + " has: " + dealerTotal 			 //  |*Print the dealer's name and display their total hand value|
				+ " Points. " + webster.getName() + " draws a card from the deck!"); 	//   |*Print letter the user know the dealer is taking a card    |
				System.out.println();												   //    | |														 |
				System.out.print(webster.getName()); webster.dealCard(webster);		  //	 |*Deal a card to the dealer and print the new hand total    |
				continue;															 //		 | | 														 |
			}																		//		 *-----------------------------------------------------------*
			if (webster.getPlayerHand().isBlackJack() == true) {		//*----------------------------------------------------------------------*
				System.out.println(webster.getName() + " WINS!");	   // |*Call the isBlackJackmethod in Hand to determine if dealer has--      |
				dealerTurnLoop = false;								  //  | blackjack, if the dealer has blackjack tell the player the dealer won|
				break;												 //   | break; if the player has blackjack									 |
			}														//	  *----------------------------------------------------------------------*
			if (dealerTotal > 21) {																		 //*----------------------------------------------*
				System.out.println(webster.getName() + " has BUST! " + player.getName() + " WINS!"); 	// |*If the dealerTotal hand value is greater--   |
				dealerTurnLoop = false;																   //  | than 21, print letting the player know that--|
				break;																				  //   | the dealer has BUST  						  |
			}																						 //	   |*Break; if the dealer BUST					  |
			if (dealerTotal < playerTotal) {														//	   *----------------------------------------------*
				System.out.println(webster.getName() + " Has: " + dealerTotal + " Points!");		//*-------------------------------------------------*
				System.out.println(player.getName() + " Has: " + playerTotal + " Points! " 		   // |*If the dealerTotal hand value is less than--    |
								   + player.getName() + " WINS!");								  //  | the playerTotal hand value display both dealer--|
				dealerTurnLoop = false;															 //	  | and player hand values and print to let the--   |
				break;																			//	  | player know they have won * break;if player won |
			}																				   //	  *-------------------------------------------------*
			if (dealerTotal > playerTotal) {													 //*-------------------------------------------------*
				System.out.println(player.getName() + " Has: " + playerTotal + " Points! ");	// |*If the dealerTotal hand value is greater than-- |
				System.out.println(webster.getName() + " Has: " + dealerTotal + " Points!" 	   //  | the playerTotal hand value display both dealer--|
								   + webster.getName() + " WINS!");							  //   | and player hand values and print to let the--	 |
				dealerTurnLoop = false;														 //	   | player know the dealer won						 |
				break;																		//	   |*Break; if the dealer won						 |
				}																		   //	   *-------------------------------------------------*
			if (dealerTotal == playerTotal) {			//*-----------------------------------------------*
				System.out.println("TIE!");			   // |*If the dealerTotal and playerTotal are equal--| 
				dealerTurnLoop = false;				  //  | print letting the player know that they have--|
				break;								 //	  | tied with the dealer--						  |
			}										//	  | |											  |
		}										   //	  | |											  |
	}											  //	  | |											  |
	}											 //		  *-----------------------------------------------*