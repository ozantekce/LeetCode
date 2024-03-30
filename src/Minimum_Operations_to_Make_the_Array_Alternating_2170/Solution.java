package Minimum_Operations_to_Make_the_Array_Alternating_2170;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(minimumOperations(new int [] {3,1,3,2,4,3}));
        //System.out.println(minimumOperations(new int [] {1,2,2,2,2}));
        //System.out.println(minimumOperations(new int [] {2,2}));
        //System.out.println(minimumOperations(new int [] {2,2,2,2}));
        //System.out.println(minimumOperations(new int [] {4,3,4,3,4,3,3,5,3,5,3,3}));
        System.out.println(minimumOperations(new int [] {4,4,4,4,3,4}));
        //System.out.println(minimumOperations(new int [] {48,38,42,18,13,1,97,88,82,48,54,16,78,59,52,30,40,77,59,87,71,28}));

    }


    public static int minimumOperations(int[] nums) {


        int oddCount  = nums.length / 2;
        int evenCount = (nums.length + 1) / 2;

        HashMap<Integer,Integer> counterOdds = new HashMap<>(oddCount);
        HashMap<Integer,Integer> counterEvens = new HashMap<>(evenCount);

        for (int i = 1; i < nums.length; i+=2) {
            counterOdds.put(nums[i], counterOdds.getOrDefault(nums[i],0)+1);
        }
        for (int i = 0; i < nums.length; i+=2) {
            counterEvens.put(nums[i], counterEvens.getOrDefault(nums[i],0)+1);
        }


        int maxCount = -1;
        int secondMaxCount = -1;
        int maxOdds0 = -1;
        int maxOdds1 = -1;
        for (var e : counterOdds.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();

            if (count > maxCount) {
                secondMaxCount = maxCount;
                maxOdds1 = maxOdds0;

                maxCount = count;
                maxOdds0 = num;
            } else if (count > secondMaxCount) {
                secondMaxCount = count;
                maxOdds1 = num;
            }
        }

        maxCount = -1;
        secondMaxCount = -1;
        int maxEvens0 = -1;
        int maxEvens1 = -1;
        for (var e : counterEvens.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();

            if (count > maxCount) {
                secondMaxCount = maxCount;
                maxEvens1 = maxEvens0;

                maxCount = count;
                maxEvens0 = num;
            } else if (count > secondMaxCount) {
                secondMaxCount = count;
                maxEvens1 = num;
            }
        }

        if(maxEvens0 != maxOdds0){
            return evenCount + oddCount - counterEvens.getOrDefault(maxEvens0,0)
                    - counterOdds.getOrDefault(maxOdds0,0);
        }
        else{
            int max0 = Integer.MIN_VALUE;
            if(maxEvens0 != maxOdds1 && maxOdds1 != -1){
                max0 = counterEvens.getOrDefault(maxEvens0,0) + counterOdds.getOrDefault(maxOdds1,0);
            }
            int max1 = Integer.MIN_VALUE;
            if(maxEvens1 != maxOdds0 && maxEvens1 != -1){
                max1 = counterEvens.getOrDefault(maxEvens1,0) + counterOdds.getOrDefault(maxOdds0,0);
            }
            int min = evenCount + oddCount - Math.max(max0, max1);
            return min < 0 ? Math.min(evenCount, oddCount) : min;
        }

    }
}
