package Longest_Substring_Of_All_Vowels_in_Order_1839;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        //System.out.println(longestBeautifulSubstring("a"));
        //System.out.println(longestBeautifulSubstring("uuuuu"));

    }

    // a == 0
    // e == 1
    // i == 2
    // o == 3
    // u == 4
    public static int longestBeautifulSubstring(String word) {

        char[] chars = word.toCharArray();
        int maxCount = 0;
        int currentCount = 0;
        int state = -1;

        if(chars[0] == 'a'){
            currentCount = 1;
            state = 0;
        }

        for (int i = 1; i < chars.length; i++) {

            char current = chars[i];

            if(state == -1){
                currentCount = 0;
                if(current == 'a'){
                    state++;
                    currentCount++;
                }
            }
            else if(state == 0){

                if(current == 'a'){
                    currentCount++;
                }else if(current == 'e'){
                    currentCount++;
                    state++;
                }else{
                    state = -1;
                }

            }
            else if(state == 1){

                if(current == 'e'){
                    currentCount++;
                }else if(current == 'i'){
                    currentCount++;
                    state++;
                }else{
                    if(current == 'a'){
                        state = 0;
                        currentCount = 1;
                    }
                    else
                        state = -1;
                }

            }
            else if(state == 2){

                if(current == 'i'){
                    currentCount++;
                }else if(current == 'o'){
                    currentCount++;
                    state++;
                }else{
                    if(current == 'a'){
                        state = 0;
                        currentCount = 1;
                    }
                    else
                        state = -1;
                }

            }
            else if(state == 3){

                if(current == 'o'){
                    currentCount++;
                }else if(current == 'u'){
                    currentCount++;
                    state++;
                    maxCount = Math.max(maxCount, currentCount);
                }else{
                    if(current == 'a'){
                        state = 0;
                        currentCount = 1;
                    }
                    else
                        state = -1;
                }

            }
            else if(state == 4){
                if(current == 'u'){
                    currentCount++;
                }else{
                    maxCount = Math.max(maxCount, currentCount);
                    if(current == 'a'){
                        state = 0;
                        currentCount = 1;
                    }
                    else
                        state = -1;
                }
            }
        }

        if(state == 4){
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }


}
