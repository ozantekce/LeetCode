package Check_If_Word_Is_Valid_After_Substitutions_1003;

public class Solution {


    public static void main(String[] args) {


        System.out.println(isValid("aabcbc"));          //true
        System.out.println(isValid("abcabcababcc"));    //true
        System.out.println(isValid("abccba"));          //false
        System.out.println(isValid("bac"));          //false
        System.out.println(isValid("aabbcc"));          //false
        System.out.println(isValid("aababcbccabc"));          //false
        System.out.println(isValid("aaabc"));          //false

    }

    public static boolean isValid(String s) {

        Stack = new char[s.length()];
        Index = -1;
        char [] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='a'){
                if(!pushStack('a'))return false;
                if(!pushStack('b'))return false;
            }
            else if(chars[i]=='b'){
                char c = popStack();
                if(c != 'b') return false;
            }
            else if(chars[i]=='c'){
                char c = popStack();
                if(c != 'a') return false;
            }
        }
        return Index ==-1;
    }

    private static char [] Stack;
    private static int Index;
    public static boolean pushStack(char c){
        Index++;
        if(Index >=Stack.length)return false;
        Stack[Index] = c;
        return true;
    }

    public static char popStack(){
        if(Index == -1)return '0';
        return Stack[Index--];
    }





}
