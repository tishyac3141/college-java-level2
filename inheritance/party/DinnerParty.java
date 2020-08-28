package inheritance.party;

public class DinnerParty extends Party {

    private int dinnerChoice;

    /*
     * public DinnerParty(int numGuests) { super(numGuests); }
     */

    public int getChoice() {
        return dinnerChoice;
    }

    public void setChoice(int choice) {
        dinnerChoice = choice;
    }

}
