package Excel_Sheet_Column_Number_171;

public class Solution {


    public static void main(String[] args) {


        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("B"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("FXSHRXW"));

    }

    public static int titleToNumber(String columnTitle) {
        char [] chars = columnTitle.toCharArray();

        int num = 0;
        int mul = 1;
        for (int i = chars.length-1; i >= 0; i--) {
            num += (chars[i]-64) * mul;
            mul*=26;
        }

        return num;
    }

}
