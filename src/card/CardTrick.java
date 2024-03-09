package card;

import java.util.Random;
import java.util.Scanner;

/**
* A class that fills a magic hand of 7 cards with random Card Objects
* and then asks the user to pick a card and searches the array of cards
* for the match to the user's card. To be used as starting code in ICE 1
* Modified by Ishva Patel, Student ID: 991707553
*/
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Fill magicHand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // Random suit from SUITS array
            magicHand[i] = c;
        }

        // Ask user for card value and suit
        System.out.print("Enter the value of your card (1-13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the suit of your card (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = scanner.nextLine();

        // Create user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search magicHand for user's card
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        scanner.close();
    }
}
