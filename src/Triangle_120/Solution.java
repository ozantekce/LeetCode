package Triangle_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        Solution solution = new Solution();
        long start = System.nanoTime();

        int [][] triangle = {{2},{3,4},{6,5,9},{4,4,8,0}};

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < triangle.length; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < triangle[i].length; j++) {
                list.get(i).add(triangle[i][j]);
            }

        }

        System.out.println(solution.minimumTotal(list));



        System.out.println((System.nanoTime()-start)/100000.0);
    }




    public int minimumTotal_Old(List<List<Integer>> triangle) {

        int DP[][] = new int[triangle.size()][triangle.size()];

        DP[0][0] = triangle.get(0).get(0);
        for (int row = 1; row < triangle.size() ; row++) {
            for (int col = 0; col < triangle.get(row).size(); col++) {

                if(col==0){
                    int sum = DP[row-1][0] + triangle.get(row).get(0);
                    DP[row][0] = sum;
                }else if(col == triangle.get(row).size()-1){
                    int sum = DP[row-1][col-1] + triangle.get(row).get(col);
                    DP[row][col] = sum;
                }
                else{
                    int sum1 = DP[row-1][col-1] + triangle.get(row).get(col);;
                    int sum2 = DP[row-1][col] + triangle.get(row).get(col);;
                    DP[row][col] = Math.min(sum1,sum2);
                }
                //System.out.print(" "+DP[row][col]);
            }
            //System.out.println();
        }
        int min =Integer.MAX_VALUE;
        for (int i = 0; i < DP[DP.length-1].length; i++) {
            if(DP[DP.length-1][i]<min){
                min = DP[DP.length-1][i];
            }
        }

        return min;
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        int lenght = (triangle.size() * (triangle.size()+1))/2;

        int data [] = new int[lenght];
        data [0] = triangle.get(0).get(0);
        int row=1;
        int col=0;
        int sub  = triangle.get(row-1).size();
        int size = 2;
        for (int i = 1; i < lenght; i++) {
            int val = triangle.get(row).get(col);
            if(col==0){
                data[i] = data[i-sub] + val;
                col++;
            }else if(col==size-1){
                data[i] = data[i-sub-1] + val;
                row++;
                col=0;
                sub = triangle.get(row-1).size();
                if(i!=lenght-1)
                    size = triangle.get(row).size();
            }else{
                data[i] = val +Math.min(
                        data[i-sub],
                        data[i-sub-1]
                );
                col++;
            }

        }

        int firstIndex = data.length-triangle.get(triangle.size()-1).size();
        int min = data[firstIndex];
        for (int i = firstIndex+1; i < data.length; i++) {
            if(data[i]<min){
                min = data[i];
            }
        }

        return min;
    }




}