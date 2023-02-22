package Maximum_Product_of_Two_Elements_in_an_Array_1464;


public class Solution {


    public static void main(String[] args) {


        System.out.println(maxProduct(new int[]{3,4,5,2}));
        System.out.println(maxProduct(new int[]{1,5,4,5}));
        System.out.println(maxProduct(new int[]{3,7}));

    }

    public static int maxProduct(int[] nums) {
        int n1 = nums[0];
        int n2 = 0;
        for (int i = 1; i < nums.length; i++) {

            if(n1<=nums[i]){
                n2=n1;
                n1 = nums[i];
            }else if(n2<nums[i]){
                n2 = nums[i];
            }
        }
        return (n1-1)*(n2-1);
    }

}
