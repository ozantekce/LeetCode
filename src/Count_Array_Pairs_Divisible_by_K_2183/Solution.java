package Count_Array_Pairs_Divisible_by_K_2183;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int [] nums = {5,9,5,5,10,9,2,6,7}; int k=2;
        System.out.println(countPairs2(nums,k));
        System.out.println(countPairs(nums,k));

    }

    public static long countPairs(int[] nums, int k) {


        if(k==1){
            long n = nums.length;
            return n*(n-1)/2;
        }

        TreeMap<Integer,Integer> stock = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int s = gcdBySteinsAlgorithm(nums[i],k);
            stock.put(s,stock.getOrDefault(s,0) + 1);
        }
        //System.out.println(stock);

        long total = 0;
        for(int a : stock.keySet()){

            for(int b : stock.keySet()){
                if( a>b || ((long)a * (long)b) % k != 0){
                    continue;
                }
                //System.out.println(" a : "+a+ " b : "+b);
                if(a==b){
                    long n = stock.get(a);
                    if(n>=2)
                        total += n*(n-1)/2;
                }else{
                    total += (long)stock.get(a) * (long)stock.get(b);
                }

            }
            stock.put(a,0);

        }
        return total;

    }



    public static int gcdBySteinsAlgorithm(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }

        if (n2 == 0) {
            return n1;
        }

        int n;
        for (n = 0; ((n1 | n2) & 1) == 0; n++) {
            n1 >>= 1;
            n2 >>= 1;
        }

        while ((n1 & 1) == 0) {
            n1 >>= 1;
        }

        do {
            while ((n2 & 1) == 0) {
                n2 >>= 1;
            }

            if (n1 > n2) {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            n2 = (n2 - n1);
        } while (n2 != 0);
        return n1 << n;
    }

    public static long countPairs2(int[] nums, int k) {


        int n  = nums.length;
        int total = 0;
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                int val = nums[i] * nums[j];
                if(val%k==0)
                    total++;
            }

        }



        return total;
    }


}
