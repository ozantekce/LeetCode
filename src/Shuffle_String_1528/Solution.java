package Shuffle_String_1528;

public class Solution {

    public static void main(String[] args) {

        System.out.println(restoreString("codeleet",new int[]{4,5,6,7,0,2,1,3}));

    }

    public static String restoreString(String s, int[] indices) {

        char [] chars = s.toCharArray();
        char [] rst = new char[chars.length];

        for (int i = 0; i < indices.length; i++) {

            rst[indices[i]] = chars[i];

        }

        return String.valueOf(rst);
    }


}
