package Group_the_People_Given_the_Group_Size_They_Belong_To_1282;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(groupThePeople(new int[]{2,1,3,3,3,2}));
        System.out.println(groupThePeople(new int[]{1}));

    }



    public static List<List<Integer>> groupThePeople(int[] groupSizes) {

        ArrayList<Integer>[] table = new ArrayList[groupSizes.length+1];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int num = groupSizes[i];
            if(table[num] == null){
                table[num] = new ArrayList<>(num);
            }
            table[num].add(i);
            if(table[num].size() == num){
                res.add(table[num]);
                table[num] = null;
            }
        }


        return res;
    }



}
