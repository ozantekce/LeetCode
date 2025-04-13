package Decode_the_Message_2325;

public class Solution {


    public static void main(String[] args) {

        System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));

    }

    public static String decodeMessage(String key, String message) {

        char[] map = new char[26];
        boolean[] set = new boolean[26];

        int k = 'a';
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == ' ' || set[c - 'a']) continue;
            map[c - 'a'] = (char) k++;
            set[c - 'a'] = true;
        }

        char[] msg = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') msg[i] = ' ';
            else msg[i] = map[c - 'a'];
        }

        return new String(msg);
    }

}
