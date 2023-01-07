package Predict_the_Winner_486;

public class Solution {


    public static void main(String[] args) {

        int [] nums = {1,5,233,7};

        System.out.println(PredictTheWinner(nums));


    }

    public static boolean PredictTheWinner(int[] nums) {

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

