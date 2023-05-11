package edu.guilford;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MemoryGameController implements Initializable {
    //attributes
    private Label correctGuessesLabel;
    private Label guessLabel;
    private FlowPane imagesFlowPane;
    private ArrayList<MemoryCard> cardsInGame;
    private MemoryCard firstCard, secondCard;
    private int numOfGuess;
    private int numOfMatches;

    //constructor
    /**
     * This is the constructor for the MemoryGameController
     */
    void playAgain() {
        firstCard=null;
        secondCard =null;

        //create a deck of cards
        /**
         * This will create a deck of cards
         */
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        /**
         * This will deal the top card and add it to the cardsInGame ArrayList
         */
        cardsInGame = new ArrayList<>();

       
        for (int i =0; i<imagesFlowPane.getChildren().size()/2; i++)
        {
            Cards cardDealt = deck.dealTopCard();
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(),cardDealt.getFaceName()));
            cardsInGame.add(new MemoryCard(cardDealt.getSuit(),cardDealt.getFaceName()));
        }
        Collections.shuffle(cardsInGame);
        flipAllCards();

    }

    /**
     * This will flip the card that is clicked on
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeImageView();
        playAgain();
    }

    /**
     * This will initialize the ImageView
     */
    private void initializeImageView()
    {
        for (int i=0; i<imagesFlowPane.getChildren().size();i++)
        {
            //"cast" the Node to be of type ImageView
            /**
             * This will cast the Node to be of type ImageView
             */
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Card.class.getResourceAsStream("images/back_of_card.png")));
            imageView.setUserData(i);

            //register a click listener
            /**
             * This will register a click listener
             */
            imageView.setOnMouseClicked(event -> {
                flipCard((int) imageView.getUserData());
            });
        }
    }

   /**
    * This will flip all the cards
    */
    private void flipAllCards()
    {
        for (int i=0; i<cardsInGame.size();i++)
        {
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            MemoryCard card = cardsInGame.get(i);

            if (card.isMatched())
                imageView.setImage(card.getImage());
            else
                imageView.setImage(card.getBackOfCardImage());
        }
    }

//    private void flipAllCards()
    /**
     * This will flip the card that is clicked on
     * @param indexOfCard
     */
    private void flipCard(int indexOfCard)
    {
        if (firstCard==null && secondCard==null)
            flipAllCards();

        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfCard);

        if (firstCard==null)
        {
            firstCard = cardsInGame.get(indexOfCard);
            imageView.setImage(firstCard.getImage());
        }
        else if (secondCard==null)
        {
            numOfGuess++;
            secondCard = cardsInGame.get(indexOfCard);
            imageView.setImage(secondCard.getImage());
            checkForMatch();
            updateLabels();
        }
    }

    //helper methods
    /**
     * This will update the labels
     */
    private void updateLabels()
    {
        correctGuessesLabel.setText(Integer.toString(numOfMatches));
        guessLabel.setText(Integer.toString(numOfGuess));
    }
    /**
     * This will check for a match
     */
    private void checkForMatch()
    {
        if (firstCard.isSameCard(secondCard))
        {
            numOfMatches++;
            firstCard.setMatched(true);
            secondCard.setMatched(true);
        }
        firstCard=null;
        secondCard=null;
    }

    /**
     * This will play the war game
     * @param event
     * @throws IOException
     */
    //event handlers
    void playWar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("war-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        //get the Stage object from the ActionEvent
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setTitle("War Game");
        stage.setScene(scene);
        stage.show();
    }

    
}
