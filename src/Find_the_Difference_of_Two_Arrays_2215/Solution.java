package Find_the_Difference_of_Two_Arrays_2215;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {



    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) s1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) s2.add(nums2[i]);


        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());

        for(int n : s1){
            if(!s2.contains(n)){
                lists.get(0).add(n);
            }
        }

        for(int n : s2){
            if(!s1.contains(n)){
                lists.get(1).add(n);
            }
        }

        return lists;
    }

}
