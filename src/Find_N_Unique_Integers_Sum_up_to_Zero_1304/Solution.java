package Find_N_Unique_Integers_Sum_up_to_Zero_1304;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(sumZero(5)));

    }

    public static int[] sumZero(int n) {

        int [] array =new int[n];

        if(n%2==0){
            int endValue = n/2;
            int startValue =  endValue * -1;
            for (int i = startValue,j=0; i <= endValue; i++) {
                if(i==0)
                    continue;
                array[j] = i;
                j++;
            }
        }else{

            int endValue = n/2;
            int startValue =  endValue * -1;
            for (int i = startValue; i <= endValue; i++) {
                array[i+endValue] = i;
            }

        }

        return array;
    }


}
