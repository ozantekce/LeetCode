package Remove_Trailing_Zeros_From_a_String_2710;

public class Solution {


    public static void main(String[] args) {

        System.out.println(removeTrailingZeros("51230100"));
        System.out.println(removeTrailingZeros("123"));

    }

    public static String removeTrailingZeros(String num) {

        StringBuilder stringBuilder = new StringBuilder(num);

        int removeSize = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = stringBuilder.charAt(num.length()-1-i);
            if(c=='0'){
                removeSize++;
            }else{
                break;
            }
        }

        stringBuilder.delete(num.length()-removeSize,num.length());

        return stringBuilder.toString();
    }


}
