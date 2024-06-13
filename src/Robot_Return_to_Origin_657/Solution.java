package Robot_Return_to_Origin_657;

public class Solution {


    public static void main(String[] args) {

    }

    public static boolean judgeCircle(String moves) {
        // L = 76 | 8   [0,-1]
        // R = 82 | 14  [0,1]
        // D = 68 | 0   [-1,0]
        // U = 85 | 17  [1,0]
        int [] counter = new int[18];
        char[] chars = moves.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counter[chars[i] - 'D']++;
        }
        return counter[8] == counter[14] && counter[0] == counter[17];
    }



}
