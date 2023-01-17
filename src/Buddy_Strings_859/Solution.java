package Buddy_Strings_859;

public class Solution {




    enum Status{
        noDif,
        dif1,
        dif2,
    }


    public boolean buddyStrings(String s, String goal) {
        String s1 = s;
        String s2 = goal;
        if(s1.length()!=s2.length())
            return false;
        if(s1.equals(s2)){

            int counter [] = new int[26];
            char [] chars = s1.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                counter[chars[i]-96]++;
                if(counter[chars[i]-96]==2){
                    return true;
                }
            }

            return false;
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
