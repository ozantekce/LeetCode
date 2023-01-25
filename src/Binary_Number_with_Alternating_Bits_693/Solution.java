package Binary_Number_with_Alternating_Bits_693;

public class Solution {

    public static void main(String[] args) {

        System.out.println(hasAlternatingBits(5));

    }

    public static boolean hasAlternatingBits(int n) {

        int expected;
        int remainder = n%2;
        n=n/2;
        if(remainder==0){
            expected = 1;
        }else{
            expected = 0;
        }

        while (n>0){
            remainder = n%2;
            if(remainder!=expected){
                return false;
            }
            n=n/2;
            if(remainder==0){
                expected = 1;
            }else{
                expected = 0;
            }
        }


        return true;
    }



}
