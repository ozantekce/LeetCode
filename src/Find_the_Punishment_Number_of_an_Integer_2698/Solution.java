package Find_the_Punishment_Number_of_an_Integer_2698;

public class Solution {

    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
        System.out.println(punishmentNumber(37));
        System.out.println(punishmentNumber(1000));
    }


    public static int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int numSqr = i * i;
            if (isValid(numSqr, 0, i)) {
                res += numSqr;
            }
        }
        return res;
    }

    public static boolean isValid(int num,
                                  int globalValue,
                                  int target) {
        if (globalValue > target) return false;
        if (num == 0) return globalValue == target;
        int div = 1;
        while (num >= div) {
            int localValue = num / div;
            int remainingNum = num - localValue * div;
            if (isValid(remainingNum, globalValue + localValue, target)) return true;
            div *= 10;
        }
        return false;
    }

}
