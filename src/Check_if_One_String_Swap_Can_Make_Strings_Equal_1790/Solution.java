package Check_if_One_String_Swap_Can_Make_Strings_Equal_1790;

public class Solution {


    public static void main(String[] args) {


        System.out.println(areAlmostEqual("bank","kanb"));

    }

    enum Status{
        noDif,
        dif1,
        dif2,
    }

    public static boolean areAlmostEqual(String s1, String s2) {

        if(s1.length()!=s2.length())
            return false;
        if(s1.equals(s2)){
            return true;
        }

        Status status = Status.noDif;

        char s1FirstDif = ' ';
        char s2FirstDif = ' ';

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (int i = 0; i < chars1.length; i++) {

            if(status==Status.noDif){

                if(chars1[i]!=chars2[i]){
                    status = Status.dif1;
                    s1FirstDif = chars1[i];
                    s2FirstDif = chars2[i];
                }

            }else if(status==Status.dif1){

                if(chars1[i]!=chars2[i]){

                    if(s2FirstDif==chars1[i] && chars2[i] == s1FirstDif){
                        status = Status.dif2;
                    }else{
                        return false;
                    }

                }

            }else{
                if(chars1[i]!=chars2[i]){
                    return false;
                }

            }

        }


        return status == Status.dif2;
    }

}
