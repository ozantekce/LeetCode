package Maximum_Nesting_Depth_of_the_Parentheses_1614;

public class Solution {

    public static void main(String[] args) {

    }


    public static int maxDepth(String s) {

        char[] chars = s.toCharArray();

        int maxLevel = 0;
        int currentLevel = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '('){
                currentLevel++;
                maxLevel = Math.max(currentLevel, maxLevel);
            }
            else if(c == ')'){
                currentLevel--;
            }
        }

        return maxLevel;
    }

}
