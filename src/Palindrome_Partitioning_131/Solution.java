package Palindrome_Partitioning_131;
import java.util.ArrayList;
import java.util.List;


public class Solution {


    public static void main(String[] args) {

        System.out.println(partition("aab"));

    }


    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        find(s,0,new ArrayList<>(),result);

        return result;
    }


    private static void find(String s, int i, List<String> current, List<List<String>> result){

        if(i >= s.length()){
            if(!current.isEmpty()){
                result.add(new ArrayList<>(current));
            }
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = i; j < s.length(); j++) {
            stringBuilder.append(s.charAt(j));
            if(isPalindrome(stringBuilder)){
                current.add(stringBuilder.toString());
                find(s, j+1, current, result);
                current.remove(current.size()-1);
            }
        }

    }

    public static boolean isPalindrome(StringBuilder s) {

        // create valid string
        StringBuilder validString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c>=97&&c<=122) || (c>=48&&c<=57)){
                validString.append(c);
            }else if(c>=65&&c<=90){
                c+=32;
                validString.append(c);
            }
        }
        //System.out.println(validString);
        //check
        boolean isPalindrome = true;
        int first = 0, last = validString.length() - 1;
        while (first < last) {
            if (validString.charAt(first) != validString.charAt(last)) {
                isPalindrome =  false;
                break;
            }
            first++;
            last--;
        }
        return isPalindrome;
    }


}
