package Find_Unique_Binary_String_1980;

import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(findDifferentBinaryString(new String[]{"00", "01"}));
        System.out.println(findDifferentBinaryString(new String[]{"111", "011", "001"}));
    }

    public static String findDifferentBinaryString(String[] nums) {
        StringBuilder val = new StringBuilder(nums.length);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            val.append('0');
        }

        return find(val, 0, nums.length, set);
    }

    public static String find(StringBuilder val,
                              int index,
                              int targetSize,
                              HashSet<String> set) {
        if (index == targetSize) {
            String res = val.toString();
            if (!set.contains(res)) {
                return res;
            } else {
                return null;
            }
        }

        val.setCharAt(index, '1');
        String res = find(val, index + 1, targetSize, set);
        if (res != null) return res;
        val.setCharAt(index, '0');
        return find(val, index + 1, targetSize, set);
    }


}
