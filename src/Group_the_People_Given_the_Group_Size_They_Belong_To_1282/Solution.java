package Group_the_People_Given_the_Group_Size_They_Belong_To_1282;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(groupThePeople(new int[]{2,1,3,3,3,2}));
        System.out.println(groupThePeople(new int[]{1}));

    }



    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        ArrayList<Integer>[] table = new ArrayList[groupSizes.length+1];
        for (int i = 0; i < table.length; i++) {
            table[i] = new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int num = groupSizes[i];
            table[num].add(i);
            if(table[num].size() == num){
                ArrayList<Integer> temp = new ArrayList<>(table[num]);
                res.add(temp);
                table[num].clear();
            }
        }


        return res;
    }


}
