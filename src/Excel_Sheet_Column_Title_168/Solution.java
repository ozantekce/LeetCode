package Excel_Sheet_Column_Title_168;

public class Solution {


    public static void main(String[] args) {


        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(53));
        System.out.println(convertToTitle(2147483647));

    }

    public static String convertToTitle(int columnNumber) {

        StringBuilder stringBuilder = new StringBuilder();

        while (columnNumber > 0){
            int mod = columnNumber % 26;
            mod = mod == 0 ? 26 : mod;
            columnNumber -= mod;
            columnNumber /= 26;
            stringBuilder.append((char) (mod + 'A' - 1));
        }

        stringBuilder.reverse();
        return stringBuilder.toString();
    }


}
