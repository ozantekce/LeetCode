package Generate_a_String_With_Characters_That_Have_Odd_Counts_1374;

public class Solution {





    public static String generateTheString(int n) {


        char [] chars = new char[n];

        char c1 = 'a';
        char c2 = 'b';

        if(n%2==0){
            chars[0] = c2;
            for (int i = 1; i < n; i++) {
                chars[i] = c1;
            }
        }else{
            for (int i = 0; i < n; i++) {
                chars[i] = c1;
            }
        }


        return new String(chars);
    }

}
