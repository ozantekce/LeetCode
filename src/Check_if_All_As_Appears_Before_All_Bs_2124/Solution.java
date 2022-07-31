package Check_if_All_As_Appears_Before_All_Bs_2124;

public class Solution {


    public static void main(String[] args) {


        System.out.println(checkString("bbb"));

    }

    public static boolean checkString(String s) {

        if(s.contains("ba")){
            return false;
        }

        return  true;
    }

}
