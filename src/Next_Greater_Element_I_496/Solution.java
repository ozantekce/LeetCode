package Next_Greater_Element_I_496;

import com.sun.jdi.Value;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(nextGreaterElement(
                new int[]{2,4},
                new int[]{1,2,3,4}
        )));

    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> valueIndexPair = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            valueIndexPair.put(nums2[i],i);
        }

        UpFor:
        for (int i = 0; i < nums1.length; i++) {
            int value = nums1[i];
            nums1[i] = -1;
            if(valueIndexPair.containsKey(value)){
                for (int j = valueIndexPair.get(value)+1; j < nums2.length; j++) {
                    if(nums2[j]>value){
                        nums1[i] = nums2[j];
                        continue UpFor;
                    }
                }
            }
        }


        return nums1;
    }


/*
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {


        FirstFor:
        for (int i = 0; i < nums1.length; i++) {
            int value1 = nums1[i];
            nums1[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                int value2 = nums2[j];
                if(value1 == value2){
                    for (int k = j+1; k < nums2.length; k++) {
                        int value3 = nums2[k];
                        if(value3>value2){
                            nums1[i] = value3;
                            continue FirstFor;
                        }
                    }
                }

            }

        }


        return nums1;
    }
*/
}
