package Add_Digits_258;

public class Solution {


    public static void main(String[] args) {

        System.out.println(addDigits(38));

    }


    public static int addDigits(int num) {

        if(num<10)
            return num;

        int value = 0;
        while (true){
            int digit = num%10;
            value+=digit;
            num/=10;
            if(num==0){
                if(value<10){
                    return value;
                }
                num = value;
                value=0;
            }
        }

    }

}
