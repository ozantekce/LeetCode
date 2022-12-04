package Power_of_Two_231;

public class Solution {


    public static void main(String[] args) {

       for (int i = 0; i < 100; i++) {
            System.out.println("i : "+i+" : "+isPowerOfTwo(i));
        }

    }

    public static boolean isPowerOfTwo(int n) {

        if(n<=0)
            return false;
        while (n>2){
            if(n%2==1){
                return false;
            }else{
                n=n>>1;
            }
        }
        return true;
    }

}
