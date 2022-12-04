package First_Unique_Character_in_a_String_387;

public class Solution {



    public int firstUniqChar(String s) {

        int [] counter = new int[26]; // 97 - 122

        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counter[chars[i]-97]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(counter[chars[i]-97]==1){
                return i;
            }
        }
        return -1;

    }


}
