/**
 * This class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Deck 
{

    private Card[] cards; //deck of cards
    private int size;   // represents the number of undelt cards


    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits,
     * and produces one of the corresponding card.
     * @param ranks is an array containing all of the card ranks.
     * @param suits is an array containing all of the card suits.
     * @param cards is an array containing all of the card point cards.
     */
    public Deck(String[] ranks, String[] suits, int[] values)
    {
        //Creates a new deck of cards
        cards = new Card[ranks.length*suits.length];
        int counter = 0;
        //Goes through ranks and values
        for(int r = 0; r < ranks.length; r++){
            //For each rank and value, it goes through all suits
            for(int s = 0; s < suits.length; s++){
                //Creates new unique card and keeps track of size
                cards[counter] = new Card(ranks[r], suits[s], values[r]);
                counter++;
            }
        }
        //Creates a deck of cards in which all cards of the same value/rank
        //are together, but with a different suit.
        size = counter;
    }

    /**
     * Accesses the number of undealt cards in this deck.
     * @return the number of undealt cards in this deck.
     */
    public int getSize() 
    {
        //Returns how many cards are in the deck
        return size;      // replace this line
    }

    /**
     * Determines if this deck is empty (no undealt cards).
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty() 
    {
        //if the deck is empty (a.k.a. zero) returns true
        return size == 0;   // replace this line
    }

    /**
     * Randomly permute the given collection of cards
     * and reset the size to represent the entire deck.
     */
    public void shuffle() 
    {        
        //Goes through the entire deck exchanging one card for a random other
        //card (shuffling)
        for(int k = cards.length - 1; k > 0; k--){
            int r = (int)(Math.random() * k);
            //for every k value, there's a random r value, so the card gets
            //set to another place
            Card temp = cards[k];
            cards[k] = cards[r];
            cards[r] = temp;
        }
        //changes the size of the deck to full
        size = cards.length;
    }

    /**
     * Deals a card from this deck.
     * @return the card just dealt, or null if all the cards have been
     *         previously dealt.
     */
    public Card deal() 
    {   
        //Checks if there are no cards to deal, which it would return null
        if(this.isEmpty()){
            return null;
        }
        //takes the card from the "top" of the deck and returns it, changing
        //the size of the deck by 1
        Card temp = cards[size - 1];
        size--;
        return temp;    // replace this line
    }

    /**
     * Generates and returns a string representation of this deck.
     * @return a string representation of this deck.
     */
    @Override
    public String toString() {
        //Creates a string that initially represents size and undealt cards
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            //adds card to the displayed deck
            rtn = rtn + cards[k];
            //As long as k != 0, there's a comma after each card
            if (k != 0) {
                rtn = rtn + ", ";
            }
            //every other card would display on a new line
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        //Adds onto the string dealt cards, denoted by the k being card.length
        //and continuing until it reaches size (which is when undealt cards
        //star)
        rtn = rtn + "\nDealt cards: \n";
        for (int k = cards.length - 1; k >= size; k--) {
            //adds cards to the dealt deck
            rtn = rtn + cards[k];
            //As long as K != size, there's a comma after each card
            if (k != size) {
                rtn = rtn + ", ";
            }
            //every other card would display on a new line
            if ((k - cards.length) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }
        rtn = rtn + "\n";
        //creates a new line
        return rtn;
    }
}
