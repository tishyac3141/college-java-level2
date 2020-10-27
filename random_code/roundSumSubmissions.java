package random_code;

public class roundSumSubmissions {

    public static void main(String[] args) {
        System.out.println(roundSum(114, 115, 112));
    }

    public static int roundSum(int a, int b, int c){

        return round10(a) + round10(b) + round10(c);
    }

    public static int round10(int num){
        if (num%10 >= 5){
            return (num/10)*10 + 10;
        } else {
            return (num/10)*10;
        }
    }
    
}
