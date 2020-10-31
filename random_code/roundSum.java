package random_code;

public class roundSum {

    public static void main(String[] args) {
        //System.out.println(roundSum(114, 115, 112));

        int height = 5;
        for(int i = 0; i < height; i++){

            for(int j = 0; j <= i; j++){
                  System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int roundSum(int a, int b, int c){

        return round10(a) + round10(b) + round10(c);
    }

    public static int round10(int num){
        int digit = 0;
        int newNum = num;
        if(newNum / 10 == 0){
            digit = newNum;
        }

        while(newNum / 10 != 0){
            if(newNum / 10 == 0){
                break;
            } else{
                digit = newNum % 10;
                newNum = newNum / 10;
            }
        }
    
        if(digit >= 5){
            return num + (10 - digit);
        } else{
            return num - digit;
        }
    }
    
}
