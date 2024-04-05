package Maximum_of_Absolute_Value_Expression_1131;


public class Solution {


    public static void main(String[] args) {

        //System.out.println(maxAbsValExpr(new int[]{1,2,3,4}, new int[]{-1,4,5,6}));
        System.out.println(maxAbsValExpr(new int[]{1,-2,-5,0,10}, new int[]{0,-2,-1,-7,-4}));

    }


    public static int maxAbsValExpr(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int max0 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int f0 = arr1[i] + arr2[i] + i;
            int f1 = arr1[i] - arr2[i] + i;
            int f2 = -arr1[i] + arr2[i] + i;
            int f3 = -arr1[i] - arr2[i] + i;

            max0 = Math.max(f0, max0);
            max1 = Math.max(f1, max1);
            max2 = Math.max(f2, max2);
            max3 = Math.max(f3, max3);

            min0 = Math.min(f0, min0);
            min1 = Math.min(f1, min1);
            min2 = Math.min(f2, min2);
            min3 = Math.min(f3, min3);
        }

        return Math.max(max0 - min0 , Math.max(max1 - min1, Math.max(max2 - min2, max3 - min3)));
    }


}
