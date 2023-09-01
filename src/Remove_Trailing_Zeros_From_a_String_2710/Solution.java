package Remove_Trailing_Zeros_From_a_String_2710;

public class Solution {


    public static void main(String[] args) {

        System.out.println(removeTrailingZeros("51230100"));
        System.out.println(removeTrailingZeros("123"));

    }

    public static String removeTrailingZeros(String num) {

        StringBuilder stringBuilder = new StringBuilder();

        boolean isOver = false;
        for (int i = num.length()-1; i >= 0; i--) {

            char c = num.charAt(i);

            if(c != '0'){
                isOver = true;
            }
            if(c == '0' && !isOver){
                continue;
            }
            stringBuilder.append(c);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }


}
