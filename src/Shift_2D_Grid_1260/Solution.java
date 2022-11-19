package Shift_2D_Grid_1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    
    
    public static void main(String[] args) {

        int [][] grid ={{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        shiftGrid(grid,4);

/*
        int [][] grid ={{1},{2},{3},{4},{7},{6},{5}};
        shiftGrid(grid,23);*/
    }


    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList=null;

        int length = grid.length*grid[0].length;
        int index;
        k = k%length;
        for (int i = 0; i < length; i++) {
            if(i%grid[0].length==0){
                subList = new ArrayList<Integer>();
                list.add(subList);
            }
            index = i-k;
            if(index<0){
                index+=length;
            }
            int row = index / grid[0].length;
            int col = index % grid[0].length;
            //System.out.println(grid[row][col]);
            subList.add(grid[row][col]);
        }


        //System.out.println(list);
        
        return list;
    }


}
