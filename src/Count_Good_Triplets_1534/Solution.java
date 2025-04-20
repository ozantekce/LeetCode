package Count_Good_Triplets_1534;

public class Solution {


    public static void main(String[] args) {

    }


    public static int countGoodTriplets(int[] arr, int a, int b, int c) {

        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int val0 = arr[i];
            for (int j = i + 1; j < n; j++) {
                int val1 = arr[j];
                if (a < Math.abs(val0 - val1)) continue;
                for (int k = j + 1; k < n; k++) {
                    int val2 = arr[k];
                    if (b >= Math.abs(val1 - val2) && c >= Math.abs(val0 - val2)) res++;
                }
            }
        }
        return res;
    }

}
