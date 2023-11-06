package Form_Smallest_Number_From_Two_Digit_Arrays_2605;

public class Solution {




    public static void main(String[] args) {

        int [] nums1 = {3,5,2,6};
        int [] nums2 = {3,1,7};

        System.out.println(minNumber(nums1, nums2));


    }



    public static int minNumber(int[] nums1, int[] nums2) {

        int smallest1 = 10;
        int smallest2 = 10;

        int [] checker = new int[10];
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i]<smallest1)smallest1 = nums1[i];
            checker[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            if(nums2[i]<smallest2)smallest2 = nums2[i];
            checker[nums2[i]]++;
        }

        for (int i = 0; i < 10; i++) {
            if(checker[i]==2)return i;
        }

        if(smallest1>smallest2) return  smallest2*10+smallest1;
        else return smallest2+smallest1*10;
    }


}
