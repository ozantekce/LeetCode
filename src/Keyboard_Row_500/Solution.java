package Keyboard_Row_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
        System.out.println(Arrays.toString(findWords(new String[]{"omk"})));
        System.out.println(Arrays.toString(findWords(new String[]{"adsdf","sfd"})));

    }


    private static int[] CharToRow;

    public static String[] findWords(String[] words) {

        if(CharToRow == null)
            BuildCharToRow();

        List<String> result = new ArrayList<>();

        for (String s : words) {
            int row = CharToRow[s.charAt(0) - 'A'];
            boolean valid = true;
            for (int j = 1; j < s.length(); j++) {
                if (CharToRow[s.charAt(j) - 'A'] != row) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(s);
            }
        }

        return result.toArray(String[]::new);
    }


    private static void BuildCharToRow() {
        CharToRow = new int[58];
        char[][] rows = new char[3][];
        rows[0] = new char[]{'q','w','e','r','t','y','u','i','o','p'};
        rows[1] = new char[]{'a','s','d','f','g','h','j','k','l'};
        rows[2] = new char[]{'z','x','c','v','b','n','m'};

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[i].length; j++) {
                CharToRow[rows[i][j] - 'A'] = i;
                CharToRow[rows[i][j] - 32 - 'A'] = i;
            }
        }
    }


}
