package Maximum_Score_After_Splitting_a_String_1422;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxScore("011101"));

    }


    public static int left = -1;
    public static int right = -1;


    public static int maxScore(String s) {


        char [] chars = s.toCharArray();

        left = -1;
        right = -1;

        int max = 0;

        for (int i = 1; i < s.length(); i++) {

            int current = counter(chars,i);
            max = Math.max(current,max);
        }


        return max;
    }


    public static int counter(char [] chars, int rightFirst){

        if(left==-1){
            left =0;
            right =0;
            for (int i = 0; i < chars.length; i++) {

                if(i<rightFirst){
                    if(chars[i]=='0'){
                        left++;
                    }
                }else{
                    if(chars[i]=='1'){
                        right++;
                    }
                }

            }

        }else{

            if(chars[rightFirst-1]=='1'){
                right--;
            }
            if(chars[rightFirst-1]=='0'){
                left++;
            }

        }
        return left+right;

    }


}
