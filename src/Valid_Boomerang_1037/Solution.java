package Valid_Boomerang_1037;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(isBoomerang(new int[][]{{1,1},{2,3},{3,2}}));
        //System.out.println(isBoomerang(new int[][]{{1,1},{2,2},{3,3}}));
        //System.out.println(isBoomerang(new int[][]{{0,1},{0,1},{2,1}}));
        //System.out.println(isBoomerang(new int[][]{{0,0},{1,0},{2,2}}));
        //System.out.println(isBoomerang(new int[][]{{0,0},{2,0},{0,2}}));
        //System.out.println(isBoomerang(new int[][]{{0,1},{2,2},{2,0}}));
        System.out.println(isBoomerang(new int[][]{{73,31},{73,19},{73,45}}));


    }


    public static boolean isBoomerang(int[][] points) {

        int dir_0_X = points[0][0] - points[1][0];
        int dir_0_Y = points[0][1] - points[1][1];

        if(dir_0_X == 0 && dir_0_Y == 0) return false;

        float slope0;

        if(dir_0_X == 0){
            slope0 = Float.MAX_VALUE;
        }else{
            slope0 = (dir_0_Y * 1f) / dir_0_X;
        }
        //System.out.println(dir_0_Y +" "+ dir_0_X);
        int dir_1_X = points[0][0] - points[2][0];
        int dir_1_Y = points[0][1] - points[2][1];

        if(dir_1_X == 0 && dir_1_Y == 0) return false;

        float slope1;

        if(dir_1_X == 0){
            slope1 = Float.MAX_VALUE;
        }else{
            slope1 = (dir_1_Y *1f) / dir_1_X;
        }
        //System.out.println(dir_1_Y +" "+ dir_1_X);
        //System.out.println(slope0 +" | "+slope1);

        return slope0 != slope1;
    }


}
