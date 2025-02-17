package Letter_Tile_Possibilities_1079;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
        System.out.println(numTilePossibilities("V"));
    }

    public static int numTilePossibilities(String tiles) {
        int counterSize = 0;
        int[] counter = new int[tiles.length() + 1];
        int[] indexMap = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            int j = tiles.charAt(i) - 'A';
            if (indexMap[j] == 0) {
                indexMap[j] = 1 + counterSize++;
            }
            counter[indexMap[j] - 1]++;
        }
        return find(0, counter, counterSize, tiles.length());
    }

    private static int find(int i,
                            int[] counter,
                            int counterSize,
                            int size) {
        if (i == size) return 0;
        int res = 0;
        for (int j = 0; j < counterSize; j++) {
            if (counter[j] == 0) continue;
            counter[j]--;
            res = res + 1 + find(i + 1, counter, counterSize, size);
            counter[j]++;
        }
        return res;
    }

}
