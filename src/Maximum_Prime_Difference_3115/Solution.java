package Maximum_Prime_Difference_3115;


public class Solution {


    public static void main(String[] args) {

        System.out.println(maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
        //System.out.println(maximumPrimeDifference(new int[]{4, 8, 2, 8}));
        //System.out.println(maximumPrimeDifference(new int[]{80, 43, 53, 45, 100}));

    }

    private static boolean[] NonPrimes = nonPrimes(100);

    public static int maximumPrimeDifference(int[] nums) {

        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (!NonPrimes[nums[i]]){
                lastIndex = firstIndex = i;
                break;
            }
        }

        for (int i = nums.length - 1; i > firstIndex; i--) {
            if (!NonPrimes[nums[i]]){
                lastIndex = i;
                break;
            }
        }


        return lastIndex - firstIndex;
    }


    public static boolean[] nonPrimes(int n) {
        boolean nonPrimes[] = new boolean[n + 1];
        nonPrimes[0] = nonPrimes[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!nonPrimes[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    nonPrimes[j] = true;
                }
            }
        }
        return nonPrimes;
    }
}
