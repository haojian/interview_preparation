package predict;

import java.util.ArrayList;

public class Solitaire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// each colum is used to hold the cards in different set.
		// 1 is unknown card column.
		// 2-8 is the operating stacks.
		// 9-12 is the four targeting stacks.
		Column[] colums = new Column[12];  
		//initialize all the cards.
		Deck deck = new Deck();
		//shuffle all the cards to different coulums
		deck.shuffle(colums);
		
		// the game would finish if all the cards are in the last 4 columns.
	}

}

enum Suit{
	Club(0), Diamond(1), Heart(2), Sapde(3);
	private int value;
	Suit(int v){
		value = v;
	}
	public int getValue(){return value;}
}

abstract class Card{
	private boolean ifVisible = true;
	protected int faceValue;
	protected Suit suit;
	
	Card(int c, Suit s){
		faceValue = c;
		suit = s;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public boolean getVisibility(){
		return ifVisible;
	}
	
	public void changeVisibility(){
		//update the availability.
	}
}


class Deck<T extends Card>{
	private ArrayList<T> cards;  //store all the card.
	private int curIndex = 0;
	Column[] colums;
	public void setDeckofCards(ArrayList<T> deckofCards){
		//set the deck
	}
	
	 void shuffle(Column[] _colums){
		 //shuffle the deck
		}
	
	 boolean moveCard(Column[] source, Column[] target){
		 //check if this movement is eligibility.
		 return false;
	 }
	 
	 T[] dealHand(int number){
		return null;}
	
	 T dealDeck(){
		return null;}
	 
	 boolean ifFailed(Column[] colums){
		 //check if this movement is eligibility.
		 return false;
	 }
	 
	 boolean ifCompleted(Column[] colums){
		 //check if this movement is eligibility.
		 return false;
	 }
}

class Column<T extends Card>{
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public void addCard(T Card){
		
	}
	
	public T getTopElement(){
		return cards.get(cards.size()-1);
	}
}