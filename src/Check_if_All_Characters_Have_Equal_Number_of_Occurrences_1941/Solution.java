package Check_if_All_Characters_Have_Equal_Number_of_Occurrences_1941;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(areOccurrencesEqual("aaabb"));


    }

    
    public static boolean areOccurrencesEqual(String s) {

        int [] counter = new int [128];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
        }
        int value = 0;
        for (int i = 0; i < 128; i++) {
            if(counter[i]!=0){
                if(value==0)
                    value = counter[i];
                else if(value!=counter[i]){
                    return false;
                }

            }
        }

        return true;
    }

}
