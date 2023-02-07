package Two_Sum_1;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int []{2,7,11,15},9)));

        System.out.println(Arrays.toString(twoSum(new int []{3,2,4},6)));

        System.out.println(Arrays.toString(twoSum(new int []{3,3},6)));

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] copy = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        int i=0;
        int f=copy.length-1;
        int sum;
        int val1 = 0;
        int val2 = 0;
        while (i!=f){
            sum = copy[i]+copy[f];
            if(sum==target){
                val1 = copy[i];
                val2 = copy[f];
                break;
            }else if(sum<target){
                i++;
            }else{
                f--;
            }
        }

        int [] rst = new int[2];
        rst[0] = -1;
        rst[1] = -1;
        for (int j = 0; j < nums.length; j++) {
            if(rst[0]==-1 && nums[j]==val1){
                rst[0] = j;
                if(rst[1]!=-1)
                    break;
            }
            else if(rst[1]==-1 && nums[j]==val2){
                rst[1] = j;
                if(rst[0]!=-1)
                    break;
            }

        }
        Arrays.sort(rst);
        return rst;
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
