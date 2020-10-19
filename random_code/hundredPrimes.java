package random_code;

public class hundredPrimes {

    public static void main(String[] args) {

        for (int i = 0; i <= 541; i++) {
            if (i % 3 == 0 && i != 3) {
            } else if (i % 5 == 0 && i != 5) {
            } else if (i % 2 == 0 && i != 2) {
            } else if (i % 7 == 0 && i != 7) {
            } else if (i % 11 == 0 && i != 11) {
            } else {
                System.out.println(i);
            }

        }

    }

}
