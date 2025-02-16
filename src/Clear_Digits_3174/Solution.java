package Clear_Digits_3174;

public class Solution {


    public static void main(String[] args) {

        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
        System.out.println(clearDigits("cbv34"));

    }


    public static String clearDigits(String s) {
        int size = 0;
        char[] res = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                size--;
            } else {
                res[size++] = c;
            }
        }

        return new String(res, 0, size);
    }

}
