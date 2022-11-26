package Minimum_Lines_to_Represent_a_Line_Chart_2280;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

        int [][] stockPrices = {{1,7},{2,6},{3,5},{4,4},{5,4},{6,3},{7,2},{8,1}};
        System.out.println(minimumLines(stockPrices));

    }


    public static int minimumLines(int[][] stockPrices) {

        if(stockPrices.length<=1){
            return 0;
        }

        Arrays.sort(stockPrices, Comparator.comparingInt(o->o[0]));
        for (int i = 0; i < stockPrices.length; i++) {
            System.out.println(Arrays.toString(stockPrices[i]));
        }

        int lines = 1;
        BigDecimal difY = new BigDecimal((stockPrices[0][1]-stockPrices[1][1]));
        BigDecimal difX = new BigDecimal((stockPrices[0][0]-stockPrices[1][0]));
        BigDecimal currentSlope = difY.divide(difX, MathContext.DECIMAL128);
        for (int i = 1; i < stockPrices.length-1; i++) {

            difY = new BigDecimal((stockPrices[i][1]-stockPrices[i+1][1]));
            difX = new BigDecimal((stockPrices[i][0]-stockPrices[i+1][0]));
            BigDecimal slope = difY.divide(difX,MathContext.DECIMAL128);
            System.out.println(slope+" "+currentSlope);
            if(!slope.equals(currentSlope)){
                lines++;
            }
            currentSlope = slope;
        }

        return lines;
    }

}
