package inheritance.party;

public class Party {

	private int guests;

	/*
	 * public Party(int numGuests) { //System.out.println("Creating a Party class");
	 * guests = numGuests; }
	 */

	public int getGuests() {
		return guests;
	}

	public void setGuests(int numGuests) {
		guests = numGuests;
	}

	public void displayInvitation() {
		System.out.println("Please come to my party!");
	}
}
