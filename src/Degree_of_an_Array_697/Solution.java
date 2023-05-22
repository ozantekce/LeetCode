package Degree_of_an_Array_697;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {



    public static void main(String[] args) {

        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
        System.out.println(findShortestSubArray(new int[]{1}));
        System.out.println(findShortestSubArray(new int[]{1,1}));

    }


    public static int findShortestSubArray(int[] nums) {


        HashMap<Integer,Integer> frequency = new HashMap<>();
        IndexValuePair [] indexValuePairs = new IndexValuePair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i],frequency.getOrDefault(nums[i],0)+1);
            indexValuePairs[i] = new IndexValuePair(i,nums[i]);
        }

        int [] targets = new int[frequency.size()];
        int targetSize = 0;
        int maxFreq = 0;

        for (Map.Entry<Integer,Integer> e : frequency.entrySet()) {
            int element = e.getKey();
            int freq = e.getValue();

            if(freq>maxFreq){
                maxFreq = freq;
                targetSize = 0;
            }
            if(freq==maxFreq){
                targets[targetSize] = element;
                targetSize++;
            }
        }

        Arrays.sort(indexValuePairs);

        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < targetSize; i++) {
            minResult = Math.min(minResult,findResultForTarget(indexValuePairs,targets[i],frequency.get(targets[i])));
        }

        return minResult;
    }

    private static int findResultForTarget(IndexValuePair nums[],int target,int freq){

        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid].value == target) {
                result = mid;
                end = mid - 1;
            } else if (nums[mid].value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int firstIndex = nums[result].index;
        int lastIndex = nums[result+freq-1].index;

        return lastIndex-firstIndex+1;

    }


    private static class IndexValuePair implements  Comparable<IndexValuePair>{

        int index;
        int value;

        public IndexValuePair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(IndexValuePair o) {

            if(this.value>o.value) return +1;
            else if(this.value<o.value) return -1;
            else{
                if(this.index>o.index)return +1;
                else return -1;
            }

        }
    }




}
