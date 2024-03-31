package Happy_Students_2860;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(countWays(new ArrayList<>(Arrays.asList(1,1))));
        System.out.println(countWays(new ArrayList<>(Arrays.asList(6,0,3,3,6,7,2,7))));

    }



    public static int countWays(List<Integer> nums) {

        int counter = 0;
        Collections.sort(nums);
        int n = nums.size();
        int selectedCount = 0;
        int maxSelected = -1;
        int minNonselected = nums.get(0);

        for (int i = 0; i < nums.size(); i++) {
            if(meetConditions(selectedCount, maxSelected, minNonselected, n)){
                counter++;
            }
            selectedCount++;
            maxSelected = nums.get(selectedCount - 1);
            if(selectedCount < n)
                minNonselected = nums.get(selectedCount);
            else
                minNonselected = 0;
        }
        if(meetConditions(selectedCount, maxSelected, minNonselected, n)){
            counter++;
        }

        return counter;
    }


    private static  boolean meetConditions(int selectedCount, int maxSelected, int minNonselected, int n){
        if(selectedCount == 0)
            return  selectedCount < minNonselected;
        if(selectedCount == n)
            return selectedCount > maxSelected;
        return selectedCount > maxSelected && selectedCount < minNonselected;
    }


    /*
    private static boolean meetConditions(List<Integer> selecteds, List<Integer> nonselecteds){

        int selectedCount = selecteds.size();
        for (int i = 0; i < selecteds.size(); i++) {
            if(selectedCount <= selecteds.get(i))
                return false;
        }

        for (int i = 0; i < nonselecteds.size(); i++) {
            if(selectedCount >= nonselecteds.get(i))
                return false;
        }
        return true;
    }
    */

}
