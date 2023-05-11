package edu.guilford;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    // attributes
    //I want a private arraylist of cards
    //I want a constructor that will create a deck of cards
    private ArrayList<Cards> deck;
    
    public DeckOfCards() {
        this.deck = new ArrayList<>();
        List<String> suits = Cards.getValidSuits();
        List<String> faceNames = Cards.getValidFaceNames();

        for (String suit : suits)
        {
            for (String faceName : faceNames)
            {
                deck.add(new Cards(suit,faceName));
            }
        }
    }

    //shuffle the deck
    /**
     * This method will shuffle the deck
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    //I want a method that will return the top card from the deck
    /**
     * This method will return the top card from the deck
     * @return
     */
    public Cards dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    //I want a method that will return the number of cards left in the deck
    /**
     * This method will return the number of cards left in the deck
     * @return
     */
    public int getNumOfCards()
    {
        return deck.size();
    }
}


