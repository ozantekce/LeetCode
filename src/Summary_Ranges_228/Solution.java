package Summary_Ranges_228;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(summaryRanges(new int[]{}));

    }


    public static List<String> summaryRanges(int[] nums) {

        if(nums.length == 0)
            return new ArrayList<>();

        List<String> list = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        int start = nums[0];
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if(current != last + 1){
                if(start == last){
                    stringBuilder.append(start);
                    list.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }else{
                    stringBuilder.append(start);
                    stringBuilder.append("->");
                    stringBuilder.append(last);
                    list.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                }

                start = current;
            }
            last = current;
        }

        if(start == last){
            stringBuilder.append(start);
            list.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }else{
            stringBuilder.append(start);
            stringBuilder.append("->");
            stringBuilder.append(last);
            list.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }

        return list;
    }


}
