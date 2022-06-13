package Majority_Element_169;

public class Solution {


    public static int majorityElement(int[] nums) {

        mergeSort(nums,0,nums.length-1);

        int c = nums.length/2;

        int i=1;
        for ( ; i < nums.length && c>0; i++) {

            if(nums[i]==nums[i-1]){
                c--;
            }else{
                c = nums.length/2;
            }

        }

        return nums[i-1];
    }

    public static void mergeSort(int A[],int p,int r ){

        if(r>p){
            int q = (p+r)/2;
            mergeSort(A,p,q);
            mergeSort(A,q+1,r);
            merge(A,p,q,r);
        }


    }

    private static void merge(int[] A, int p, int q, int r) {

        int n1 = q-p+1;
        int n2 = r-q;

        int L [] = new int[n1+1];
        int R [] = new int[n2+1];

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        for (int i = 0; i < n1; i++) {
            L[i] = A[p+i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[q+1+i];
        }

        int i=0;
        int j=0;

        for (int k = p; k <= r; k++) {

            if(L[i]<=R[j]){
                A[k] = L[i];
                i++;
            }else{
                A[k] = R[j];
                j++;
            }

        }


    }

}
