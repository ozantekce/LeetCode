package Path_Crossing_1496;


import java.util.HashSet;
import java.util.Objects;

public class Solution {


    public static void main(String[] args) {

        System.out.println(isPathCrossing("SSSSS"));
        System.out.println(isPathCrossing("NESWW"));

    }

    private static int[] funcs = new int[]{
            10000,  // index 0
            0, 0, 0, 0, 0, 0, 0, 0,
            1,  // index 9
            0, 0, 0, 0,
            -1, // index 14
            0, 0, 0,
            -10000  // index 18
    };

    public static boolean isPathCrossing(String path) {

        HashSet<Integer> visited = new HashSet<>();
        int pos = 0;
        visited.add(0);
        for (int i = 0; i < path.length(); i++) {
            pos += funcs[path.charAt(i) - 'E'];
            if(!visited.add(pos)){
                return true;
            }
        }

        return false;
    }


}
