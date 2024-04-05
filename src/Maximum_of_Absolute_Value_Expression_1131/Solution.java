package Maximum_of_Absolute_Value_Expression_1131;


import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(maxAbsValExpr(new int[]{1,2,3,4}, new int[]{-1,4,5,6}));
        System.out.println(maxAbsValExpr(new int[]{1,-2,-5,0,10}, new int[]{0,-2,-1,-7,-4}));

    }


    public static int maxAbsValExpr(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int max0 = arr1[0] + arr2[0];
        int max1 = arr1[0] - arr2[0];
        int max2 = -arr1[0] + arr2[0];
        int max3 = -arr1[0] - arr2[0];

        int min0 = max0;
        int min1 = max1;
        int min2 = max2;
        int min3 = max3;

        for (int i = 1; i < n; i++) {
            int f0 = arr1[i] + arr2[i] + i;
            int f1 = arr1[i] - arr2[i] + i;
            int f2 = -arr1[i] + arr2[i] + i;
            int f3 = -arr1[i] - arr2[i] + i;

            if(f0 > max0) max0 = f0;
            else if (f0 < min0) min0 = f0;

            if(f1 > max1) max1 = f1;
            else if (f1 < min1) min1 = f1;

            if(f2 > max2) max2 = f2;
            else if (f2 < min2) min2 = f2;

            if(f3 > max3) max3 = f3;
            else if (f3 < min3) min3 = f3;
        }

        max0 -= min0;
        max1 -= min1;
        max2 -= min2;
        max3 -= min3;

        return Math.max(max0, Math.max(max1, Math.max(max2, max3)));
    }


}
