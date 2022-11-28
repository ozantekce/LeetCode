package Pascals_Triangle_II_119;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(getRow(3));

    }

    public static List<Integer> getRow(int rowIndex) {

        int size = 2;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        List<Integer> lastRow = firstRow;
        for (int i = 1; i <= rowIndex; i++) {
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
            lastRow = currentRow;
            size+=1;
        }
        return lastRow;
    }

}
