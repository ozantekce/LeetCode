package Find_the_Student_that_Will_Replace_the_Chalk_1894;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {


        System.out.println(chalkReplacer(new int[]{3,4,1,2},25));


    }


    public static int chalkReplacer(int[] chalk, int k) {

        long sums [] = new long[chalk.length];
        sums[0] = chalk[0];
        for (int i = 1; i < chalk.length; i++) {
            sums[i] = sums[i-1] + chalk[i];
        }
        long remainder = k%sums[sums.length-1];
        if(remainder==0){
            return 0;
        }else{

            int low = 0;
            int high = sums.length-1;
            int mid = 0;
            while (low<=high){
                mid = (high+low)/2;
                if(sums[mid]<remainder){
                    low = mid+1;
                }else if(sums[mid]>remainder) {
                    high = mid-1;
                }else{
                    return mid+1;
                }
            }
            return low;

        }

    }


}
