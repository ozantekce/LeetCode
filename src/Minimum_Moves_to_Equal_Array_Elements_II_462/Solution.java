package Minimum_Moves_to_Equal_Array_Elements_II_462;

import java.util.Random;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minMoves2(new int[]{1,2,3}));
        System.out.println(minMoves2(new int[]{1,10,2,9}));

    }

    public static int minMoves2(int[] nums) {

        int mid = Select(nums,0,nums.length-1,nums.length/2+1);
        int c = 0;
        for (int i = 0; i < nums.length; i++)c += Math.abs(mid-nums[i]);

        return c;
    }

    public static int Select(int A[],int p,int r,int i){

        if(p==r){
            return A[p];
        }

        int q = R_PartitionH(A,p,r);
        int k = q-p+1;

        if(i<=k)
            return Select(A,p,q,i);
        else
            return Select(A,q+1,r,i-k);


    }

    public static Random random = new Random();
    public static int R_PartitionH(int A[],int p, int r){


        int s = random.nextInt(p,r+1);
        int holder = A[p];
        A[p] = A[s];
        A[s] = holder;
        return H_Partition(A,p,r);

    }

    private static int H_Partition(int[] A, int p, int r) {

        int pivot = A[p] ;
        int i=p-1;
        int j=r+1;

        while (true){

            while (true){
                j = j-1;
                if(A[j]<=pivot)
                    break;
            }

            while (true){
                i = i +1;
                if(A[i]>=pivot)
                    break;
            }

            if(i<j){
                int holder = A[i];
                A[i] = A[j];
                A[j] = holder;
            }else{
                return j;
            }

        }

    }



}
