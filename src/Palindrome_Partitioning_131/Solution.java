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
            result.add(new ArrayList<>(current));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j)){
                current.add(s.substring(i, j+1));
                find(s, j+1, current, result);
                current.remove(current.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s, int first, int last) {

        boolean isPalindrome = true;
        while (first < last) {
            if (s.charAt(first) != s.charAt(last)) {
                isPalindrome =  false;
                break;
            }
            first++;
            last--;
        }
        return isPalindrome;
    }


}
