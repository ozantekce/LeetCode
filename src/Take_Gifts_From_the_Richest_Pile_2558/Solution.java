package Take_Gifts_From_the_Richest_Pile_2558;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {


        System.out.println(pickGifts(new int[]{25,64,9,4,100}, 4));

    }


    public static long pickGifts(int[] gifts, int k) {

        long result = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int gift : gifts) {
            heap.add(gift);
        }

        for (int i = 0; i < k; i++) {
            int current = heap.poll();
            current = (int) Math.sqrt(current);
            heap.add(current);
        }

        while (!heap.isEmpty()){
            result += heap.poll();
        }

        return result;
    }

}
