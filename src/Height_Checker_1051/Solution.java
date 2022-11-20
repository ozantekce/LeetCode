package Height_Checker_1051;
public class Solution {

    public static void main(String[] args) {

        int[] heights = {1,1,4,2,1,3};

        System.out.println(heightChecker(heights));

    }

    public static int heightChecker(int[] heights) {

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if(max<heights[i]){
                max = heights[i];
            }
        }
        int [] counting = new int[max+1];
        for (int i = 0; i < heights.length; i++) {
            counting[heights[i]]++;
        }

        Interval [] intervals = new Interval[counting.length];
        int minI = 0;
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = new Interval();
            intervals[i].min = minI;
            minI = intervals[i].max = minI+counting[i]-1;
            minI++;
        }

        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int val = i;
            if(val<=intervals[heights[i]].max && val>=intervals[heights[i]].min){

            }else{
                result++;
            }
        }

        return result;
    }

    private static class Interval{

        public int min;
        public int max;

    }

}
