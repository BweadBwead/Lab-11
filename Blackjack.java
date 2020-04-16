//package com.company;
import java.util.Scanner;
public class Blackjack {

    public static void menu()
    {
        System.out.println("1.  Get another card");
        System.out.println("2.  Hold hand");
        System.out.println("3.  Print statistics");
        System.out.println("4.  Exit");
        //Simple menu, easy stuff
    }
    public static String card(int num)
    {
        String answer;
        switch (num) {
            case 1:
                answer = "ACE";
                break;
            case 11:
                answer = "JACK";
                break;
            case 12:
                answer = "QUEEN";
                break;

            case 13:
                answer = "KING";
                break;
            default:
                answer = Integer.toString(num);//just so I can use string for this whole part of the code
                break;
        }
        //any special cards get their name, otherwise its kept a number
        return answer;
        }

    public static void main(String[] args) {
	Scanner scnr = new Scanner(System.in);
	int choice = 0;
	int game = 1;
	int pScore = 0;
	int dScore = 0;
	int myNumber = 0;
	int pWin = 0;
	int dWin = 0;
	int tie = 0;
	double percent = 0;
	//initialized every variable here for simplicities sake
        System.out.println("START GAME #" + game);
        P1Random rng = new P1Random();
        myNumber = rng.nextInt(13)+1;

        if (myNumber < 11)
        {
            pScore += myNumber;
        }
        else
        {
            pScore += 10; //made all the face cards = 10
        }
        System.out.println("Your card is a " + card(myNumber) + "!");
        System.out.println("Your hand is: " + pScore);
        menu();
        System.out.println("Choose an option:");

	while (choice != 4) //ends if 4 is selected
    {
        choice = scnr.nextInt();
        switch (choice)
        {
            case 1:

                myNumber = rng.nextInt(13)+1;
                if (myNumber < 11)
                {
                    pScore += myNumber;
                }
                else
                {
                    pScore += 10;
                }
                System.out.println("Your card is a " + card(myNumber) + "!");
                System.out.println("Your hand is: " + pScore);
                if (pScore > 21)
                {
                    System.out.println("You exceeded 21! You lose.");
                    dWin +=1;
                    pScore = 0;
                    game +=1;
                    System.out.println("START GAME #" + game);
                    myNumber = rng.nextInt(13)+1;
                    if (myNumber < 11)
                    {
                        pScore += myNumber;
                    }
                    else
                    {
                        pScore += 10;
                    }
                    System.out.println("Your card is a " + card(myNumber) + "!");
                    System.out.println("Your hand is: " + pScore);
                    // whole thing in the (if p score > 21 ) resets the game

                }
                else if (pScore == 21)
                {
                    System.out.println("BLACKJACK! You win!");
                    pWin +=1;
                    pScore = 0;
                    game +=1;
                    System.out.println("START GAME #" + game);
                    myNumber = rng.nextInt(13)+1;
                    if (myNumber < 11)
                    {
                        pScore += myNumber;
                    }
                    else
                    {
                        pScore += 10;
                    }
                    System.out.println("Your card is a " + card(myNumber) + "!");
                    System.out.println("Your hand is: " + pScore);
                    // whole thing in the (if p score = 21 ) resets the game
                }
                menu();
                System.out.println("Choose an option:");
                // keeps going if either condition is not met
                break;
            case 2:
                dScore = rng.nextInt(11)+16;
                System.out.println("Dealer's hand: " + dScore);
                System.out.println("Your hand is: " + pScore);

                if(dScore > 21)
                {
                    System.out.println("You win!");
                    pWin+=1;
                    pScore = 0;
                    game +=1;
                    System.out.println("START GAME #" + game);
                    myNumber = rng.nextInt(13)+1;
                    if (myNumber < 11)
                    {
                        pScore += myNumber;
                    }
                    else
                    {
                        pScore += 10;
                    }
                    System.out.println("Your card is a " + card(myNumber) + "!");
                    System.out.println("Your hand is: " + pScore);
                }
                else if (dScore > pScore)
                {
                    System.out.println("Dealer wins!");
                    dWin += 1;
                    pScore = 0;
                    game +=1;
                    System.out.println("START GAME #" + game);
                    myNumber = rng.nextInt(13)+1;
                    if (myNumber < 11)
                    {
                        pScore += myNumber;
                    }
                    else
                    {
                        pScore += 10;
                    }
                    System.out.println("Your card is a " + card(myNumber) + "!");
                    System.out.println("Your hand is: " + pScore);
                }
                else if (dScore==pScore)
                {
                    System.out.println("It's a tie! No one wins!");
                    tie +=1;
                    pScore = 0;
                    game +=1;
                    System.out.println("START GAME #" + game);
                    myNumber = rng.nextInt(13)+1;
                    if (myNumber < 11)
                    {
                        pScore += myNumber;
                    }
                    else
                    {
                        pScore += 10;
                    }
                    System.out.println("Your card is a " + card(myNumber) + "!");
                    System.out.println("Your hand is: " + pScore);
                }
                else
                {
                    System.out.println("You win!");
                    pWin+=1;
                    pScore = 0;
                    game +=1;
                    System.out.println("START GAME #" + game);
                    myNumber = rng.nextInt(13)+1;
                    if (myNumber < 11)
                    {
                        pScore += myNumber;
                    }
                    else
                    {
                        pScore += 10;
                    }
                    System.out.println("Your card is a " + card(myNumber) + "!");
                    System.out.println("Your hand is: " + pScore);
                }
                //each option above ends in a reset
                menu();
                System.out.println("Choose an option:");

                break;
            case 3:
                percent = game-1; //makes percent = the completed # of games, and allows the bottom line to be a double initially
                percent = (pWin/percent); //if not for the above, it would do int division and then double that result, which always resulted in 0
                System.out.println("Number of Player wins: " + pWin);
                System.out.println("Number of Dealer wins: " + dWin);
                System.out.println("Number of tie games: " + tie);
                System.out.println("Total # of games played is: " + (game-1));
                System.out.println("Percentage of Player wins:" + (percent * 100) + "%");
                menu();
                System.out.println("Choose an option:");

                break;
            case 4:
                break;
            default:
                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                menu();
                System.out.println("Choose an option:");
                //anything else typed that was not made a case would default to this
                break;
        }
    }
    }
}
