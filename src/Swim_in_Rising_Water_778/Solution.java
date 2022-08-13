package Swim_in_Rising_Water_778;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {


        int [][] grid = {
                {0,1,2,3,4}
                ,{24,23,22,21,5}
                ,{12,13,14,15,16}
                ,{11,17,18,19,20}
                ,{10,9,8,7,6}
        };

/*
        int [][] grid = {
                {3,2}
                ,{0,1}
        };
        System.out.println(swimInWater(grid));//3
*/
/*
        int [][] grid = {
         {7,34,16,12,15,0}
        ,{10,26,4,30,1,20}
        ,{28,27,33,35,3,8}
        ,{29,9,13,14,11,32}
        ,{31,21,23,24,19,18}
        ,{22,6,17,5,2,25}
        };
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println("--------------------------------------------------------------------------------------------");
        */

        System.out.println(swimInWater(grid));//

    }


    private static int t=0;

    private static List<Swimmer> swimmerList;
    private static Swimmer [][] swimmers;

    private static int gridArea[][];
    public static int swimInWater(int[][] grid) {
        t=0;
        swimmers = new Swimmer[grid.length][grid.length];
        swimmerList = new ArrayList<>();
        gridArea = grid;
        Swimmer swimmer = new Swimmer(0,0);
        swimmers[0][0] = swimmer;
        swimmerList.add(swimmer);

        while (swimmers[grid.length-1][grid.length-1]==null){
            //int size = swimmerList.size();
            t++;
            for (int i = 0; i < swimmerList.size(); i++) {
                swimmerList.get(i).diffusion();
            }
            //printer();
        }



        return t;
    }

    public static class Swimmer{

        public int x,y;

        public Swimmer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void diffusion(){

            if(gridArea[x][y]>t)
                return;

            if(t==26){
                System.out.println("x : "+x+" y: "+y);
            }

            if(x+1<gridArea.length && gridArea[x+1][y]<=t){

                if(swimmers[x+1][y]==null){
                    swimmers[x+1][y] = new Swimmer(x+1,y);
                    swimmerList.add(swimmers[x+1][y]);
                    if(t==26){
                        System.out.println("1");
                    }
                }
            }
            if(x-1>=0 && gridArea[x-1][y]<=t){
                if(swimmers[x-1][y]==null){
                    swimmers[x-1][y] = new Swimmer(x-1,y);
                    swimmerList.add(swimmers[x-1][y]);
                    if(t==26){
                        System.out.println("2");
                    }
                }
            }
            if(y+1<gridArea.length && gridArea[x][y+1]<=t){
                if(swimmers[x][y+1]==null){
                    swimmers[x][y+1] = new Swimmer(x,y+1);
                    swimmerList.add(swimmers[x][y+1]);
                    if(t==26){
                        System.out.println("3");
                    }
                }
            }
            if(y-1>=0 && gridArea[x][y-1]<=t){
                if(swimmers[x][y-1]==null){
                    swimmers[x][y-1] = new Swimmer(x,y-1);
                    swimmerList.add(swimmers[x][y-1]);
                    if(t==26){
                        System.out.println("4");
                    }
                }
            }

        }

        @Override
        public String toString() {
            return "pull";
        }
    }

    public  static void printer(){
        System.out.println("t : "+t);
        for (int i = 0; i < swimmers.length; i++) {
            System.out.println(Arrays.toString(swimmers[i]));
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }




}
