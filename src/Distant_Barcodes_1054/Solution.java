package Distant_Barcodes_1054;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{1,1,1,2,2,2})));
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{1,1,1,1,2,2,3,3})));
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{2,2,1,3})));
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{2,2,2,1,5})));
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{2,1,1})));
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{7,7,7,8,5,7,5,5,5,8})));

    }

    public static int[] rearrangeBarcodes(int[] barcodes) {

        Pair.Memory = new Pair[10001];
        Set<Pair> pairs = new HashSet<>();
        for (int i = 0; i < barcodes.length; i++) {
            Pair p = Pair.getPair(barcodes[i]);
            p.count++;
            pairs.add(p);
        }

        Pair [] pairsArray = pairs.toArray(new Pair[0]);
        Arrays.sort(pairsArray);
        int i=0;
        for (Pair p: pairsArray) {
            int num = p.num;
            int c = p.count;
            while (c>0){
                barcodes[i] = num;
                i+=2;
                if(i>=barcodes.length)i=1;
                c--;
            }
        }


        return barcodes;
    }

    public static class Pair implements Comparable<Pair>{

        private static Pair [] Memory;

        private int num;
        private int count;

        private Pair(int num) {
            this.num = num;
            this.count = 0;
        }


        public static Pair getPair(int num){
            if(Memory[num]!=null){
                return Memory[num];
            }else {
                return Memory[num] = new Pair(num);
            }
        }

        @Override
        public int compareTo(Pair o) {
            if(this.num==o.num) return 0;
            if(this.count>o.count)return -1;
            if(this.count<o.count)return 1;
            if(this.num>o.num)return -1;
            else return 1;
        }

    }

}
