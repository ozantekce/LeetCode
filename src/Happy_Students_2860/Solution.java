package Happy_Students_2860;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countWays(new ArrayList<>(Arrays.asList(1,1))));
        System.out.println(countWays(new ArrayList<>(Arrays.asList(6,0,3,3,6,7,2,7))));

    }



    public static int countWays(List<Integer> nums) {

        // selectedCount > Max(selected0, selected1,...)
        // selectedCount < Min(nonselected0, nonselected1, ....)

        int counter = 0;
        int [] array = countingSort(nums);
        int n = array.length-1;
        int selectedCount = 0;
        int maxSelected = -1;
        int minNonselected = array[0];

        for (int i = 0; i < n; i++) {
            if(meetConditions(selectedCount, maxSelected, minNonselected)){
                counter++;
            }
            selectedCount++;
            maxSelected = array[selectedCount - 1];
            minNonselected = array[selectedCount];
        }
        if(meetConditions(selectedCount, maxSelected, minNonselected)){
            counter++;
        }

        return counter;
    }


    private static int[] countingSort(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return new int[0];
        }

        int[] counter = new int[nums.size()+1];
        int[] sortedArray = new int[nums.size()+1];

        for (int num : nums) {
            counter[num]++;
        }
        int i = 0;
        int pointer = 0;
        while (pointer < counter.length - 1){
            int addCount = counter[pointer];
            for (int j = 0; j < addCount; j++) {
                sortedArray[i++] = pointer;
            }
            pointer++;
        }
        sortedArray[i] = nums.size() + 1;
        return sortedArray;
    }


    private static  boolean meetConditions(int selectedCount, int maxSelected, int minNonselected){
        return selectedCount > maxSelected && selectedCount < minNonselected;
    }


}
