package Happy_Students_2860;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countWays(new ArrayList<>(Arrays.asList(1,1))));
        System.out.println(countWays(new ArrayList<>(Arrays.asList(6,0,3,3,6,7,2,7))));

    }



    public static int countWays(List<Integer> nums) {

        int counter = 0;
        int [] array = countingSort(nums);
        int n = array.length;
        int selectedCount = 0;
        int maxSelected = -1;
        int minNonselected = array[0];

        for (int i = 0; i < array.length; i++) {
            if(meetConditions(selectedCount, maxSelected, minNonselected, n)){
                counter++;
            }
            selectedCount++;
            maxSelected = array[selectedCount - 1];
            if(selectedCount < n)
                minNonselected = array[selectedCount];
            else
                minNonselected = 0;
        }
        if(meetConditions(selectedCount, maxSelected, minNonselected, n)){
            counter++;
        }

        return counter;
    }


    private static int[] countingSort(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return new int[0];
        }

        int[] counter = new int[nums.size()];
        int[] sortedArray = new int[nums.size()];

        for (int num : nums) {
            counter[num]++;
        }

        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }

        for (int i = nums.size() - 1; i >= 0; i--) {
            sortedArray[counter[nums.get(i)] - 1] = nums.get(i);
            counter[nums.get(i)]--;
        }

        return sortedArray;
    }


    private static  boolean meetConditions(int selectedCount, int maxSelected, int minNonselected, int n){
        if(selectedCount == 0) return  selectedCount < minNonselected;
        else if(selectedCount == n)  return selectedCount > maxSelected;
        else return selectedCount > maxSelected && selectedCount < minNonselected;
    }


}
