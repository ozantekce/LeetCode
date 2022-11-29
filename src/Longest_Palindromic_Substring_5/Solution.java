package Longest_Palindromic_Substring_5;

public class Solution {


    public static void main(String[] args) {

        String s = "babad";

        System.out.println(longestPalindrome(s));

    }


    public static String longestPalindrome(String s) {

        char [] chars = s.toCharArray();
        int n = chars.length;
        boolean DP[][] = new boolean[n][n];
        int max = 1;
        int maxI = 0;
        int maxJ = 0;
        int i, j, L;
        for (i = 0; i < chars.length; i++){
            DP[i][i] = true;
        }

        boolean allFalse1;
        int allFalseCounter = 0;
        for (L = 2; L <= n; L++)
        {
            allFalse1 = true;
            for (i = 0; i < n - L + 1; i++)
            {
                j = i + L - 1;
                if(!(chars[i]==chars[j])){
                    DP[i][j] = false;
                }else{
                    if(i+1==j){
                        allFalse1 = false;
                        DP[i][j] = true;
                        int value = j-i+1;
                        if(value>max){
                            max = value;
                            maxI = i;
                            maxJ = j;
                        }
                    }else{
                        if(DP[i+1][j-1]){
                            allFalse1 = false;
                            DP[i][j] = true;
                            int value = j-i+1;
                            if(value>max){
                                max = value;
                                maxI = i;
                                maxJ = j;
                            }
                        }
                    }
                }

            }

            if(allFalse1){
                allFalseCounter++;
            }else{
                allFalseCounter =0;
            }
            if(allFalseCounter>=2){
                break;
            }

        }

        return s.substring(maxI,maxJ+1);
    }


}
