package Maximum_Bags_With_Full_Capacity_of_Rocks_2279;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int[] capacity = {2,3,4,5};
        int[] rocks = {1,2,4,4};

        System.out.println(maximumBags(capacity,rocks,2));

    }


    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int [] remainders = capacity;
        for (int i = 0; i < capacity.length; i++) {
            remainders[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(remainders);
        int fullBags=0;
        for (int i = 0; i <= remainders.length-1; i++) {
            int remainder = remainders[i];
            if(remainder==0){
                fullBags++;
            }else{
                if(remainder>additionalRocks){
                    break;
                }else{
                    additionalRocks-=remainder;
                    fullBags++;
                }
            }
        }

        return fullBags;
    }

/*
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        Bag[] bags = new Bag[capacity.length];

        for (int i = 0; i < capacity.length; i++) {
            bags[i] = new Bag(capacity[i],rocks[i]);
        }

        Arrays.sort(bags);

        //System.out.println(Arrays.toString(bags));
        int fullBags=0;
        for (int i = 0; i <= bags.length-1; i++) {
            Bag currentBag = bags[i];
            int remainder = currentBag.remainder();
            if(remainder==0){
                fullBags++;
            }else{
                if(remainder>additionalRocks){
                    break;
                }else{
                    additionalRocks-=remainder;
                    fullBags++;
                }
            }
        }

        return fullBags;
    }


    public static class Bag implements Comparable<Bag>{

        public int capacity;
        public int rocks;

        public Bag(int capacity, int rocks) {
            this.capacity = capacity;
            this.rocks = rocks;
        }

        @Override
        public int compareTo(Bag o) {

            if(this.remainder()>o.remainder()){
                return 1;
            }
            if(this.remainder()<o.remainder()){
                return -1;
            }
            return 0;
        }


        public int remainder(){
            return this.capacity-this.rocks;
        }

        @Override
        public String toString() {
            return "Bag{" +
                    "capacity=" + capacity +
                    ", rocks=" + rocks +
                    '}';
        }
    }
*/

}
