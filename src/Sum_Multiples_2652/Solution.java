package Sum_Multiples_2652;

public class Solution {


    public int sumOfMultiples(int n) {

        boolean[] set = new boolean[n + 1];
        int res = 0;
        for (int i = 3; i <= n; i += 3) {
            if (!set[i]) {
                set[i] = true;
                res += i;
            }
        }
        for (int i = 5; i <= n; i += 5) {
            if (!set[i]) {
                set[i] = true;
                res += i;
            }
        }
        for (int i = 7; i <= n; i += 7) {
            if (!set[i]) {
                set[i] = true;
                res += i;
            }
        }

        return res;
    }

}
