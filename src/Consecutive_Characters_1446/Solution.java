package Consecutive_Characters_1446;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxPower("leetcodeee"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));

    }


    public static int maxPower(String s) {

        int max = 1;
        int size = 1;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == last){
                size++;
            }else{
                last = c;
                if(size > max){
                    max = size;
                }
                size = 1;
            }
        }

        if(size > max){
            max = size;
        }

        return max;
    }


}
