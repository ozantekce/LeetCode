package Path_Crossing_1496;


import java.util.HashSet;
import java.util.Objects;

public class Solution {


    public static void main(String[] args) {

        System.out.println(isPathCrossing("SSSSS"));
        System.out.println(isPathCrossing("NESWW"));

    }



    public static boolean isPathCrossing(String path) {

        HashSet<Integer> visited = new HashSet<>();
        int x = 0;
        int y = 0;

        visited.add(0);
        for (int i = 0; i < path.length(); i++) {
            char d = path.charAt(i);
            if(d == 'N'){
                y++;
            }else if(d == 'S'){
                y--;
            }else if(d == 'E'){
                x++;
            }else{
                x--;
            }
            if(!visited.add((x << 14) + y)){
                return true;
            }

        }

        return false;
    }


}
