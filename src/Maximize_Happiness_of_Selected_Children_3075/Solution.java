package Maximize_Happiness_of_Selected_Children_3075;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maximumHappinessSum(new int[]{1,2,3},2));
        System.out.println(maximumHappinessSum(new int[]{1,1,1,1},2));
        System.out.println(maximumHappinessSum(new int[]{2,3,4,5},1));
        System.out.println(maximumHappinessSum(new int[]{2,2,10,1,1,1,2,3,1,1},4));

    }

    public static long maximumHappinessSum(int[] happiness, int k) {

        int n = happiness.length;
        long res = 0;
        int min = Select(happiness, 0, n-1,n+1-k);
        Arrays.sort(happiness, min, n);
        for (int i = min, j = 0; i < n; i++, j++) {
            int val = happiness[n - 1 - j] - j;
            if(val <= 0)
                break;
            res += val;
        }

        return res;
    }

    public static int Select(int A[],int p,int r,int i){

        if(p==r){
            return p;
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
