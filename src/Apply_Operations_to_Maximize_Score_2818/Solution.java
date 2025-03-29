package Apply_Operations_to_Maximize_Score_2818;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        //System.out.println(maximumScore(new ArrayList<>(List.of(8, 3, 9, 3, 8)), 2));
        //System.out.println(maximumScore(new ArrayList<>(List.of(19, 12, 14, 6, 10, 18)), 3));
        //System.out.println(maximumScore(new ArrayList<>(List.of(3289, 2832, 14858, 22011)), 6));

        System.out.println(maximumScore(new ArrayList<>(List.of(
                1, 1, 87780, 1, 51870, 71610, 51297, 76850, 41716,
                68640, 99030, 59000, 58146, 97950, 90090, 9660, 53475,
                1, 39270, 79701, 54391, 73564, 44159, 25530, 1, 98210,
                81533, 1, 40810, 72259, 8489, 87780, 34631, 1, 1, 53759,
                38943, 1, 1, 46410, 33372, 18338, 80586, 25194, 42131,
                699, 29805, 10329, 48300, 99330, 1)), 736));

    }

    public static int maximumScore(List<Integer> list, int k) {

        int n = list.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = list.get(i);

        int minVal = nums[0];
        int maxVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
            }
            if (nums[i] > maxVal) {
                maxVal = nums[i];
            }
        }

        int[] selections = findSelections(nums, minVal, maxVal);
        int[] primeScores = findPrimeScores(nums, minVal, maxVal);

        int[] minLefts = findMinLefts(primeScores);
        int[] maxRights = findMaxRights(primeScores);

        int res = 1;
        int j = 0;
        while (k > 0) {
            int select = selections[j];
            int minLeft = minLefts[select];
            int maxRight = maxRights[select];
            int c = (select - minLeft + 1) * (maxRight - select + 1);
            int p = c < 0 || c > k ? k : c;
            int localRes = pow(nums[select], p);
            res = mul(res, localRes);
            k -= p;
            j++;
        }

        return res;
    }


    private static int mul(int a, int b) {
        long m = 1000000007;
        return (int) ((long) a * b % m);
    }

    private static int pow(int a, long b) {
        long m = 1000000007L;
        long result = 1;
        long base = a % m;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * base) % m;
            }
            base = (base * base) % m;
            b >>= 1;
        }

        return (int) result;
    }

    private static int[] findSelections(int[] nums, int minVal, int maxVal) {
        int range = maxVal - minVal + 1;
        int[] counts = new int[range];
        for (int num : nums) {
            counts[num - minVal]++;
        }

        for (int i = range - 2; i >= 0; i--) {
            counts[i] += counts[i + 1];
        }

        int[] outputIndices = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int mappedIndex = num - minVal;
            int position = counts[mappedIndex] - 1;
            outputIndices[position] = i;
            counts[mappedIndex]--;
        }

        return outputIndices;
    }

    private static int[] findPrimeScores(int[] nums, int minVal, int maxVal) {
        int[] scores = new int[nums.length];
        int[] cache = new int[maxVal - minVal + 1];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int score = 0;

            if (cache[num - minVal] != 0) {
                scores[i] = cache[num - minVal];
                continue;
            }

            int limit = (int) Math.sqrt(num);

            if (num % 2 == 0) {
                score++;
                while (num % 2 == 0) {
                    num /= 2;
                }
            }

            for (int j = 3; j <= limit && num > 1; j += 2) {
                if (num % j == 0) {
                    score++;
                    while (num % j == 0) {
                        num /= j;
                    }
                }
            }

            if (num > 1) score++;
            cache[nums[i] - minVal] = scores[i] = score;
        }

        return scores;
    }


    public static int[] findMaxRights(int[] scores) {
        Stack<Integer> stack = new Stack<>();
        stack.push(scores.length - 1);
        int[] res = new int[scores.length];
        res[scores.length - 1] = scores.length - 1;
        for (int i = scores.length - 2; i >= 0; i--) {
            int f = i;
            // remove less than self
            int stackSize = stack.size();
            while (!stack.isEmpty() && scores[i] > scores[stack.peek()]) {
                f = stack.peek();
                stack.pop();
            }
            if (!stack.isEmpty() && scores[stack.peek()] == scores[i]) {
                res[i] = res[stack.peek()];
            } else {
                if (stackSize != stack.size()) {
                    res[i] = res[f];
                } else {
                    res[i] = f;
                }
            }
            stack.push(i);
        }

        return res;
    }

    public static int[] findMinLefts(int[] scores) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] res = new int[scores.length];
        res[0] = 0;
        for (int i = 1; i < scores.length; i++) {
            int f = i;
            // remove less than self
            int stackSize = stack.size();
            while (!stack.isEmpty() && scores[i] > scores[stack.peek()]) {
                f = stack.peek();
                stack.pop();
            }

            if (stackSize != stack.size()) {
                res[i] = res[f];
            } else {
                res[i] = f;
            }

            stack.push(i);
        }

        return res;
    }


}
