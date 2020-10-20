package java_graphics.lesson8;

/**
 * @author Tishya Chhabra
 * Date: 10/18/2020
 * 
 * Class Info: Helper class for Blackjack; does all the calculations so that the user
 * can actually play against a computer (of course all based on chance). 
 */

public class BlackjackLogic {

    //array that mimics a deck of cards as well as anoher array to keep track of what card
    //has been "dealt"
    private int cards[] = new int[52];
    private boolean whichCard[] = new boolean[52];
    private int count = 0;

    private int userCount = 0;
    private int computerCount = 0;
    private int index;

    public BlackjackLogic() {
        // initializing arrays with the values 2-10 as well as the jacks, queens, kings, and aces
        for (int i = 0; i < 9; i++) {
            cards[i] = i + 2;
            cards[i + 9] = i + 2;
            cards[i + 18] = i + 2;
            cards[i + 27] = i + 2;
        }

        for (int i = 0; i < 4; i++) {
            cards[i + 36] = 10;
            cards[i + 40] = 10;
            cards[i + 44] = 10;
            cards[i + 48] = 11;
        }

        //setting all of them to false since none of the cards have been dealt yet
        for (int i = 0; i < whichCard.length; i++) {
            whichCard[i] = false;
        }
    }

    public int[] start() {

        //when the game starts, 2 cards have to be dealt, so in order to pass those 
        //to the drawing class, we store them in a small array instead of passing one-by-one
        //(since this class does not directly communicate with the drawling class)
        int[] startingValues = new int[2];

        for (int i = 0; i < 2; i++) {

            //this next set of code is:
            //  1. creating a random index to get a card from
            //  2. making sure that card isn't already dealt and if it is, generating a new random index
            //  3. adding to the user's count the value of the card as well as adding it to the array
            //  that will be returned
            //  4. setting the element at that position as 'true' so we know that card has been given
            //  5. incrementing the count to keep track of how many cards in total have been dealt
            index = (int) (Math.random() * 52);

            while (whichCard[index]) {
                index = (int) (Math.random() * 52);
            }

            userCount += cards[index];
            startingValues[i] = cards[index];
            whichCard[index] = true;
            count++;
        }

        //same thing as described on line 55, but for the 'computer' or 'dealer'
        for (int i = 0; i < 2; i++) {
            index = (int) (Math.random() * 52);

            while (whichCard[index]) {
                index = (int) (Math.random() * 52);
            }

            computerCount += cards[index];
            whichCard[index] = true;
            count++;
        }

        //debugging lol
        //System.out.println("userCount = " + userCount);
        //System.out.println("computerCount = " + computerCount);

        return startingValues;
    }

    public int hit() {
    
        //if we are out of cards, then return 0 so that the main class knows and can notify the user
        if (count >= 52)
            return 0;

        //we only do as described on line 55 if the computer has less than 21; otherwise it will
        //not take anymore cards
        if (computerCount < 21) {
            index = (int) (Math.random() * 52);
            while (whichCard[index]) {
                index = (int) (Math.random() * 52);
            }

            computerCount += cards[index];
            whichCard[index] = true;
            count++;
        }

        //doing the same thing as described on line 55
        while (whichCard[index] && count < 52) {
            index = (int) (Math.random() * 52);
        }

        userCount += cards[index];
        whichCard[index] = true;
        count++;

        /*  debugging
        System.out.println("userCount = " + userCount);
        System.out.println("computerCount = " + computerCount);
         */
       
        //returning that value so that the main class can send it to the drawing class to display
        return cards[index];
    }

    public String stay() {
        //going through and returning the outcome depending on the sum of all the cards
        if (userCount == 21 && computerCount == 21) {
            return "tie";
        } else if (userCount == 21) {
            return "user";
        } else if (computerCount == 21) {
            return "computer";
        } else {
            return "nobody";
        }
    }

    public void reset() {
        //going through and resetting everything
        for (int i = 0; i < whichCard.length; i++) {
            whichCard[i] = false;
        }
        userCount = 0;
        computerCount = 0;
        count = 0;
    }

}
