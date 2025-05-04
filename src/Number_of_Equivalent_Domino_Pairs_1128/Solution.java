package Number_of_Equivalent_Domino_Pairs_1128;

public class Solution {

    public static void main(String[] args) {

    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] counter = new int[100];
        for (int i = 0; i < dominoes.length; i++) {
            int f = dominoes[i][0];
            int s = dominoes[i][1];
            int key = f > s ? s * 10 + f : f * 10 + s;
            counter[key]++;
            res += counter[key] - 1;
        }
        return res;
    }


}
