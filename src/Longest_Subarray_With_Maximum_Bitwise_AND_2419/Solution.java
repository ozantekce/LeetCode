package Longest_Subarray_With_Maximum_Bitwise_AND_2419;

public class Solution {


    public static void main(String[] args) {


        int nums [] = {586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,516529,516529,516529,516529,516529,516529,516529
                ,516529,516529,516529,516529,516529,516529,516529,516529,516529,516529,516529
                ,516529,516529,516529,516529,516529,516529,516529,516529,516529,516529,516529
                ,516529,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816
                ,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816
                ,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816
                ,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816
                ,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816,55816
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730
                ,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,586730,232392,232392,294503};

        System.out.println(longestSubarray(nums));

    }


    public static int longestSubarray(int[] nums){

        int maxValue = nums[0];
        int counter = 1;
        int maxCounter = 1;
        for (int i = 1; i < nums.length; i++) {

            if(nums[i]<maxValue){
                counter = 0;
                continue;
            }

            if(nums[i]==maxValue){
                counter++;
                if(counter>maxCounter){
                    maxCounter = counter;
                }
            }else if(nums[i]>maxValue){
                maxValue = nums[i];
                maxCounter = 1;
                counter = 1;
            }

        }

        return maxCounter;
    }

    /*
    public static int longestSubarray(int[] nums) {

        int maxValue = nums[0];
        int counter = 1;
        int recordCounter = 1;
        for (int i = 1; i < nums.length; i++) {

            if(nums[i]>maxValue){
                maxValue = nums[i];
                counter = 1;
                recordCounter = 1;
            }else if(nums[i]==maxValue && nums[i]==nums[i-1]){
                counter++;
            }else if(nums[i]!=nums[i-1]){
                recordCounter = Math.max(recordCounter,counter);
                counter = 1;
            }

        }

        return Math.max(recordCounter,counter);
    }
*/
    /*
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int DP[][] = new int[n][n];
        int i, j, L;
        int maxValue = nums[0];
        int maxLength = 1;
        for (i = 0; i < n; i++){
            DP[i][i] = nums[i];
            if(nums[i]>maxValue){
                maxValue = nums[i];
            }
        }


        for (L = 2; L <= n; L++) {

            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1;

                DP[i][j] = DP[i+1][j]&DP[i][j-1];
                System.out.println(i+" to "+j+" value :"+DP[i][j]);
                if(DP[i][j]>maxValue){
                    int length = j-i+1;
                    maxLength = length;
                    maxValue = DP[i][j];
                }else if(DP[i][j]==maxValue){
                    int length = j-i+1;
                    maxLength = Math.max(length,maxLength);
                }
            }

        }

        return maxLength;
    }
*/


/*
    public static int longestSubarray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            for (int j = i; j < nums.length; j++) {
                value &= nums[j];

                if(value>maxValue){
                    maxValue = value;
                    int length = j-i+1;
                    maxLength = length;
                }else if(value==maxValue){
                    int length = j-i+1;
                    if(length>maxLength){
                        maxLength = length;
                    }
                }


            }

        }
        return maxLength;
    }
*/

}
