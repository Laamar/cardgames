package edu.guilford;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Card extends Parent {

    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 140;

    enum Suit {
       HEARTS, DIAMONDS, CLUBS, SPADES;

        final Image image;

        Suit() {
            this.image = new Image("file:".concat(name().toLowerCase()).concat(".png"),
                    32, 32, true, true);
        }

        public Paint getColor() {
            return null;
        }
    }

    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);

        final int value;
        Rank(int value) {
            this.value = value;
        }

        String displayName() {
            return ordinal() < 9 ? String.valueOf(value) : name().substring(0, 1);
        }
    }

    public final Suit suit;
    public final Rank rank;
    public final int value;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;

        Rectangle rec = new Rectangle(CARD_WIDTH, CARD_HEIGHT);
        rec.setArcWidth(20);
        rec.setArcHeight(20);
        rec.setFill(Color.WHITE);

        Text text1 = new Text(rank.displayName());
        text1.setFont(Font.font(18));
        text1.setX(CARD_WIDTH - text1.getLayoutBounds().getWidth() - 10);
        text1.setY(text1.getLayoutBounds().getHeight());

        Text text2 = new Text(text1.getText());
        text2.setFont(Font.font(18));
        text2.setX(10);
        text2.setY(CARD_HEIGHT - 10);

        ImageView view = new ImageView(suit.image);
        view.setRotate(180);
        view.setX(CARD_WIDTH - 32);
        view.setY(CARD_HEIGHT - 32);

        getChildren().addAll(rec, new ImageView(suit.image), view, text1, text2);
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }

    public Image getImage() {
        return null;
    }

    public int getValue() {
        return 0;
    }
}