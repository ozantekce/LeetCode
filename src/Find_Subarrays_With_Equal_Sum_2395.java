import java.util.HashSet;
import java.util.Set;

public class Find_Subarrays_With_Equal_Sum_2395 {


    public static void main(String[] args) {

        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(findSubarrays(nums));
    }



    public static boolean findSubarrays(int[] nums) {


        Set<Integer> values = new HashSet<>();

        for (int i = 0; i < nums.length-1; i++) {
            if(!values.add(nums[i]+nums[i+1])){
                return true;
            }
        }
        
        

        return false;
    }



}
