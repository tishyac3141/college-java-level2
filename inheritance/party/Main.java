package inheritance.party;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int guests;
        int choice;

        Party party = new Party();
        DinnerParty dinnerParty = new DinnerParty();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of guests for the party: ");
        guests = scanner.nextInt();
        party.setGuests(guests);

        System.out.println("The party has " + party.getGuests() + " guests");
        party.displayInvitation();

        System.out.println("Enter the number of guests for the dinner party: ");
        guests = scanner.nextInt();
        dinnerParty.setGuests(guests);

        System.out.println("Enter the number for your dinner choice; 1 for Thai Food and 2 for Indian Food: ");
        choice = scanner.nextInt();
        dinnerParty.setChoice(choice);
        System.out.println("The dinner party has " + dinnerParty.getGuests() + " guests");
        System.out.println("Menu option " + dinnerParty.getChoice() + " will be served");
        dinnerParty.displayInvitation();

        scanner.close();
    }

}
