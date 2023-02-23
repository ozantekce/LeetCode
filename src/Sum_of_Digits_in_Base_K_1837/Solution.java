package Sum_of_Digits_in_Base_K_1837;

public class Solution {

    public static void main(String[] args) {

        System.out.println(sumBase(42,2));

    }

    public static int sumBase(int n, int k) {
        int result = 0;
        while (n>0){
            int r = n%k;
            result+=r;
            n/=k;
        }

        return result;
    }

}
