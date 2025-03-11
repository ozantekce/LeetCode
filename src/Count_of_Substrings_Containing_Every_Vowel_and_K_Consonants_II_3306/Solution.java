package Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II_3306;

public class Solution {

    public static void main(String[] args) {

        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
        //System.out.println(countOfSubstrings("aeiou", 0));
        //System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
        //System.out.println(countOfSubstrings("aeiou", 0));
        //System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
        //System.out.println(countOfSubstrings("ieeaouqqieaouqq", 1));
        //System.out.println(countOfSubstrings("eauoiu", 1));

    }


    public static long countOfSubstrings(String word, int k) {
        int n = word.length();

        int[][] closestVowelIndices = new int[6][n];

        for (int v = 0; v < 5; v++) closestVowelIndices[v][n - 1] = n;
        int idx = getIndex(word.charAt(n - 1));
        closestVowelIndices[idx][n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            idx = getIndex(word.charAt(i));
            for (int v = 0; v < 5; v++) closestVowelIndices[v][i] = closestVowelIndices[v][i + 1];
            closestVowelIndices[idx][i] = i;
        }

        int[] nonVowelPrefixSums = new int[n + 1];
        int[] minIndexMapForPrefixSum = new int[n + 1];
        int[] maxIndexMapForPrefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            boolean isVowel = getIndex(word.charAt(i)) != 5;
            int sum = nonVowelPrefixSums[i + 1] = nonVowelPrefixSums[i] + (isVowel ? 0 : 1);
            if (minIndexMapForPrefixSum[sum] == 0) minIndexMapForPrefixSum[sum] = i + 1;
            maxIndexMapForPrefixSum[sum] = i + 1;
        }

        long res = 0;
        for (int start = 0; start <= n - 5 - k; start++) {

            int maxNonVowelCount = nonVowelPrefixSums[n] - nonVowelPrefixSums[start];
            if (maxNonVowelCount < k) break;

            int minIndexForAllVowels = -1;
            for (int v = 0; v < 5; v++) {
                minIndexForAllVowels = Math.max(closestVowelIndices[v][start], minIndexForAllVowels);
            }
            if (minIndexForAllVowels == n) break;

            int targetSum = k + nonVowelPrefixSums[start];

            int minIndexForTargetSum = Math.max(minIndexMapForPrefixSum[targetSum], minIndexForAllVowels + 1);
            int maxIndexForTargetSum = maxIndexMapForPrefixSum[targetSum];

            if (minIndexForTargetSum > maxIndexForTargetSum) continue;

            res += (maxIndexForTargetSum - minIndexForTargetSum + 1);
        }
        return res;
    }

    private static int getIndex(char c) {
        return switch (c) {
            case 'a' -> 0;
            case 'e' -> 1;
            case 'i' -> 2;
            case 'o' -> 3;
            case 'u' -> 4;
            default -> 5;
        };
    }

}
