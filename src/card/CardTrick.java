package card;

import java.util.Random;

/**
* A class that fills a magic hand of 7 cards with random Card Objects
* and then searches the array of cards for a lucky card.
* To be used as starting code in ICE 1
* Modified by Ishva Patel, Student ID: 991707553
*/
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        // Fill magicHand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit from SUITS array
            magicHand[i] = c;
        }

        // Hardcoded lucky card
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        // Search magicHand for lucky card
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Congratulations! The lucky card is in the magic hand.");
        } else {
            System.out.println("Sorry, the lucky card is not in the magic hand.");
        }
    }
}
