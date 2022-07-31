package Check_if_All_As_Appears_Before_All_Bs_2124;

public class Solution {


    public static void main(String[] args) {


        System.out.println(checkString("bbb"));

    }

    public static boolean checkString(String s) {

        char c1,c2;
        for (int i = 0; i < s.length()-1; i++) {
            c1 = s.charAt(i);
            c2 = s.charAt(i+1);
            if(c1=='b' && c2=='a'){
                return false;
            }
        }
        return  true;
    }

}
