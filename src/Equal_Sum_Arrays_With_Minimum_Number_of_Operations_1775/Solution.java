package Equal_Sum_Arrays_With_Minimum_Number_of_Operations_1775;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(minOperations(new int[]{1,2,3,4,5,6},new int[]{1,1,2,2,2,2}));
        //System.out.println(minOperations(new int[]{1,1,1,1,1,1,1},new int[]{6}));
        //System.out.println(minOperations(new int[]{6,6},new int[]{1}));
        //System.out.println(minOperations(new int[]{5,6,4,3,1,2},new int[]{6,3,3,1,4,5,3,4,1,3,4}));
        System.out.println(minOperations(new int[]{3,3,2,4,2,6,2},new int[]{6,2,6,6,1,1,4,6,4,6,2,5,4,2,1}));

    }


    public static int minOperations(int[] nums1, int[] nums2) {

        int total1 = 0 , total2 = 0;
        HashMap<Integer, Integer> counter1 = new HashMap<>(6);
        HashMap<Integer, Integer> counter2 = new HashMap<>(6);

        for (int num : nums1){
            total1 += num;
            counter1.put(num, counter1.getOrDefault(num, 0)+1);
        }
        for (int num : nums2){
            total2 += num;
            counter2.put(num, counter2.getOrDefault(num, 0)+1);
        }

        if(total1 == total2) return 0;

        // swap
        if(total2 > total1){
            int tempInt = total1;
            total1 = total2;
            total2 = tempInt;

            HashMap<Integer,Integer> tempMap = counter1;
            counter1 = counter2;
            counter2 = tempMap;
        }

        int diff = total1 - total2;

        int i_start = 1;
        int j_start = 6;

        int ops = 0;
        while (true){
            if(diff > 0){
                ops++;
                int smaller = 6;
                for (int i = i_start; i <= 6; i++) {
                    if(counter2.containsKey(i) && counter2.get(i) > 0){
                        smaller = i;
                        i_start = smaller;
                        break;
                    }
                }
                int bigger = 1;
                for (int i = j_start; i >= 1; i--) {
                    if(counter1.containsKey(i) && counter1.get(i) > 0){
                        bigger = i;
                        j_start = bigger;
                        break;
                    }
                }

                if(smaller == 6 && bigger == 1)
                    return -1;

                int d1 = 6 - smaller;
                int d2 = bigger - 1;

                if(d2 > d1){
                    int dec = bigger - 1;
                    diff -= dec;

                    counter1.put(bigger, counter1.get(bigger)-1);
                    counter1.put(1, counter1.getOrDefault(1, 0)+1);

                }else {
                    int inc = 6 - smaller;
                    diff -= inc;

                    counter2.put(smaller, counter2.get(smaller)-1);
                    counter2.put(6, counter2.getOrDefault(6, 0)+1);
                }

            }else{
                return ops;
            }
        }

    }



}
