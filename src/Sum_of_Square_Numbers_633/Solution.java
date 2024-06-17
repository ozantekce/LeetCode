package Sum_of_Square_Numbers_633;

public class Solution {


    public static void main(String[] args) {

        System.out.println(judgeSquareSum(2147483600));

    }

    public static boolean judgeSquareSum(int c) {

        long left = 0;
        long right = (int) Math.sqrt(c);

        while (left <= right){
            long val = left*left + right*right;
            if(val == c){
                return true;
            }

            if(val > c){
                right--;
            }else{
                left++;
            }
        }

        return false;
    }


}
