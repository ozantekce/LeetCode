package Element_Appearing_More_Than_25_In_Sorted_Array_1287;

public class Solution {


    public static void main(String[] args) {

        System.out.println(findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        System.out.println(findSpecialInteger(new int[]{1,1}));
        System.out.println(findSpecialInteger(new int[]{1,1}));

    }

    public static int findSpecialInteger(int[] arr) {

        int minSize = arr.length / 4;
        int maxStartIndex = arr.length - minSize;

        for (int i = 0; i <= maxStartIndex; i++) {
            if(arr[i] == arr[i + minSize])
                return arr[i];
        }

        return 0;
    }

}
