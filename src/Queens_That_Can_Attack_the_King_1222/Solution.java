package Queens_That_Can_Attack_the_King_1222;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int [] king = {0,0};

        queensAttacktheKing(queens,king);

    }




    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        List<List<Integer>> answer = new ArrayList<>();

        int board [][] = new int[8][8];
        // 1: king | 2: queen

        board[king[0]][king[1]] = 1;

        for (int i = 0; i < queens.length; i++) {
            board[queens[i][0]][queens[i][1]] = 2;
        }


        List<Ray> rays = new ArrayList<>();
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i==0&&j==0)
                    continue;
                Ray ray = new Ray();
                ray.x = king[0];
                ray.y = king[1];
                ray.dirX = i;
                ray.dirY = j;
                rays.add(ray);
            }
        }

        while (!rays.isEmpty()){

            for (int i = 0; i < rays.size(); i++) {
                Ray ray = rays.get(i);
                if(ray.ControlQueen(board)){
                    //System.out.println("find");
                    List<Integer> temp = new ArrayList<>();
                    temp.add(ray.x);
                    temp.add(ray.y);
                    answer.add(temp);
                }
                ray.Move();
                if(!ray.isAlive){
                    rays.remove(ray);
                    i--;
                }
            }

        }


        return answer;
    }

    private static class Ray{

        int x;
        int y;

        int dirX;
        int dirY;

        boolean isAlive = true;

        public void Move(){
            x+=dirX;
            y+=dirY;
            if(x<0||x>=8||y<0||y>=8){
                isAlive = false;
            }
        }
        public boolean ControlQueen(int [][] board){

            if(board[x][y]==2){
                isAlive = false;
                return true;
            }
            return false;
        }



    }


}
