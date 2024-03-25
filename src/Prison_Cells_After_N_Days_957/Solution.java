package Prison_Cells_After_N_Days_957;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
        System.out.println(Arrays.toString(prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)));
        //System.out.println(Arrays.toString(prisonAfterNDays(new int[]{0,0,1,1,1,1,0,0}, 8)));

    }

    //  0, 0, 0, 0, 0, 0, 0, 0
    //  0, 1, 1, 1, 1, 1, 1, 0
    //  0, 0, 1, 1, 1, 1, 0, 0
    //  0, 0, 0, 1, 1, 0, 0, 0
    //  0, 1, 0, 0, 0, 0, 1, 0
    //  0, 1, 0, 1, 1, 0, 1, 0
    //  0, 1, 1, 0, 0, 1, 1, 0
    //  0, 0, 0, 0, 0, 0, 0, 0


    public static int[] prisonAfterNDays(int[] cells, int n) {

        int[] valueToIndex = new int[256];
        //Arrays.fill(valueToIndex, -1);
        int[] indexToValue = new int[256];
        //Arrays.fill(indexToValue, -1);

        int currentValue = convertToInt(cells);
        valueToIndex[currentValue] = 0;
        indexToValue[0] = currentValue;

        int i = 1;
        int insignificantPart = 0;
        while (true){

            currentValue = findNext(currentValue);
            if(valueToIndex[currentValue] != 0){
                insignificantPart = valueToIndex[currentValue];
                break;
            }

            if(i == n){
                return convertToBinary(currentValue);
            }else{
                valueToIndex[currentValue] = i;
                indexToValue[i] = currentValue;
                i++;
            }

        }

        int index = ((n-insignificantPart) % (i-insignificantPart)) + insignificantPart;
        return convertToBinary(indexToValue[index]);

    }


    private static int convertToInt(int[] cells){
        int val = 0;
        for (int i = 0; i < cells.length; i++) {
            val += cells[i]<<(7 - i);
        }
        return val;
    }

    private static int[] convertToBinary(int value){
        int[] binary = new int[8];
        int index = 7;

        while(value > 0){
            binary[index] = value % 2;
            value = value / 2;
            index--;
        }

        return binary;
    }


    private static int findNext(int cells) {
        int rightNeighbors = cells << 1;
        int leftNeighbors = cells >> 1;
        return ((rightNeighbors ^ leftNeighbors) ^ 0x7F) & 0x7E;
    }




}
