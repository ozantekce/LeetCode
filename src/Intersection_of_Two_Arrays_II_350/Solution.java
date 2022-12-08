package Intersection_of_Two_Arrays_II_350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {



        int [] nums1 = {1,2,2,1};
        int [] nums2 = {1,1};

        System.out.println(Arrays.toString(intersect(nums1,nums2)));


    }


    public static int[] intersect(int[] nums1, int[] nums2) {


        int [] counter1 = new int[1001];
        int [] counter2 = new int[1001];

        for (int i = 0; i < Math.max(nums1.length,nums2.length); i++) {
            if(i < nums1.length){
                counter1[nums1[i]]++;
            }
            if(i < nums2.length){
                counter2[nums2[i]]++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {

            if(counter1[i]>0 && counter2[i]>0){
                int min = Math.min(counter1[i],counter2[i]);
                for (int j = 0; j < min; j++) {
                    list.add(i);
                }
            }

        }

        int array [] = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }




/*
    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //4,5,9
        //4,4,8,9,9

        int first1 = 0;
        int first2 = 0;

        int minLength = Math.min(nums1.length,nums2.length);

        List<Integer> intersects = new ArrayList<>();

        if(minLength==nums1.length){
            for (int i = first1; i < nums1.length; i++) {
                int index = Arrays.binarySearch(nums2,first2,nums2.length,nums1[i]);
                if(index>=0){

                    while (index>0){
                        if(nums2[index-1]==nums1[i]){
                            index--;
                        }else{
                            break;
                        }
                    }

                    first2 = index+1;
                    nums2[index] = -1;
                    intersects.add(nums1[i]);
                }
            }
        }else{
            for (int i = first2; i < nums2.length; i++) {
                int index = Arrays.binarySearch(nums1,first1,nums1.length,nums2[i]);
                if(index>=0){
                    while (index>0){
                        if(nums1[index-1]==nums2[i]){
                            index--;
                        }else{
                            break;
                        }
                    }

                    first1 = index+1;
                    nums1[index] = -1;
                    intersects.add(nums2[i]);
                }
            }
        }


        int array [] = new int[intersects.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = intersects.get(i);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
*/


}
