package Maximum_Units_on_a_Truck_1710;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {


    public static void main(String[] args) {

        int [][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        int truckSize = 10;
        System.out.println(maximumUnits(boxTypes,truckSize));

    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, Comparator.comparingInt(o->o[1]));
        int rst = 0;
        for (int i = boxTypes.length-1; i >=0 ; i--) {

            int numberOfBoxs = boxTypes[i][0];
            if(numberOfBoxs<truckSize){
                truckSize-=numberOfBoxs;
                rst += numberOfBoxs * boxTypes[i][1];
            }
            else if(numberOfBoxs>=truckSize){
                rst += truckSize*boxTypes[i][1];
                break;
            }

        }


        return rst;
    }

}
