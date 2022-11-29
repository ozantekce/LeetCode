package Power_of_Three_326;

public class Solution {

    public static void main(String[] args) {

        System.out.println(isPowerOfThree(10));

    }


    public static boolean isPowerOfThree(int n) {

        if(n<=0)
            return false;

        while (n>1){
            if(n%3!=0){
                return false;
            }
            n/=3;
        }


        return true;
    }

}
