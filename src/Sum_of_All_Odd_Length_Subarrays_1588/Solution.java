package Sum_of_All_Odd_Length_Subarrays_1588;


public class Solution {

    public static void main(String[] args) {


        System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        System.out.println(sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println(sumOddLengthSubarrays(new int[]{10,11,12}));

    }


    public static int sumOddLengthSubarrays(int[] arr) {
        
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += ((i + 1) * (arr.length - i) + 1) / 2 * arr[i];
        }

        return sum;
    }

}
