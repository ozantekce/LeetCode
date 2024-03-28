package Number_of_Different_Integers_in_a_String_1805;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {

        String word = "a01aaa01";


        System.out.println(numDifferentIntegers(word));

    }

    public static int numDifferentIntegers(String word) {

        char [] chars = word.toCharArray();
        boolean numberState = false;

        boolean enterNumberState = false;
        boolean exitNumberState = false;

        int numberStart = 0;
        int nonZeroStart = -1;

        Set<String> counter = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {

            if(chars[i]>=48&&chars[i]<=57){
                if(!numberState){
                    enterNumberState = true;
                }
            }else{
                if(numberState){
                    exitNumberState = true;
                }
            }

            if(enterNumberState){
                enterNumberState =false;
                numberState = true;
                numberStart = i;
            }

            if(exitNumberState){
                numberState = false;
                exitNumberState = false;
                counter.add(word.substring(numberStart,i).replaceFirst("^0+(?!$)", ""));
            }

        }

        if(numberState){
            counter.add(word.substring(numberStart).replaceFirst("^0+(?!$)", ""));
        }


        return counter.size();
    }


    /*
    public static int numDifferentIntegers(String word) {

        String [] strings = word.split("[a-z]+");

        Set<String> counter = new HashSet<>();

        for (int i = 0; i < strings.length; i++) {
            if(!strings[i].equals("")){
                counter.add(strings[i].replaceFirst("^0+(?!$)", ""));
            }
        }


        return counter.size();
    }
*/



}
