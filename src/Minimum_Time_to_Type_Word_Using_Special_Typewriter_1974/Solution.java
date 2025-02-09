package Minimum_Time_to_Type_Word_Using_Special_Typewriter_1974;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
        System.out.println(minTimeToType("zjpc"));

    }


    public static int minTimeToType(String word) {
        char[] chars = word.toCharArray();

        int res = 0;
        int pointer = 0;
        for (int i = 0; i < chars.length; i++) {
            res++;
            int target = (chars[i] - 'a');
            if (target != pointer) {
                int distance0 = target - pointer;
                int distance1 = pointer - target;
                if (distance0 < 0) distance0 = 26 + distance0;
                if (distance1 < 0) distance1 = 26 + distance1;
                res += Math.min(distance0, distance1);
                pointer = target;
            }
        }

        return res;
    }


}
