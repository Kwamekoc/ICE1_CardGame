package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that models a hand of seven cards as an array and allows the
 * user to search for a specific card, as well as a hard-coded lucky card.
 * 
 * @author sivagamasrinivasan
 * @modifier Isaiah Asiamah
 * @studentNumber 991703425
 * @date October 7, 2026
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        // 1. Fill hand with 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // 1 to 13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // 0 to 3: Hearts, Diamonds, Spades, Clubs
            magicHand[i] = c;
        }

        // 2. Ask user to pick a card
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a card value (1-13): ");
        int userValue = input.nextInt();
        
        System.out.print("Enter a suit (0 for Hearts, 1 for Diamonds, 2 for Spades, 3 for Clubs): ");
        int suitIndex = input.nextInt();
        String userSuit = Card.SUITS[suitIndex];

        // 3. Search magicHand for the user's card
        boolean foundUser = false;
        for (Card c : magicHand) {
            if (c.getValue() == userValue && c.getSuit().equalsIgnoreCase(userSuit)) {
                foundUser = true;
                break;
            }
        }

        if (foundUser) {
            System.out.println("Congratulations! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }

        // 4. Hard-coded luckyCard step added via GitHub Web Editor
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        boolean foundLucky = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() && c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                foundLucky = true;
                break;
            }
        }

        if (foundLucky) {
            System.out.println("The lucky card (2 of Clubs) is in the magic hand!");
        } else {
            System.out.println("The lucky card (2 of Clubs) is not in the magic hand.");
        }
    }
}
