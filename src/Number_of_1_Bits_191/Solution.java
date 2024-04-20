package Number_of_1_Bits_191;

public class Solution {


    public static void main(String[] args) {

        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(2147483645));
    }

    public static int hammingWeight(int n) {

        int res = 0;
        while (1 <= n){
            if((n & 1) != 0)
                res++;
            n >>= 1;
        }

        return res;
    }

}
