package Intersection_of_Two_Arrays_349;

import java.util.*;

public class Solution {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(intersection(new int[]{4,9,5},new int [] {9,4,9,8,4})));

    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1  = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int val : set1 ) {
            if(set2.contains(val)){
                list.add(val);
            }
        }
        int array []  = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }

}
