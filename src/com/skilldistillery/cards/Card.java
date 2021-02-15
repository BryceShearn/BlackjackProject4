package com.skilldistillery.cards;

public class Card {
  private Rank rank;
  private Suit suit;
  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }
  public int getValue() {
    return rank.getValue();
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((rank == null) ? 0 : rank.hashCode());
    result = prime * result + ((suit == null) ? 0 : suit.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Card other = (Card) obj;
    if (rank != other.rank)
      return false;
    if (suit != other.suit)
      return false;
    return true;
  }
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(rank);
    builder.append(" of ");
    builder.append(suit);
  	  
	  if (rank.toString() == "TWO" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB2");
	  }
	  if (rank.toString() == "THREE" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB3");
	  }
	  if (rank.toString() == "FOUR" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB4");
	  }
	  if (rank.toString() == "FIVE" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB5");
	  }
	  if (rank.toString() == "SIX" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB6");
	  }
	  if (rank.toString() == "SEVEN" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB7");
	  }
	  if (rank.toString() == "EIGHT" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB8");
	  }
	  if (rank.toString() == "NINE" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB9");
	  }
	  if (rank.toString() == "TEN" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCBA");
	  }
	  if (rank.toString() == "JACK" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCBB");
	  }
	  if (rank.toString() == "QUEEN" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCBD");
	  }
	  if (rank.toString() == "KING" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCBE");
	  }
	  if (rank.toString() == "ACE" && suit.toString() == "Hearts") {
		  builder.append(" \uD83C\uDCB1");
	  }
	  if (rank.toString() == "TWO" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA2");
	  }
	  if (rank.toString() == "THREE" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA3");
	  }
	  if (rank.toString() == "FOUR" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA4");
	  }
	  if (rank.toString() == "FIVE" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA5");
	  }
	  if (rank.toString() == "SIX" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA6");
	  }
	  if (rank.toString() == "SEVEN" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA7");
	  }
	  if (rank.toString() == "EIGHT" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA8");
	  }
	  if (rank.toString() == "NINE" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA9");
	  }
	  if (rank.toString() == "TEN" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCAA");
	  }
	  if (rank.toString() == "JACK" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCAB");
	  }
	  if (rank.toString() == "QUEEN" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCAD");
	  }
	  if (rank.toString() == "KING" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCAE");
	  }
	  if (rank.toString() == "ACE" && suit.toString() == "Spades") {
		  builder.append(" \uD83C\uDCA1");
	  }
	  if (rank.toString() == "TWO" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCD2");
	  }
	  if (rank.toString() == "THREE" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCD3");
	  }
	  if (rank.toString() == "FOUR" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCD4");
	  }
	  if (rank.toString() == "FIVE" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCD5");
	  }
	  if (rank.toString() == "SIX" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCD6");
	  }
	  if (rank.toString() == "SEVEN" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCD7");
	  }
	  if (rank.toString() == "EIGHT" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCD8");
	  }
	  if (rank.toString() == "NINE" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCD9");
	  }
	  if (rank.toString() == "TEN" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCDA");
	  }
	  if (rank.toString() == "JACK" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCDB");
	  }
	  if (rank.toString() == "QUEEN" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCDD");
	  }
	  if (rank.toString() == "KING" && suit.toString() == "Clubs") {
		  builder.append(" \uD83C\uDCDE");
	  }
	  if (rank.toString() == "ACE" && suit.toString() == "Clubs") {
		  builder.append("\uD83C\uDCD1");
	  }
	  if (rank.toString() == "TWO" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC2");
	  }
	  if (rank.toString() == "THREE" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC3");
	  }
	  if (rank.toString() == "FOUR" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC4");
	  }
	  if (rank.toString() == "FIVE" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC5");
	  }
	  if (rank.toString() == "SIX" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC6");
	  }
	  if (rank.toString() == "SEVEN" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC7");
	  }
	  if (rank.toString() == "EIGHT" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC8");
	  }
	  if (rank.toString() == "NINE" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC9");
	  }
	  if (rank.toString() == "TEN" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCCA");
	  }
	  if (rank.toString() == "JACK" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCCB");
	  }
	  if (rank.toString() == "QUEEN" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCCD");
	  }
	  if (rank.toString() == "KING" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCCE");
	  }
	  if (rank.toString() == "ACE" && suit.toString() == "Diamonds") {
		  builder.append(" \uD83C\uDCC1");
	  }
	  return builder.toString();
  }
}
