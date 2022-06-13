package Merge_Sorted_Array_88;

public class Solution {



    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int i=0;
        int j=0;

        int array [] = new int[m+n];

        for (int k = 0; k < (m+n); k++) {

            if(i>=m){
                array[k] = nums2[j];
                j++;
                continue;
            }

            if(j>=n){
                array[k] = nums1[i];
                i++;
                continue;
            }

            if( nums1[i]<=nums2[j]){
                array[k] = nums1[i];
                i++;
            }else{
                array[k] = nums2[j];
                j++;
            }

        }


        for (int k = 0; k < m+n; k++) {
            nums1[k] = array[k];
        }


    }


}
