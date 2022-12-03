package To_Lower_Case_709;

public class Solution {


    public static void main(String[] args) {


        System.out.println(toLowerCase("HellO"));
    }


    public static String toLowerCase(String s) {

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>=65&&chars[i]<=90){
                chars[i] +=32;
            }
        }

        return new String(chars);
    }

}
