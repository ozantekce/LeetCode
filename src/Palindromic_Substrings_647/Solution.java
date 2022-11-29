package Palindromic_Substrings_647;

import java.util.concurrent.TimeUnit;

public class Solution {


    public static void main(String[] args) {



        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";


        long start = System.nanoTime();
        System.out.println(countSubstrings(s));
        long durationInMs = TimeUnit.MILLISECONDS.convert((System.nanoTime()-start), TimeUnit.NANOSECONDS);
        System.out.println("brute force : "+durationInMs+" ms ");

        start = System.nanoTime();
        System.out.println(countSubstringsMemorizing(s));
        durationInMs = TimeUnit.MILLISECONDS.convert((System.nanoTime()-start), TimeUnit.NANOSECONDS);
        System.out.println("memorizing :"+durationInMs+" ms ");


        start = System.nanoTime();
        System.out.println(countSubstringsDP(s));
        durationInMs = TimeUnit.MILLISECONDS.convert((System.nanoTime()-start), TimeUnit.NANOSECONDS);
        System.out.println("DP :"+durationInMs+" ms ");

    }


    public static int countSubstringsDP(String s) {

        char [] chars = s.toCharArray();
        int n = chars.length;
        boolean DP[][] = new boolean[n][n];
        int counter = 0;
        int i, j, L;
        for (i = 0; i < chars.length; i++){
            DP[i][i] = true;
        }
        counter = n;
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
                        counter++;
                    }else{
                        if(DP[i+1][j-1]){
                            allFalse1 = false;
                            DP[i][j] = true;
                            counter++;
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

        return counter;
    }

    public static int countSubstringsMemorizing(String s) {

        char [] chars = s.toCharArray();
        int counter = 0;
        memory = new int[s.length()][s.length()];
        for (int i = 0; i <s.length(); i++) {
            memory[i][i] = 1;
            counter++;
            for (int j = chars.length-1; j >= i+1; j--) {
                if(isPalindromicMemorizing(chars,i,j)){
                    counter++;
                }
            }
        }

        return counter;
    }

    public static int [][] memory;  // 0 : not calculated, 1: true , -1: false
    public static boolean isPalindromicMemorizing(char[] chars, int first, int last){

        if(memory[first][last]!=0){
            return memory[first][last]==1?true:false;
        }
        boolean b1 = chars[first]==chars[last];
        if(!b1){
            memory[first][last] = -1;
            return false;
        }
        boolean b2 = true;
        if(first+1<last-1){
            b2 = isPalindromic(chars,first+1,last-1);
        }

        if(b2){
            memory[first][last] = 1;
        }else{
            memory[first][last] = -1;
        }

        return b1&&b2;
    }

    public static int countSubstrings(String s) {

        char [] chars = s.toCharArray();
        int counter = 0;
        for (int i = 0; i <s.length(); i++) {
            for (int j = chars.length-1; j >= i; j--) {
                if(isPalindromic(chars,i,j)){
                    counter++;
                }
            }
        }

        return counter;
    }


    public static boolean isPalindromic(char[] chars,int first,int last){
        int pointer1 = first;
        int pointer2 = last;
        if(pointer1==pointer2)
            return true;
        while (pointer1<=pointer2){
            if(chars[pointer1] == chars[pointer2]){
                pointer1++;
                pointer2--;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }




}
