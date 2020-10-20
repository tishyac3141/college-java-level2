package java_graphics.lesson8;

import javax.swing.JOptionPane;

public class BlackjackLogic {

    private int cards[] = new int[52];
    private boolean whichCard[] = new boolean[52];
    private int count = 0;

    private int userCount = 0;
    private int computerCount = 0;
    private int index;

    public BlackjackLogic() {
        // initializing arrays
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

        for (int i = 0; i < whichCard.length; i++) {
            whichCard[i] = false;
        }

    }

    public int[] start() {

        int[] startingValues = new int[2];

        for (int i = 0; i < 2; i++) {
            index = (int) (Math.random() * 52);

            while (whichCard[index]) {
                index = (int) (Math.random() * 52);
            }

            userCount += cards[index];
            startingValues[i] = cards[index];
            whichCard[index] = true;
            count++;
        }

        for (int i = 0; i < 2; i++) {
            index = (int) (Math.random() * 52);

            while (whichCard[index]) {
                index = (int) (Math.random() * 52);
            }

            computerCount += cards[index];
            whichCard[index] = true;
            count++;
        }

        System.out.println("userCount = " + userCount);
        System.out.println("computerCount = " + computerCount);

        return startingValues;
    }

    public int hit() {
    
        if (count >= 52)
            return 0;

        if (computerCount < 21) {
            index = (int) (Math.random() * 52);
            while (whichCard[index]) {
                index = (int) (Math.random() * 52);
            }

            computerCount += cards[index];
            whichCard[index] = true;
            count++;
        }

        while (whichCard[index] && count < 52) {
            index = (int) (Math.random() * 52);
        }

        userCount += cards[index];
        whichCard[index] = true;
        count++;

        System.out.println("userCount = " + userCount);
        System.out.println("computerCount = " + computerCount);

        return cards[index];
    }

    public String stay() {
        System.out.println(userCount);
        System.out.println(computerCount);
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
        for (int i = 0; i < whichCard.length; i++) {
            whichCard[i] = false;
        }
        userCount = 0;
        computerCount = 0;
        count = 0;
    }

    public int getUserCount(){
        return userCount;
    }

}
