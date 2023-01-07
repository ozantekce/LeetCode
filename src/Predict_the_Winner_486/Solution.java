package Predict_the_Winner_486;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int [] nums = {1,5,2};

        System.out.println(PredictTheWinner(nums));


    }

    //DP
    public static boolean PredictTheWinner(int[] nums) {

        if(nums.length==1){
            return true;
        }

        int DP[][] = new int[nums.length][nums.length];

        for (int i = 0; i < DP.length; i++) {
            DP[DP.length-1][i] = nums[i];
        }

        int len = nums.length-1;
        for (int i = 0; i < len; i++) {
            int val1 = nums[i] - DP[DP.length-1][i+1];
            int val2 = nums[i+1] - DP[DP.length-1][i];
            DP[DP.length-2][i] = Math.max(val1,val2);
        }
        boolean playerOne = false;
        for (int k = 1; k <= len-1; k++) {

            for (int i = 0; i < len-k; i++) {
                if(playerOne){
                    int val1 = +nums[i] + DP[DP.length-k-1][i+1];
                    int val2 = +nums[i+k+1] + DP[DP.length-k-1][i];
                    DP[DP.length-k-2][i] = Math.max(val1,val2);
                }else{
                    int val1 = -nums[i] + DP[DP.length-k-1][i+1];
                    int val2 = -nums[i+k+1] + DP[DP.length-k-1][i];
                    DP[DP.length-k-2][i] = Math.min(val1,val2);
                }
            }
            playerOne = !playerOne;
        }

        if(nums.length%2==0)
            return DP[0][0]>=0;
        else
            return DP[0][0]<=0;
    }



    //Recursive

    public static boolean PredictTheWinnerRecursive(int[] nums) {

        int p = point(0,0,nums,0,nums.length-1);
        return p>=0;
    }


    private static int point(int player,int currentPoint,int nums[],int f,int l){

        if(f>l){
            return currentPoint;
        }

        if(player==0){

            return Math.max(point(1,currentPoint+nums[f],nums,f+1,l)
                    ,point(1,currentPoint+nums[l],nums,f,l-1));

        }else{
            return Math.min(point(0,currentPoint-nums[f],nums,f+1,l)
                    ,point(0,currentPoint-nums[l],nums,f,l-1));
        }

    }

}

