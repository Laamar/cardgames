package edu.guilford;

import java.util.Arrays;
import java.util.List;
import javafx.scene.image.Image;

public class Cards {
// attributes
private String suit;
private String faceName;

// constructor
/**
 * This constructor will create a card with the suit and face name provided
 * @param suit
 * @param faceName
 */
public Cards(String suit, String faceName) {
    setSuit(suit);
    setFaceName(faceName);
}
// methods
public String getSuit() {
    return suit;
}

public static List<String> getValidSuits()
{
    return Arrays.asList("hearts","diamonds","clubs","spades");
}

/**
 * valid suits are "hearts","diamonds","clubs","spades"
 * @param suit
 */
public void setSuit(String suit) {
    suit = suit.toLowerCase();
    if (getValidSuits().contains(suit))
        this.suit = suit;
    else
        throw new IllegalArgumentException(suit + " invalid, must be one of "+getValidSuits());
}

public String getFaceName() {
    return faceName;
}

/**
 * This method will return a list of valid face names
 * @return
 */
public static List<String> getValidFaceNames()
{
    return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");
}

/**
 * valid face names are "2","3","4","5","6","7","8","9","10","jack","queen","king","ace"
 * @param faceName
 */
public void setFaceName(String faceName) {
    faceName = faceName.toLowerCase();
    if (getValidFaceNames().contains(faceName))
        this.faceName = faceName;
    else
        throw new IllegalArgumentException(faceName + " is invalid, must be one of "+getFaceName());
}

public String toString()
{
    return faceName + " of " + suit;
}

public String getColour()
{
    if (suit.equals("hearts") || suit.equals("diamonds"))
        return "red";
    else
        return "black";
}

/**
 * This method will return the value of the card
 * @return
 */
public int getValue()
{
    return getValidFaceNames().indexOf(faceName) + 2;
}

//public String getImageFileName()
/**
 * This method will return the image associated with this card
 * @return
 */
public Image getImage()
{
    String pathName = "images/"+faceName+"_of_"+suit+".png";
    return new Image(Card.class.getResourceAsStream(pathName));
}

public Image getBackOfCardImage()
{
    return new Image(Card.class.getResourceAsStream("images/back_of_card.png"));
}
}