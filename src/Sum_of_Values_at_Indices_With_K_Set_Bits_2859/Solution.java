package Sum_of_Values_at_Indices_With_K_Set_Bits_2859;

import java.util.Arrays;
import java.util.List;

public class Solution {



    public static void main(String[] args) {

        System.out.println(sumIndicesWithKSetBits(Arrays.asList(5,10,1,5,2),1));
        //System.out.println(sumIndicesWithKSetBits(Arrays.asList(4,3,2,1),2));
        System.out.println(sumIndicesWithKSetBits(Arrays.asList(1),0));

    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(Integer.bitCount(i) == k){
                result += nums.get(i);
            }
        }

        return result;
    }


}
