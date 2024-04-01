package Adding_Two_Negabinary_Numbers_1073;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        //System.out.println(Arrays.toString(addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1})));
        //System.out.println(Arrays.toString(addNegabinary(new int[]{0}, new int[]{0})));
        //System.out.println(Arrays.toString(addNegabinary(new int[]{0}, new int[]{1})));
        //System.out.println(Arrays.toString(addNegabinary(new int[]{0}, new int[]{1,0})));
        //System.out.println(Arrays.toString(addNegabinary(new int[]{1}, new int[]{1})));
        //System.out.println(Arrays.toString(addNegabinary(new int[]{1}, new int[]{1,1})));
        System.out.println(Arrays.toString(addNegabinary(new int[]{1}, new int[]{1,0,1})));

    }


    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        return add(arr1, arr2);
    }

    private static int[] add(int[] arr1, int[] arr2) {
        int maxLength = Math.max(arr1.length, arr2.length);

        int[] result = new int[maxLength + 2];

        int carry = 0;

        for (int i = 0; i < result.length; i++) {
            boolean isEven = (arr1.length - 1 - i) % 2 == 0;
            int val1 = (i < arr1.length) ? arr1[arr1.length - 1 - i] : 0;
            int val2 = (i < arr2.length) ? arr2[arr2.length - 1 - i] : 0;
            int res;
            if(isEven){
                int sum = val1 + val2 + carry;
                if(sum > 0){
                    res = sum % 2;
                    carry = sum / 2;
                }else if(sum < 0){
                    res = 1;
                    carry = -1;
                }else{
                    res = 0;
                    carry = 0;
                }
            }else{
                int sum = -val1 - val2 + carry;
                if(sum < 0){
                    res = sum % 2;
                    carry = sum / 2;
                }else if(sum > 0){
                    res = -1;
                    carry = +1;
                }else{
                    res = 0;
                    carry = 0;
                }
            }
            result[result.length - 1 - i] = res;
        }

        int remove = 0;
        boolean leading = true;
        for (int i = 0; i < result.length; i++) {

            if(leading && result[i] == 0){
                remove++;
                continue;
            }else{
                leading = false;
            }

            if(result[i] == -1){
                result[i] = 1;
            }
        }

        if (result[0] == 0) {
            if(remove != result.length)
                return Arrays.copyOfRange(result, remove, result.length);
            else
                return Arrays.copyOfRange(result, remove-1, result.length);
        }

        return result;

    }




}
