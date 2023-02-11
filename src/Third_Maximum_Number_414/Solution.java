package Third_Maximum_Number_414;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int [] nums = {1,2};
        //5,3,2,1
        System.out.println(thirdMax(nums));

    }



    public static int thirdMax(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        nums = new int[set.size()];
        int i =0;
        for (int v: set) {
            nums[i] = v;
            i++;
        }

        if(nums.length>=3)
            return Select(nums,0,nums.length-1,nums.length-2);
        else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }else{
            return nums[0];
        }

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
    /*
    public static int thirdMax(int[] nums) {

        Arrays.sort(nums);
        int [] maxs = new int[3];
        int j = 0;
        int lastVal = nums[0];
        maxs[0] = lastVal;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]!=lastVal){
                maxs[j] = nums[i];
                j++;
                if(j==3){
                    return maxs[2];
                }
            }
            lastVal = nums[i];
        }
        return maxs[0];
    }
*/

/*
    public static int thirdMax(int[] nums) {

        TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>()
        {
            public int compare(Integer i1,Integer i2)
            {
                return i2.compareTo(i1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size()>=3){
            int i =0;
            for (int value:set) {
                i++;
                if(i==3){
                    return value;
                }
            }

        }else{
            return set.first();
        }
        return 0;
    }
*/

}
