/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * Modifier: Isaiah Asiamah
 * Student #: XXXXXXXX
 * Date: Sept XX, 2023
 *
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 */
public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random rand = new Random();

        // Fill magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // values 1–13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // pick random suit
            magicHand[i] = c;
        }

        // Ask user for a card
        Scanner input = new Scanner(System.in);
        System.out.print("Pick a card value (1-13): ");
        int userValue = input.nextInt();
        System.out.print("Pick a suit (hearts, diamonds, clubs, spades): ");
        String userSuit = input.next();

        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search for user card in magic hand
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == userCard.getValue() &&
                c.getSuit().equalsIgnoreCase(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report result
        if (found) {
            System.out.println("You win! Your card was in the magic hand.");
        } else {
            System.out.println("Sorry, your card was not in the magic hand.");
        }

        // Hard-coded lucky card (Step 2 of ICE)
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("clubs");

        // Check if lucky card is in the hand
        boolean luckyFound = false;
        for (Card c : magicHand) {
            if (c.getValue() == luckyCard.getValue() &&
                c.getSuit().equalsIgnoreCase(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }

        if (luckyFound) {
            System.out.println("Lucky card (2 of clubs) is in the hand! You win again!");
        } else {
            System.out.println("Lucky card (2 of clubs) not in the hand. Better luck next time!");
        }
    }
}

