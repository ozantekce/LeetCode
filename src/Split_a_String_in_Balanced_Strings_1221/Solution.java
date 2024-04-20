package Split_a_String_in_Balanced_Strings_1221;

public class Solution {


    public static void main(String[] args) {

        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        System.out.println(balancedStringSplit("LLLLRRRR"));

    }


    public static int balancedStringSplit(String s) {

        int res = 0;
        int L = 0;
        int R = 0;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == 'L')
                L++;
            else
                R++;

            if(L == R){
                res++;
                L = 0;
                R = 0;
            }

        }


        return res;
    }

}
