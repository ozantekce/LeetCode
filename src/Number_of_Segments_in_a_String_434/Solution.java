package Number_of_Segments_in_a_String_434;


public class Solution {


    public static void main(String[] args) {
        
    }
    
    public static int countSegments(String s) {
        
        if(s.length() == 0) return 0;
        
        int result = 0;
        
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                if(size > 0){
                    result++;
                    size = 0;
                }
            }else{
                size++;
            }
        }
        if(size > 0){
            result++;
            size = 0;
        }
        return result;
    }
}
