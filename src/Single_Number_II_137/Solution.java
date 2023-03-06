package Single_Number_II_137;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43}));

    }


    // Mat solution
    // 3(x+y+...) + z = A
    // x+y+...z = B
    // -2z = A - 3B
    // z = (-2B)/-2
    public static int singleNumber(int[] nums) {

        long sumAll = 0;
        long sumOnes = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sumAll+=nums[i];
            if(set.add(nums[i])){
                sumOnes+=nums[i];
            }
        }
        long res = sumAll + (-3 * sumOnes);
        long result = -res/2;
        return (int) result;
    }

    // Set solution
    /*
    public static int singleNumber(int[] nums) {

        HashSet<Integer> set0 = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if(set0.contains(c)){
                if(set1.contains(c)){
                    set1.remove(c);
                    set0.remove(c);
                }else{
                    set1.add(c);
                }
            }else{
                set0.add(c);
            }

        }

        return set0.iterator().next();
    }
    */

}
