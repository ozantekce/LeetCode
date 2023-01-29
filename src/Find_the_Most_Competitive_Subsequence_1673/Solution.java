package Find_the_Most_Competitive_Subsequence_1673;

import java.util.*;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(mostCompetitive(new int[]{71,18,52,29,55,73,24,42,66,8,80,2},3)));

    }

    public static int[] mostCompetitive(int[] nums, int k) {

        Stack<Integer> stack = new Stack<>();
        int maxRemove = nums.length-k;
        UpFor:
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && maxRemove!=0 && nums[i]<stack.peek()
            && stack.size()+nums.length-i>k
            ){
                stack.pop();
                maxRemove--;
            }
            stack.push(nums[i]);
        }
        while (maxRemove!=0){
            stack.pop();
            maxRemove--;
        }

        int [] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    

    /*
    public static int[] mostCompetitive(int[] nums, int k) {

        int[] stack = new int[k];
        int size = 0;

        UpFor:
        for (int i = 0; i <nums.length ; i++) {
            if(size==0){
                stack[size] = nums[i];
                size++;
            }else{
                int first = k-(nums.length-i);
                //System.out.println(first);
                if(first<0){
                    first = 0;
                }
                for (int j = first; j < size; j++) {
                    if(stack[j]>nums[i]){
                        stack[j] = nums[i];
                        size = j+1;
                        continue UpFor;
                    }
                }
                if(size<k){
                    stack[size] = nums[i];
                    size++;
                }

            }
        }


        return stack;
    }
*/




}
