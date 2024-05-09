package Minimum_Changes_To_Make_Alternating_Binary_String_1758;

public class Solution {


    public static void main(String[] args) {

        System.out.println(minOperations("0100"));
        System.out.println(minOperations("10"));
        System.out.println(minOperations("1111"));

    }


    public static int minOperations(String s) {
        char[] chars = s.toCharArray();
        int c0 = 0;
        int c1 = 0;
        int x = 0;
        for(int i=0; i < chars.length; i++){
            x = 1 - x;
            if(chars[i] - '0' == x){
                c0++;
            }else{
                c1++;
            }
        }
        return Math.min(c0,c1);
    }
}
