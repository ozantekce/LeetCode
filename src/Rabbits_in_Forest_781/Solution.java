package Rabbits_in_Forest_781;

public class Solution {


    public static void main(String[] args) {

        System.out.println(numRabbits(new int[]{1, 1, 2}));
        System.out.println(numRabbits(new int[]{10, 10, 10}));
        System.out.println(numRabbits(new int[]{1, 0, 1, 0, 0}));
        System.out.println(numRabbits(new int[]{0, 0, 1, 1, 1}));

    }

    public static int numRabbits(int[] answers) {

        int max = 0;
        for (int i = 0; i < answers.length; i++) max = Math.max(answers[i], max);

        int[] counter = new int[max + 1];
        for (int i = 0; i < answers.length; i++) counter[answers[i]]++;

        int res = 0;
        for (int n = 0; n <= max; n++) {
            int c = counter[n];
            if (c <= 0) continue;
            int groupSize = n + 1;
            int groups = c / groupSize + (c % groupSize > 0 ? 1 : 0);
            res += groups * groupSize;
        }

        return res;
    }


}
