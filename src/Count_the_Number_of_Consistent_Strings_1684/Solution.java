package Count_the_Number_of_Consistent_Strings_1684;

public class Solution {

    public static void main(String[] args) {

        String allowed = "ab";
        String [] words = {"ad","bd","aaab","baa","badab"};
        System.out.println(countConsistentStrings(allowed,words));

    }


    public static int countConsistentStrings(String allowed, String[] words) {
        char [] tokens = allowed.toCharArray();
        int counter=0;
        for (int i = 0; i < words.length; i++) {
            if(controller(tokens,words[i])){
                counter++;
            }
        }
        return counter;
    }
    
    public static boolean controller(char[] tokens, String word){
        
        char[] chars = word.toCharArray();
        UpperFor:
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < tokens.length; j++) {
                if(chars[i]==tokens[j]){
                    continue UpperFor;
                }
            }
            return false;
        }
        
        return true;
    }
    

}
