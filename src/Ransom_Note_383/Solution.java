package Ransom_Note_383;

public class Solution {


    public static void main(String[] args) {

        System.out.println(canConstruct("a","b"));

    }


    public static boolean canConstruct(String ransomNote, String magazine) {


        char[] charsRN = ransomNote.toCharArray();
        char[] charsM = magazine.toCharArray();

        int [] counter = new int[26];
        int last = Math.max(charsM.length, charsRN.length);

        for (int i = 0; i < last; i++) {
            if(i<charsM.length)
                counter[charsM[i]-97]++;
            if(i<charsRN.length)
                counter[charsRN[i]-97]--;
        }
        for (int i = 0; i < 26; i++) {
            if(counter[i]<0){
                return false;
            }
        }

        return true;
    }

}
