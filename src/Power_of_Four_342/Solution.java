package Power_of_Four_342;

public class Solution {

    public static void main(String[] args) {


        for (int i = 0; i < 6000; i++) {
            if(isPowerOfFour(i))
                System.out.println(i+" = "+isPowerOfFour(i));

        }


    }


    public static boolean isPowerOfFour(int n) {

        if(n==1){
            return true;
        }
        boolean first = true;
        if(n%2==1)
            return false;

        while (n>0){
            n=n>>1;
            if(first){
                first = false;
                if(n%2==1)
                    return false;
            }else{
                first = true;
                if(n==1){
                    return true;
                }else if(n%2==1){
                    return false;
                }
            }

        }

        return false;
    }


}
