package Two_Sum_1;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int []{2,7,11,15},9)));

        System.out.println(Arrays.toString(twoSum(new int []{3,2,4},6)));

        System.out.println(Arrays.toString(twoSum(new int []{3,3},6)));

    }

    public static int[] twoSum(int[] nums, int target) {

        Element[] elements = new Element[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            elements[i] = new Element(nums[i],i);
        }

        Arrays.sort(elements);

        int i=0;
        int f=elements.length-1;
        int sum;
        while (i!=f){
            sum = elements[i].value+elements[f].value;
            if(sum==target){
                return new int[]{
                        elements[i].seq
                        ,elements[f].seq
                };
            }else if(sum<target){
                i++;
            }else{
                f--;
            }

        }

        return null;

    }


    private static class Element implements Comparable<Element>{

        public int value;
        public int seq;

        public Element(int value, int seq) {
            this.value = value;
            this.seq = seq;
        }


        @Override
        public int compareTo(Element o) {
            if(value==o.value)
                return 0;
            else if(value<o.value)
                return -1;
            else
                return 1;
        }

    }


}
