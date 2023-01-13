package Number_of_Good_Pairs_1512;

public class Solution {

    public static void main(String[] args) {

        int [] nums = {1,2,3,1,1,3};

        System.out.println(numIdenticalPairs(nums));

    }


    public static int numIdenticalPairs(int[] nums) {

        int [] counter = new int[101];

        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }
        int sum = 0;
        for (int i = 0; i < counter.length; i++) {
            sum += (counter[i]*(counter[i]-1))/2;
        }


        return sum;
    }



}
