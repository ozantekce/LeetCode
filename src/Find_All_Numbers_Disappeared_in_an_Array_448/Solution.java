package Find_All_Numbers_Disappeared_in_an_Array_448;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {

        int [] nums ={1,1};
        System.out.println(findDisappearedNumbers(nums));

    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>(nums.length);
        Arrays.sort(nums);
        int pointer = 0;
        int val =1;
        while (true){
            if(pointer>=nums.length){

                if(val<=nums.length){
                    for (int i = val; i <= nums.length; i++) {
                        list.add(i);
                    }
                }

                break;
            }
            if(nums[pointer] == val){
                val++;
                pointer++;
            }else if(nums[pointer]>val){
                list.add(val);
                val++;

            }else{
                pointer++;
            }

        }

        //System.out.println(list);
        return list;
    }

}
