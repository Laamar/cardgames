package edu.guilford;

public class MemoryCard extends Cards {
    //add private boolean matched
    /**
     * This attribute will be true if the card has been matched
     */
    private boolean matched;

    //add constructor that will call the super constructor and set matched to false
    /**
     * This constructor will call the super constructor and set matched to false
     * @param suit
     * @param faceName
     */
    public MemoryCard(String suit, String faceName) {
        super(suit, faceName);
        this.matched = false;
    }
    //add getter and setter for matched
    /**
     * This method will return true if the card has been matched
     * @return
     */
    public boolean isMatched() {
        return matched;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    /**
     * This method will return true if the suit and faceName of the card passed in
     * @param otherCard
     * @return
     */
    public boolean isSameCard(MemoryCard otherCard)
    {
        return (this.getSuit().equals(otherCard.getSuit()) &&
                (this.getFaceName().equals(otherCard.getFaceName())));
    }
}


    

