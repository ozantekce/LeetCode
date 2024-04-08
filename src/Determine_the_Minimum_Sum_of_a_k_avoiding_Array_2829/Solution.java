package Determine_the_Minimum_Sum_of_a_k_avoiding_Array_2829;

public class Solution {

    public static void main(String[] args) {

        System.out.println(minimumSum(5,4));
        System.out.println(minimumSum(2,6));
        System.out.println(minimumSum(2,1));

    }


    public static int minimumSum(int n, int k) {

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            int avoid = k - i;
            if(avoid > 0 && i > avoid){
                sum -= i;
                n++;
                //System.out.println("avoid: "+avoid);
            }
        }
        //System.out.println("--------------------");
        return sum;
    }


}
