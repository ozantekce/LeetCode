package Sort_the_Students_by_Their_Kth_Score_2545;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

    }


    public static int[][] sortTheStudents(int[][] score, int k) {

        Int2[] array = new Int2[score.length];
        for (int i = 0; i < score.length; i++) {
            int [] student = score[i];
            array[i] = new Int2(student[k], i);
        }
        Arrays.sort(array);
        int[][] res = new int[score.length][score[0].length];
        for (int i = 0; i < array.length; i++) {
            res[i] = score[array[i].index];
        }


        return res;
    }

    private static class Int2 implements Comparable<Int2>
    {

        public int value;
        public int index;

        public Int2(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Int2 o) {
            return -Integer.compare(value, o.value);
        }
    }

}
