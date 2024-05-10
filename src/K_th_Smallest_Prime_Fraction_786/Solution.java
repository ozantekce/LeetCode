package K_th_Smallest_Prime_Fraction_786;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 7}, 1)));

    }

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

        Temp [] array = new Temp[ (arr.length * (arr.length-1)) / 2];
        int l = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                array[l++] = new Temp(1d * arr[i]/arr[j], arr[i], arr[j]);
            }
        }
        Arrays.sort(array);

        Temp result = array[k - 1];
        return new int[]{result.v0, result.v1};
    }

    private static class Temp implements Comparable<Temp> {
        public double val;
        public int v0;
        public int v1;

        public Temp(double val, int v0, int v1) {
            this.val = val;
            this.v0 = v0;
            this.v1 = v1;
        }

        @Override
        public int compareTo(Temp other) {
            return Double.compare(this.val, other.val);
        }
    }
}
