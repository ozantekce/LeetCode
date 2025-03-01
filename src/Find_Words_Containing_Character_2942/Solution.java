package Find_Words_Containing_Character_2942;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }


    public List<Integer> findWordsContaining(String[] words, char x) {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }

        return result;
    }

}
