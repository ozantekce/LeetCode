package Find_Lucky_Integer_in_an_Array_1394;

public class Solution {

    public static void main(String[] args) {


        System.out.println(findLucky(new int[]{2,2,3,4}));
        System.out.println(findLucky(new int[]{1,2,2,3,3,3}));
        System.out.println(findLucky(new int[]{2,2,2,3,3}));

    }


    public static int findLucky(int[] arr) {


        int [] map = new int[501];

        for (int i = 0; i < arr.length; i++) map[arr[i]]++;

        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if(map[arr[i]]==arr[i]) max = Math.max(max,arr[i]);
        }

        return max;
    }

}
