package Walking_Robot_Simulation_874;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Solution {


    public static void main(String[] args) {

        System.out.println(robotSim(new int[]{4,-1,3}, new int[][]{}));
        System.out.println(robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
        System.out.println(robotSim(new int[]{6,-1,-1,6}, new int[][]{}));

    }

    //  Commands
    //  -2 : turn_left  -> rot--
    //  -1 : turn_right -> rot++

    // Rotation
    //  0: +Y
    //  1: +X
    //  2: -Y
    //  3: -X


    private static int[][] Commands = new int[][]{
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };

    private static int Shift = 14;

    public static int robotSim(int[] commands, int[][] obstacles) {

        int x = 0;
        int y = 0;
        int maxDistance = 0;
        int rotation = 0;

        HashSet<Long> obstacleMap = new HashSet<>();

        for (int i = 0; i < obstacles.length; i++) {
            long o_x = obstacles[i][0];
            int o_y = obstacles[i][1];
            long key = (o_x << Shift) + o_y;
            obstacleMap.add(key);
        }

        UpperFor:
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if(command > 0){
                int[] forward = Commands[rotation];
                for (int j = 0; j < command; j++) {
                    long nextPosX = x + forward[0];
                    int nextPosY = y + forward[1];
                    long nextPosKey = (nextPosX << Shift) + nextPosY;
                    if(obstacleMap.contains(nextPosKey)){
                        continue UpperFor;
                    }
                    x = (int)nextPosX;
                    y = nextPosY;
                    maxDistance = Math.max(maxDistance, (x * x + y * y));
                }
            }else if(command == -1){
                rotation++;
                if(rotation > 3) rotation = 0;
            }else{
                rotation--;
                if(rotation < 0) rotation = 3;
            }
        }

        return maxDistance;
    }


}
