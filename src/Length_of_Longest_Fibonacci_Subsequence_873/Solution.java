package Length_of_Longest_Fibonacci_Subsequence_873;
import java.util.HashMap;
import java.util.HashSet;


public class Solution {


    public static void main(String[] args) {


        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
        //System.out.println(lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));

    }




    public static int lenLongestFibSubseq(int[] arr) {

        HashMap<Integer,Integer> valueToIndex = new HashMap<>(arr.length);

        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            valueToIndex.put(arr[i], i);
            maxValue = Math.max(maxValue, arr[i]);
        }

        int [][] dp = new int[arr.length][arr.length];

        int max = 0;
        for (int i = 0; i < dp.length-2; i++) {
            for (int j = i+1; j < dp.length-1; j++) {
                int nextValue = arr[i] + arr[j];
                if(nextValue > maxValue){
                    break;
                }
                if(valueToIndex.containsKey(nextValue)){
                    int val = dp[j][valueToIndex.get(nextValue)] = dp[i][j] + 1;
                    max = Math.max(val, max);
                }
            }
        }

        return (max < 1) ? 0 : max+2;
    }

}
