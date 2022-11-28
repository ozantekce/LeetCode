package Pascals_Triangle_118;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        generate(5);

    }

    public static List<List<Integer>> generate(int numRows) {

        int size = 2;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        lists.add(firstRow);
        firstRow.add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = lists.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int value1=0;
                if(j-1>=0){
                    value1 = lastRow.get((j-1));
                }
                int value2 = 0;
                if(j<lastRow.size()){
                    value2 = lastRow.get(j);
                }
                currentRow.add(value1+value2);
            }
            lists.add(currentRow);
            size+=1;
        }
        return lists;
    }


}
