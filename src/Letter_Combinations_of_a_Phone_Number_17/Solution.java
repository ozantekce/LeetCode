package Letter_Combinations_of_a_Phone_Number_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("7"));
        System.out.println(letterCombinations("9"));

    }


    private static boolean Configurated = false;
    private static HashMap<Character,List<Character>> NumberToChars;
    private static List<String> Results = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {

        configuration();
        Results.clear();
        if(digits.length()!=0) findRecursive(0,digits,new StringBuilder());
        return Results;
    }



    private static void configuration(){

        if(Configurated) return;
        Configurated = true;
        NumberToChars = new HashMap<>();
        char j = 'a';
        for (int i = 2; i < 10; i++) {
            char n = (char) ('0' + i);
            List<Character> characters = new ArrayList<>();
            for (int k = 0; k < 3; k++) characters.add(j++);
            NumberToChars.put(n,characters);
            if(n=='7')characters.add(j++);
            if(n=='9')characters.add(j++);
        }

    }


    private static void findRecursive(int index,String digits, StringBuilder stringBuilder){

        if(index>=digits.length()){
            Results.add(stringBuilder.toString());
            return;
        }

        List<Character> characters = NumberToChars.get(digits.charAt(index));
        for (char c : characters) {
            stringBuilder.append(c);
            findRecursive(index+1,digits,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }

}
