package Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II_3306;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(countOfSubstrings("iqeaouqi", 2));
        System.out.println(countOfSubstrings("eeuiaoiucu", 0));
        //System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
        //System.out.println(countOfSubstrings("aeiou", 0));
        //System.out.println(countOfSubstrings("ieaouqqieaouqq", 1));
        //System.out.println(countOfSubstrings("ieeaouqqieaouqq", 1));
        //System.out.println(countOfSubstrings("eauoiu", 1));

    }


    private static int[] nonVowelPrefixSum;
    private static int[] prefixA, prefixE, prefixI, prefixO, prefixU;

    public static long countOfSubstrings(String word, int k) {

        int n = word.length();
        nonVowelPrefixSum = new int[n + 1];
        prefixA = new int[n + 1];
        prefixE = new int[n + 1];
        prefixI = new int[n + 1];
        prefixO = new int[n + 1];
        prefixU = new int[n + 1];

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            boolean isVowel;
            prefixA[i + 1] = prefixA[i] + (c == 'a' ? 1 : 0);
            prefixE[i + 1] = prefixE[i] + (c == 'e' ? 1 : 0);
            prefixI[i + 1] = prefixI[i] + (c == 'i' ? 1 : 0);
            prefixO[i + 1] = prefixO[i] + (c == 'o' ? 1 : 0);
            prefixU[i + 1] = prefixU[i] + (c == 'u' ? 1 : 0);
            isVowel = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
            nonVowelPrefixSum[i + 1] = nonVowelPrefixSum[i] + (isVowel ? 0 : 1);
        }

        long res = 0;
        for (int i = 0; i <= word.length() - 5 - k; i++) {
            int right = word.length() - i;
            int left = 5 + k;
            int maxSize = -1;
            int minSize = -1;

            if (!hasAllVowels(i, right) || getNonVowelCount(i, right) < k) {
                break;
            }

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int nonVowelCount = getNonVowelCount(i, mid);
                if (nonVowelCount < k) {
                    left = mid + 1;
                } else if (nonVowelCount > k) {
                    right = mid - 1;
                } else {
                    boolean hasAllVowels = hasAllVowels(i, mid);
                    if (hasAllVowels) maxSize = mid;
                    left = mid + 1;
                }
            }

            if (maxSize == -1) continue;

            minSize = maxSize;
            right = maxSize;
            left = 5 + k;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int nonVowelCount = getNonVowelCount(i, mid);
                if (nonVowelCount < k) {
                    left = mid + 1;
                } else if (nonVowelCount > k) {
                    right = mid - 1;
                } else {
                    boolean hasAllVowels = hasAllVowels(i, mid);
                    if (hasAllVowels) {
                        minSize = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            res += (maxSize - minSize + 1);
        }

        return res;
    }

    private static boolean hasAllVowels(int start, int size) {
        int end = start + size;
        return (prefixA[end] - prefixA[start] > 0) &&
                (prefixE[end] - prefixE[start] > 0) &&
                (prefixI[end] - prefixI[start] > 0) &&
                (prefixO[end] - prefixO[start] > 0) &&
                (prefixU[end] - prefixU[start] > 0);
    }

    private static int getNonVowelCount(int start, int size) {
        return nonVowelPrefixSum[start + size] - nonVowelPrefixSum[start];
    }
}
